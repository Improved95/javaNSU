package org.lab5.server.controller;

import org.lab5.communication.communicate.Receiver;
import org.lab5.communication.communicate.SendReceiveRequest;
import org.lab5.communication.TransferProtocol;
import org.lab5.communication.requests.Request;
import org.lab5.server.model.ServerModel;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ServerChannelsHandler implements Runnable {
    public ServerModel model;
    public ServerController controller;

    public final Selector selector;
    private boolean continueChannelsHandler = true;

    private Receiver receiver = new Receiver();

    public ServerChannelsHandler(ServerModel model, ServerController controller, Selector selector) {
        this.model = model;
        this.controller = controller;
        this.selector = selector;
    }

    public void channelsHandler() throws IOException, ClassNotFoundException, SAXException, ParserConfigurationException, TransformerException {
        while (continueChannelsHandler) {
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> selectionKeysIterator = selectionKeys.iterator();

            while (selectionKeysIterator.hasNext()) {
                SelectionKey selectionKey = selectionKeysIterator.next();

                if (selectionKey.isAcceptable()) {
                    controller.registeringNewClient(selector, model.getServerSocketChannel());
                }

                if (selectionKey.isReadable()) {
                    TransferProtocol transferProtocol = model.getClientTable().get(selectionKey.channel()).transferProtocol;
                    List<Request> requestList = SendReceiveRequest.receiveRequest((SocketChannel) selectionKey.channel(), transferProtocol, receiver);
                    if (requestList == null) {
                        controller.deleteClient((SocketChannel) selectionKey.channel());
                    } else {
                        for (Request request : requestList) {
                            ServerRequestHandler.handle(request, (SocketChannel) selectionKey.channel());
                        }
                    }
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
        } catch (IOException | ClassNotFoundException | SAXException | ParserConfigurationException |
                 TransformerException ex) {
            ex.printStackTrace();
        }
    }
}
