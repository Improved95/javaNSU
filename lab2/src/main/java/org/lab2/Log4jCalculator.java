package org.lab2;

import org.slf4j.*;

public class Log4jCalculator {

    private static final Logger log = (Logger) LoggerFactory.getLogger(Log4jCalculator.class);

    public static void main(String[] args) {
        log.info("Some info");
        log.error("error");
    }
}
