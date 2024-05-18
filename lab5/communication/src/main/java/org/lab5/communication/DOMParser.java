package org.lab5.communication;

import org.lab5.communication.requests.*;
import org.lab5.communication.requests.notification.NotificationReq;
import org.lab5.communication.requests.notification.NotificationType;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NotYetConnectedException;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

public class DOMParser {
    private static int bufferSize = 1024;
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

    private static TransformerFactory transformerFactory = TransformerFactory.newInstance();
    private static Transformer transformer;
    static {
        try {
            transformer = transformerFactory.newTransformer();
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    public static Request createReceiveRequest(SocketChannel socketChannel)
            throws IOException, SAXException, ParserConfigurationException {

        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        ByteBuffer receiveBuffer = ByteBuffer.allocate(bufferSize);

        int bytesRead;
        try {
            bytesRead = socketChannel.read(receiveBuffer);
            System.out.println("bytes read " + bytesRead);
        } catch (SocketException | NotYetConnectedException | ClosedChannelException ex) {
            return null;
        }

        if (bytesRead == - 1) { return null; }

        byte[] receiveBytes = new byte[bytesRead];
        receiveBuffer.flip();
        receiveBuffer.get(receiveBytes);

        Document document = documentBuilder.parse(new ByteArrayInputStream(receiveBytes));

        /*Transformer transformer = null;
        try {
            transformer = transformerFactory.newTransformer();
            StringWriter stringWriter = new StringWriter();
            transformer.transform(new DOMSource(document), new StreamResult(stringWriter));

            System.out.println(stringWriter.getBuffer().toString());
        } catch (TransformerException ex) {
            ex.printStackTrace();
        }*/

        document.getDocumentElement().normalize();
        Element commandElement = (Element) document.getElementsByTagName("command").item(0);

        String requestType = document.getDocumentElement().getAttribute("name");
        Request request = null;
        switch (requestType) {
            case ("login") -> request = createLoginRequestFromXML(commandElement);
            case ("request-clients-list") -> request = createClientListRequestFromXML();
            case ("receive-clients-list") -> request = createClientListReceiveRequestFromXML(commandElement);
            case ("message-from-client") -> request = createMessageFromClientRequestFromXML(commandElement);
            case ("message-from-server") -> request = createMessageFromServerRequestFromXML(commandElement);
            case ("message-list") -> request = createMessageListRequestFromXML(commandElement);
            case ("notification") -> request = createNotificationRequestFromXML(commandElement);

        }
        return request;
    }

    private static Request createLoginRequestFromXML(Element commandElement) {
        String name = commandElement.getElementsByTagName("name").item(0).getTextContent();
        return new LoginReq(name);
    }

    private static Request createClientListRequestFromXML() {
        return new ClientsListRequestReq();
    }

    private static Request createClientListReceiveRequestFromXML(Element commandElement) {
        List<ClientData> clientDataList = new ArrayList<>();

        NodeList nodeList = commandElement.getElementsByTagName("nickname");
        int len = nodeList.getLength();
        for (int i = 0; i < len; ++i) {
            String clientNickname = nodeList.item(i).getTextContent();
            ClientData clientData = new ClientData(null);
            clientData.setNickname(clientNickname);
            clientDataList.add(clientData);
        }

        return new ClientsListReceiveReq(clientDataList);
    }

    private static Request createMessageFromClientRequestFromXML(Element commandElement) {
        String message = commandElement.getElementsByTagName("message").item(0).getTextContent();
        return new MessageFromClientReq(message);
    }

    private static Request createMessageFromServerRequestFromXML(Element commandElement) {
        String nickname = commandElement.getElementsByTagName("nickname").item(0).getTextContent();
        String message = commandElement.getElementsByTagName("message").item(0).getTextContent();

        return new MessageFromServerReq(new MessageData(nickname, message));
    }

    private static Request createMessageListRequestFromXML(Element commandElement) {
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

    private static Request createNotificationRequestFromXML(Element commandElement) {
        String notificationType = commandElement.getElementsByTagName("notificationType").item(0).getTextContent();
        String text = commandElement.getElementsByTagName("text").item(0).getTextContent();

        NotificationData notificationData = new NotificationData(NotificationType.valueOf(notificationType), text);
        return new NotificationReq(notificationData);
    }
}
