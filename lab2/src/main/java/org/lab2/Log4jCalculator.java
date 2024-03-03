package org.lab2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jCalculator {
    private static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        logger.trace("Trace");
    }
}
