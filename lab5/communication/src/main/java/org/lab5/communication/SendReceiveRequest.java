package org.lab5.communication;

import org.lab5.communication.requests.Request;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.*;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NotYetConnectedException;
import java.nio.channels.SocketChannel;
import java.util.List;
import java.util.Map;

public class SendReceiveRequest {
    private final static int bufferSize = 1024 * 3;

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
            throws IOException, ClassNotFoundException, SAXException {
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

        Request request = null;
        switch (transferProtocol) {
            case SERIALIZABLE -> request = ObjectSerialize.createReceiveRequest(receiveBytes);
            case XML -> request = DOMParser.createReceiveRequest(receiveBytes);
        }
        return request;
    }
}
