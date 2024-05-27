module communication {
    requires java.xml;
//    requires log4j.api;
//    requires java.logging;
//    requires slf4j.api;

    exports org.lab5.communication;
    exports org.lab5.communication.requests;
    exports org.lab5.communication.requests.notification;
    exports org.lab5.communication.communicate;
}