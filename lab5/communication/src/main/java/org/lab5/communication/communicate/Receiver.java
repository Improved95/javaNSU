package org.lab5.communication.communicate;

import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.Deque;

public class Receiver {
    private final int INT_SIZE = 4;

    private ReceiveStatus receiveStatus = ReceiveStatus.READ_DATA_SIZE;

    private final ByteBuffer dataSizeBuffer = ByteBuffer.allocate(INT_SIZE);
    private ByteBuffer dataBuffer;

    private int dataSize = 0;
    private int readBytes = 0;

    Deque<ByteBuffer> dataBuffersDeque = new ArrayDeque<>();

    public Deque<ByteBuffer> readReceiveBytes(ByteBuffer receiveByteBuffer) {
        while (receiveByteBuffer.hasRemaining()) {
            if (receiveStatus == ReceiveStatus.READ_DATA_SIZE) {
                receiveByteBuffer.get(0, dataSizeBuffer.array(), 0, INT_SIZE - readBytes);
                readBytes = dataSizeBuffer.position();

                if (dataSizeBuffer.position() == INT_SIZE) {
                    dataSizeBuffer.rewind();
                    dataSize = dataSizeBuffer.getInt();
                    dataBuffer = ByteBuffer.allocate(dataSize);
                    receiveStatus = ReceiveStatus.READ_DATA;
                }
            }

            if (receiveStatus == ReceiveStatus.READ_DATA) {
                receiveByteBuffer.get(0, dataBuffer.array(), 0, dataSize);
                readBytes += dataBuffer.position();
                if (dataBuffer.position() == dataSize) {
                    dataBuffersDeque.addLast(dataBuffer);
                    receiveStatus = ReceiveStatus.READ_DATA_SIZE;
                }
            }
        }

        return dataBuffersDeque;
    }

    private enum ReceiveStatus {
        READ_DATA_SIZE, READ_DATA, WAIT_NEW_DATA
    }
}
