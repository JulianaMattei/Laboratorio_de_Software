package test;

import loggingutils.Logger;

public class Main {

    public static void main(String[] args) {
        Logger logger = Logger.getLoggerInstance();

        logger.logInfo("Mensaje de info");
        logger.logWarning("Mensaje de warning");
        logger.logError("Mensaje de error");
    }
}
