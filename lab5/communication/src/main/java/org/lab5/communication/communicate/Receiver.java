package org.lab5.communication.communicate;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class Receiver {
    private final int INT_SIZE = 4;

    private ReceiveStatus receiveStatus = ReceiveStatus.READ_DATA_SIZE;

    private final ByteBuffer dataSizeBuffer = ByteBuffer.allocate(INT_SIZE);
    private ByteBuffer dataBuffer;

    private int dataSize = 0;
    private int readBytesForData = 0;
    private int readBytesInCurrentIteration = 0;

    private List<ByteBuffer> dataBuffersList;

    private void fillDataSizeBuffer(ByteBuffer receiveByteBuffer, int byteBufferSize) {
        if (receiveStatus == ReceiveStatus.READ_DATA_SIZE) {
            if (byteBufferSize - readBytesInCurrentIteration >= INT_SIZE - readBytesForData) {
                dataSizeBuffer.put(readBytesForData, receiveByteBuffer, readBytesInCurrentIteration, INT_SIZE - readBytesForData);
                readBytesInCurrentIteration += INT_SIZE - readBytesForData;
                readBytesForData = INT_SIZE;
            } else {
                dataSizeBuffer.put(readBytesForData, receiveByteBuffer, readBytesInCurrentIteration, byteBufferSize - readBytesInCurrentIteration);
                readBytesForData += byteBufferSize - readBytesInCurrentIteration;
                readBytesInCurrentIteration += byteBufferSize - readBytesInCurrentIteration;
            }

            if (readBytesForData == INT_SIZE) {
                dataSizeBuffer.rewind();
                dataSize = dataSizeBuffer.getInt();
                dataBuffer = ByteBuffer.allocate(dataSize);
                receiveStatus = ReceiveStatus.READ_DATA;
            }
        }
    }

    private void fillDataBuffer(ByteBuffer receiveByteBuffer, int byteBufferSize) {
        if (receiveStatus == ReceiveStatus.READ_DATA) {
            if (byteBufferSize - readBytesInCurrentIteration >= dataSize) {
                dataBuffer.put((readBytesForData - INT_SIZE), receiveByteBuffer, readBytesInCurrentIteration, dataSize - (readBytesForData - INT_SIZE));
                readBytesInCurrentIteration += dataSize - (readBytesForData - INT_SIZE);
                readBytesForData += dataSize - (readBytesForData - INT_SIZE);
            } else {
                dataBuffer.put((readBytesForData - INT_SIZE), receiveByteBuffer, readBytesInCurrentIteration, byteBufferSize - readBytesInCurrentIteration);
                readBytesForData += byteBufferSize - readBytesInCurrentIteration;
                readBytesInCurrentIteration += byteBufferSize - readBytesInCurrentIteration;
            }

            if (readBytesForData - 4 == dataSize) {
                dataBuffersList.add(dataBuffer);
                receiveStatus = ReceiveStatus.READ_DATA_SIZE;
                readBytesForData = 0;
            }
        }
    }

    public List<ByteBuffer> readReceiveBytes(ByteBuffer receiveByteBuffer, int byteBufferSize) {
        dataBuffersList = new ArrayList<>();
        readBytesInCurrentIteration = 0;
        receiveByteBuffer.rewind();

        while (readBytesInCurrentIteration < byteBufferSize) {
            fillDataSizeBuffer(receiveByteBuffer, byteBufferSize);
            fillDataBuffer(receiveByteBuffer, byteBufferSize);
        }

        return dataBuffersList;
    }

    private enum ReceiveStatus {
        READ_DATA_SIZE, READ_DATA, WAIT_NEW_DATA
    }
}
