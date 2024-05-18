package org.lab5.communication;

import org.lab5.communication.requests.Request;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.List;
import java.util.Map;

public class SendReceiveRequest {
    public static void broadCast(Request request, List<Map.Entry<SocketChannel, TransferProtocol>> clientsList)
            throws IOException, TransformerException {
        ByteBuffer buffer = null;
        for (Map.Entry<SocketChannel, TransferProtocol> client : clientsList) {
            switch (client.getValue()) {
                case SERIALIZABLE -> buffer = ObjectSerialize.createSendByteBuffer(request);
                case XML -> buffer = DOMCreator.createSendByteBuffer(request);
            }
            client.getKey().write(buffer);
        }
    }

    public static void sendRequest(Request request, SocketChannel socketChannel, TransferProtocol transferProtocol)
            throws IOException, TransformerException {

        ByteBuffer buffer = null;
        switch (transferProtocol) {
            case SERIALIZABLE -> buffer = ObjectSerialize.createSendByteBuffer(request);
            case XML -> buffer = DOMCreator.createSendByteBuffer(request);
        }
        socketChannel.write(buffer);
    }

    public static Request receiveRequest(SocketChannel socketChannel, TransferProtocol transferProtocol)
            throws IOException, ClassNotFoundException, ParserConfigurationException, SAXException {

        Request request = null;
        switch (transferProtocol) {
            case SERIALIZABLE -> request = ObjectSerialize.createReceiveRequest(socketChannel);
            case XML -> request = DOMParser.createReceiveRequest(socketChannel);
        }
        return request;
    }
}
