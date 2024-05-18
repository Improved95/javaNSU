package org.lab5.communication;

import org.lab5.communication.requests.ClientsListReceiveReq;
import org.lab5.communication.requests.ClientsListRequestReq;
import org.lab5.communication.requests.LoginReq;
import org.lab5.communication.requests.Request;
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
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NotYetConnectedException;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

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
            case ("receive-clients-list") -> request = createClientListReceiveFromXML(commandElement);
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

    private static Request createClientListReceiveFromXML(Element commandElement) {
        List<ClientData> clientDataList = new ArrayList<>();

        NodeList nodeList = commandElement.getChildNodes();
        int len = nodeList.getLength();
        for (int i = 0; i < len; ++i) {
            String clientNickname = nodeList.item(i).getTextContent();
            ClientData clientData = new ClientData(null);
            clientData.setNickname(clientNickname);
            clientDataList.add(clientData);
        }

        return new ClientsListReceiveReq(clientDataList);
    }
}