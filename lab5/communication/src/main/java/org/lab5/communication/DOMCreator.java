package org.lab5.communication;

import org.lab5.communication.requests.*;
import org.lab5.communication.requests.notification.NotificationReq;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.nio.ByteBuffer;

public class DOMCreator {
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

    public static ByteBuffer createSendByteBuffer(Request request) throws TransformerException {
        Document document = null;
        switch (request.requestType) {
            case LOGIN -> document = createLoginXML(request);
            case CLIENTS_LIST_REQUEST -> document = createClientsListRequestXML();
            case CLIENTS_LIST_RECEIVE -> document = createClientListReceiveXML(request);
            case MESSAGE_FROM_CLIENT -> document = createMessageFromClientXML(request);
            case MESSAGE_FROM_SERVER -> document = createMessageFromServerXML(request);
            case MESSAGE_LIST -> document = createMessageListXML(request);
            case NOTIFICATION -> document = createNotificationXML(request);
        }

        StringWriter stringWriter = new StringWriter();
        transformer.transform(new DOMSource(document), new StreamResult(stringWriter));

        return ByteBuffer.wrap(stringWriter.getBuffer().toString().getBytes());
    }

    private static Document createLoginXML(Request request) {
        Document document = documentBuilder.newDocument();
        LoginReq loginReq = (LoginReq) request;

        Element commandElement = document.createElement("command");
        commandElement.setAttribute("name", "login");
        document.appendChild(commandElement);

        Element nameElement = document.createElement("name");
        nameElement.setTextContent(loginReq.nickname);
        commandElement.appendChild(nameElement);

        Element typeElement = document.createElement("name");
        typeElement.setTextContent("CHAT_CLIENT_NAME");
        commandElement.appendChild(typeElement);

        return document;
    }

    private static Document createClientsListRequestXML() {
        Document document = documentBuilder.newDocument();

        Element commandElement = document.createElement("command");
        commandElement.setAttribute("name", "request-clients-list");
        document.appendChild(commandElement);

        return document;
    }

    private static Document createClientListReceiveXML(Request request) {
        Document document = documentBuilder.newDocument();

        Element commandElement = document.createElement("command");
        commandElement.setAttribute("name", "receive-clients-list");
        document.appendChild(commandElement);

        ClientsListReceiveReq clientsListReceiveReq = (ClientsListReceiveReq) request;
        for (ClientData clientData : clientsListReceiveReq.listOfClients) {
            Element clientDataElement = document.createElement("nickname");
            clientDataElement.setTextContent(clientData.getNickname());

            commandElement.appendChild(clientDataElement);
        }

        return document;
    }

    private static Document createMessageFromClientXML(Request request) {
        Document document = documentBuilder.newDocument();

        Element commandElement = document.createElement("command");
        commandElement.setAttribute("name", "message-from-client");
        document.appendChild(commandElement);

        MessageFromClientReq messageFromClientReq = (MessageFromClientReq) request;
        Element messageElement = document.createElement("message");
        commandElement.setTextContent(messageFromClientReq.message);
        commandElement.appendChild(messageElement);

        return document;
    }

    private static Document createMessageFromServerXML(Request request) {
        Document document = documentBuilder.newDocument();

        Element commandElement = document.createElement("command");
        commandElement.setAttribute("name", "message-from-server");
        document.appendChild(commandElement);

        MessageFromServerReq messageFromServerReq = (MessageFromServerReq) request;
        Element nicknameElement = document.createElement("nickname");
        nicknameElement.setTextContent(messageFromServerReq.messageData.nickname);
        commandElement.appendChild(nicknameElement);

        Element messageElement = document.createElement("message");
        System.out.println(messageFromServerReq.messageData.message);
        messageElement.setTextContent(messageFromServerReq.messageData.message);
        commandElement.appendChild(messageElement);

        return document;
    }

    private static Document createMessageListXML(Request request) {
        Document document = documentBuilder.newDocument();

        Element commandElement = document.createElement("command");
        commandElement.setAttribute("name", "message-list");
        document.appendChild(commandElement);

        MessagesListReq messagesListReq = (MessagesListReq) request;
        for (MessageData messageData : messagesListReq.messagesList) {
            Element messageDataElement = document.createElement("messageData");

            Element nicknameElement = document.createElement("nickname");
            commandElement.setTextContent(messageData.message);
            messageDataElement.appendChild(nicknameElement);

            Element messageElement = document.createElement("message");
            messageDataElement.appendChild(messageElement);

            commandElement.appendChild(messageDataElement);
        }

        return document;
    }

    private static Document createNotificationXML(Request request) {
        Document document = documentBuilder.newDocument();

        Element commandElement = document.createElement("command");
        commandElement.setAttribute("name", "notification");
        document.appendChild(commandElement);

        NotificationReq notificationReq = (NotificationReq) request;
        Element notificationTypeElement = document.createElement("notificationType");
        notificationTypeElement.setTextContent(notificationReq.notificationData.notificationType.toString());
        commandElement.appendChild(notificationTypeElement);

        Element textElement = document.createElement("text");
        textElement.setTextContent(notificationReq.notificationData.notificationType.name());
        commandElement.appendChild(textElement);

        return document;
    }
}
