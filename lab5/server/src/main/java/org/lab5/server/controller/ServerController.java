package org.lab5.server.controller;

import org.lab5.communication.SendReceiveRequest;
import org.lab5.communication.requests.Request;
import org.lab5.server.model.ServerModel;
import org.lab5.server.server.RequestHandler;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class ServerController {
    private ServerModel model;

    private Selector selector;
    private ServerSocketChannel serverSocket;

    public void setServerModel(ServerModel serverModel) {
        this.model = serverModel;
    }

    public void initialServer() throws IOException {
        selector = Selector.open();
        serverSocket = ServerSocketChannel.open();
        serverSocket.bind(new InetSocketAddress("localhost", model.getServerPort()));
        serverSocket.configureBlocking(false);
        serverSocket.register(selector, SelectionKey.OP_ACCEPT);
    }

    public void channelsHandler() throws IOException, ClassNotFoundException {
        while (true) {
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> selectionKeysIterator = selectionKeys.iterator();

            while (selectionKeysIterator.hasNext()) {
                SelectionKey selectionKey = selectionKeysIterator.next();

                if (selectionKey.isAcceptable()) {
                    System.out.println("isAcceptable");
                    registeringNewClient(selector, serverSocket);
                }

                if (selectionKey.isReadable()) {
                    /* сделать проверку на то что открытый клиентский канал */

                    System.out.println("isReadable");
                    Request request = SendReceiveRequest.receiveRequest((SocketChannel) selectionKey.channel());
                    RequestHandler.handle(request, (SocketChannel) selectionKey.channel(), model);
                }

                selectionKeysIterator.remove();
            }
        }
    }

    private void registeringNewClient(Selector selector, ServerSocketChannel serverSocket) throws IOException {
        SocketChannel clientSocket = serverSocket.accept();
        clientSocket.configureBlocking(false);
        clientSocket.register(selector, SelectionKey.OP_READ);
    }
}
