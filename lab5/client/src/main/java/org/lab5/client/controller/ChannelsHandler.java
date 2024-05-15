package org.lab5.client.controller;

import org.lab5.client.model.ClientModel;
import org.lab5.communication.SendReceiveRequest;
import org.lab5.communication.requests.Request;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class ChannelsHandler implements Runnable {
    public final ClientModel model;
    public final Selector selector;
    private boolean continueChannelsHandler = true;

    public ChannelsHandler(ClientModel model, Selector selector) {
        this.model = model;
        this.selector = selector;
    }

    public void channelsHandler() throws IOException, ClassNotFoundException {
        while (continueChannelsHandler) {
            selector.select();
            Set<SelectionKey> selectionKeySet = selector.selectedKeys();
            Iterator<SelectionKey> selectionKeysIterator = selectionKeySet.iterator();

            while (selectionKeysIterator.hasNext()) {
                SelectionKey selectionKey = selectionKeysIterator.next();

                if (selectionKey.isReadable()) {
                    Request request = SendReceiveRequest.receiveRequest((SocketChannel) selectionKey.channel());
                    ClientRequestHandler.handle(request, model);
                }

                selectionKeysIterator.remove();
            }
        }
    }

    public void stopChannelsHandle() {
        this.continueChannelsHandler = false;
    }

    @Override
    public void run() {
        try {
            channelsHandler();
        } catch (IOException | RuntimeException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
