package org.lab5.communication;

import org.lab5.communication.requests.Request;
import org.lab5.communication.requests.TransportProtocolReq;

import java.io.*;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NotYetConnectedException;
import java.nio.channels.SocketChannel;
import java.util.Set;

public class SendReceiveRequest {
    public static void broadCast(Request request, Set<SocketChannel> socketChannelSet) throws IOException {
        ByteBuffer buffer = ObjectSerialize.createSendByteBuffer(request);
        for (SocketChannel socketChannel : socketChannelSet) {
            socketChannel.write(buffer);
        }
    }

    public static void sendRequest(Request request, SocketChannel socketChannel, TransferProtocol transferProtocol) throws IOException {
        ByteBuffer buffer = null;
        switch (transferProtocol) {
            case SERIALIZABLE -> buffer = ObjectSerialize.createSendByteBuffer(request);
            case XML -> {}
        }
        socketChannel.write(buffer);
    }

    public static Request receiveRequest(SocketChannel socketChannel, TransferProtocol transferProtocol) throws IOException, ClassNotFoundException {
        Request request = null;
        switch (transferProtocol) {
            case SERIALIZABLE -> request = ObjectSerialize.createRequestFromByteBuffer(socketChannel);
            case XML -> {}
        }
        return request;
    }
}
