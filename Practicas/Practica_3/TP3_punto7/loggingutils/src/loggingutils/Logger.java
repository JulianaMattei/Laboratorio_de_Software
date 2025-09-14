package loggingutils;

import java.util.logging.Level;

public class Logger {

    private static Logger loggerInstance;
    private final java.util.logging.Logger internalLogger;

    private Logger(){
        internalLogger = java.util.logging.Logger.getLogger(this.getClass().getName());
    }

    public static Logger getLoggerInstance() {
        if (loggerInstance == null) {
            loggerInstance = new Logger();
        }
        return loggerInstance;
    }

    public void logInfo(String mensaje){
        internalLogger.log(Level.INFO, mensaje);
    }

    public void logWarning(String mensaje){
        internalLogger.log(Level.WARNING, mensaje);
    }

    public void logError(String mensaje){
        internalLogger.log(Level.SEVERE, mensaje);
    }

}
