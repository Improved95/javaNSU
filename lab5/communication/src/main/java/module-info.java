module communication {
    requires java.xml;
//    requires log4j.api;
    requires org.apache.logging.log4j;

    exports org.lab5.communication;
    exports org.lab5.communication.requests;
    exports org.lab5.communication.requests.notification;
    exports org.lab5.communication.communicate;
}