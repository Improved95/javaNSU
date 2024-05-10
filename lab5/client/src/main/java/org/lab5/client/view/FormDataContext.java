package org.lab5.client.view;

public class FormDataContext {
    public final String IP;
    public final String socket;
    public final String nickname;

    public FormDataContext(String IP, String socket, String nickname) {
        this.IP = IP;
        this.socket = socket;
        this.nickname = nickname;
    }
}
