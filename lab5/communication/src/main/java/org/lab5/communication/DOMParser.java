package org.lab5.communication;

import org.lab5.communication.requests.*;
import org.lab5.communication.requests.notification.NotificationReq;
import org.lab5.communication.requests.notification.NotificationType;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class DOMParser {
    private static DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
    private static DocumentBuilder documentBuilder;
    static {
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    public static Request createReceiveRequest(ByteBuffer receiveBytes)
            throws IOException, SAXException {

        Document document = documentBuilder.parse(new ByteArrayInputStream(receiveBytes.array()));

        document.getDocumentElement().normalize();
        Element commandElement = (Element) document.getElementsByTagName("command").item(0);

        String requestType = document.getDocumentElement().getAttribute("name");
        Request request = null;
        switch (requestType) {
            case ("login") -> request = createLoginFromXML(commandElement);
            case ("request-clients-list") -> request = createClientListRequestFromXML();
            case ("receive-clients-list") -> request = createClientListReceiveFromXML(commandElement);
            case ("message-from-client") -> request = createMessageFromClientFromXML(commandElement);
            case ("message-from-server") -> request = createMessageFromServerFromXML(commandElement);
            case ("message-list") -> request = createMessageListFromXML(commandElement);
            case ("notification") -> request = createNotificationFromXML(commandElement);
        }
        return request;
    }

    private static Request createLoginFromXML(Element commandElement) {
        String name = commandElement.getElementsByTagName("name").item(0).getTextContent();
        return new LoginReq(name);
    }

    private static Request createClientListRequestFromXML() {
        return new ClientsListRequestReq();
    }

    private static Request createClientListReceiveFromXML(Element commandElement) {
        List<ClientDataForReq> clientDataForReqList = new ArrayList<>();

        NodeList nodeList = commandElement.getElementsByTagName("nickname");
        int len = nodeList.getLength();
        for (int i = 0; i < len; ++i) {
            String clientNickname = nodeList.item(i).getTextContent();
            ClientDataForReq clientDataForReq = new ClientDataForReq(clientNickname);
            clientDataForReqList.add(clientDataForReq);
        }

        return new ClientsListReceiveReq(clientDataForReqList);
    }

    private static Request createMessageFromClientFromXML(Element commandElement) {
        String message = commandElement.getElementsByTagName("message").item(0).getTextContent();
        return new MessageFromClientReq(message);
    }

    private static Request createMessageFromServerFromXML(Element commandElement) {
        String nickname = commandElement.getElementsByTagName("nickname").item(0).getTextContent();
        String message = commandElement.getElementsByTagName("message").item(0).getTextContent();

        return new MessageFromServerReq(new MessageData(nickname, message));
    }

    private static Request createMessageListFromXML(Element commandElement) {
        List<MessageData> messageDataList = new ArrayList<>();

        NodeList messageDataListXML = commandElement.getElementsByTagName("messageData");
        int length = messageDataListXML.getLength();
        for (int i = 0; i < length; ++i) {
            Element messageDataXML = (Element) messageDataListXML.item(i);
            String nickname = messageDataXML.getElementsByTagName("nickname").item(0).getTextContent();
            String message = messageDataXML.getElementsByTagName("message").item(0).getTextContent();
            messageDataList.add(new MessageData(nickname, message));
        }

        return new MessagesListReq(messageDataList);
    }

    private static Request createNotificationFromXML(Element commandElement) {
        String notificationType = commandElement.getElementsByTagName("notificationType").item(0).getTextContent();
        String text = commandElement.getElementsByTagName("text").item(0).getTextContent();

        NotificationData notificationData = new NotificationData(NotificationType.valueOf(notificationType), text);
        return new NotificationReq(notificationData);
    }
}
