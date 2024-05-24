package org.lab5.communication.communicate;

import java.nio.ByteBuffer;

public class Receiver {
    private final int INT_SIZE = 4;

    private final ByteBuffer messageSizeBuffer = ByteBuffer.allocate(INT_SIZE);
    private ByteBuffer messageBuffer;

    private int messageSize = 0;
    private int readBytes = 0;

    public void readReceiveBytes(ByteBuffer byteBuffer) {
        if (readBytes < INT_SIZE) {
            byteBuffer.get(0, messageSizeBuffer.array(), 0, INT_SIZE - readBytes);
            readBytes = messageSizeBuffer.position();
            if (messageSizeBuffer.position() == INT_SIZE) {
                messageSizeBuffer.rewind();
                messageSize = messageSizeBuffer.getInt();
                messageBuffer = ByteBuffer.allocate(messageSize);
            }
        }
        if (messageSizeBuffer.position() == INT_SIZE) {
            byteBuffer.get(0, messageBuffer.array(), 0, messageSize);
            if (messageBuffer.position() == messageSize) {

            }
        }
    }
}
