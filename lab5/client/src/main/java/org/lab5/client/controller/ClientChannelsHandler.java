package org.lab5.client.controller;

import org.lab5.client.model.ClientModel;
import org.lab5.client.view.ViewStage;
import org.lab5.communication.communicate.Receiver;
import org.lab5.communication.communicate.SendReceiveRequest;
import org.lab5.communication.requests.Request;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ClientChannelsHandler implements Runnable {
//    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    private final ClientModel model;
    private final ClientController controller;

    private final Selector selector;
    private boolean continueChannelsHandler = true;

    private Receiver receiver = new Receiver();

    public ClientChannelsHandler(ClientModel model, ClientController controller, Selector selector) {
        this.model = model;
        this.controller = controller;
        this.selector = selector;
    }

    public void channelsHandler() throws IOException, ClassNotFoundException, SAXException {
        while (continueChannelsHandler) {
            selector.select();
            Set<SelectionKey> selectionKeySet = selector.selectedKeys();
            Iterator<SelectionKey> selectionKeysIterator = selectionKeySet.iterator();

            while (selectionKeysIterator.hasNext()) {
                SelectionKey selectionKey = selectionKeysIterator.next();

                if (selectionKey.isReadable()) {
                    List<Request> requestList = SendReceiveRequest.receiveRequest((SocketChannel) selectionKey.channel(), model.getTransferProtocol(), receiver);
                    if (requestList == null) {
                        controller.stopConnection();
                        model.setViewStage(ViewStage.CONNECT_FORM);
                    }
                    for (Request request : requestList) {
                        ClientRequestHandler.handle(request, model);
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
        } catch (RuntimeException  ex) {
//            logger.error("fatal error in channels handler ", ex);
            throw new RuntimeException();
        } catch (IOException | ClassNotFoundException | SAXException ex) {
//            logger.error("exception in channelsHandler ", ex);
        }
    }
}
