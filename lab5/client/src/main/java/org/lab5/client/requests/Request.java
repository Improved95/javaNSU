package org.lab5.client.requests;

import java.io.Serializable;

public class Request implements Serializable {
    public final RequestType requestType;

    public Request(RequestType requestType) {
        this.requestType = requestType;
    }
}
