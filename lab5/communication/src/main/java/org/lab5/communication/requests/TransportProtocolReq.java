package org.lab5.communication.requests;

public class TransportProtocolReq extends Request {
    public final byte transportProtocolByte;

    public TransportProtocolReq(byte transportProtocolByte) {
        super(RequestType.TRANSPORT_PROTOCOL);
        this.transportProtocolByte = transportProtocolByte;
    }
}
