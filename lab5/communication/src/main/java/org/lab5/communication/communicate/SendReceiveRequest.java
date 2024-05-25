package org.lab5.communication.communicate;

import org.lab5.communication.DOMCreator;
import org.lab5.communication.DOMParser;
import org.lab5.communication.ObjectSerialize;
import org.lab5.communication.TransferProtocol;
import org.lab5.communication.requests.Request;
import org.xml.sax.SAXException;

import javax.xml.transform.TransformerException;
import java.io.*;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NotYetConnectedException;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SendReceiveRequest {
    private final static int bufferSize = 1024;

    public static void broadCast(Request request, List<Map.Entry<SocketChannel, TransferProtocol>> clientsList, Sender sender)
            throws IOException, TransformerException {
        ByteBuffer buffer = null;
        for (Map.Entry<SocketChannel, TransferProtocol> client : clientsList) {
            switch (client.getValue()) {
                case SERIALIZABLE -> buffer = ObjectSerialize.createSendByteBuffer(request);
                case XML -> buffer = DOMCreator.createSendByteBuffer(request);
            }

            ByteBuffer dataByteBufferWithDataSize = ByteBuffer.allocate(4 + buffer.capacity());
            dataByteBufferWithDataSize.putInt(buffer.capacity());
            dataByteBufferWithDataSize.put(4, buffer.array());
            dataByteBufferWithDataSize.rewind();

            sender.addSendDataBuffer(client.getKey(), dataByteBufferWithDataSize);
        }
    }

    public static void sendRequest(Request request, SocketChannel socketChannel, TransferProtocol transferProtocol, Sender sender)
            throws IOException, TransformerException {

        ByteBuffer buffer = null;
        switch (transferProtocol) {
            case SERIALIZABLE -> buffer = ObjectSerialize.createSendByteBuffer(request);
            case XML -> buffer = DOMCreator.createSendByteBuffer(request);
        }

        ByteBuffer dataByteBufferWithDataSize = ByteBuffer.allocate(4 + buffer.capacity());
        dataByteBufferWithDataSize.putInt(buffer.capacity());
        dataByteBufferWithDataSize.put(4, buffer.array());
        dataByteBufferWithDataSize.rewind();

        sender.addSendDataBuffer(socketChannel, dataByteBufferWithDataSize);
    }

    public static List<Request> receiveRequest(SocketChannel socketChannel, TransferProtocol transferProtocol, Receiver receiver)
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

        List<ByteBuffer> receiveDataList = receiver.readReceiveBytes(receiveBuffer, bytesRead);

        List<Request> requestList = new ArrayList<>();
        for (ByteBuffer receiveData : receiveDataList) {
            switch (transferProtocol) {
                case SERIALIZABLE -> requestList.add(ObjectSerialize.createReceiveRequest(receiveData));
                case XML -> requestList.add(DOMParser.createReceiveRequest(receiveData));
            }
        }

        return requestList;
    }
}
