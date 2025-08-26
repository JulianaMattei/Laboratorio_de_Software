package punto4;

public class Logger {
    public Logger loggerInstance;

    private Logger(){}

    public Logger getLoggerInstance() {
        if (this.loggerInstance == null) {
            loggerInstance = new Logger();
        }
        return loggerInstance;
    }

    public void logInfo(String mensaje){
        System.out.println("[INFO] " + mensaje);
    }
    public void logWarning(String mensaje){
        System.out.println("[WARNING] " + mensaje);
    }
    public void logError(String mensaje){
        System.out.println("[ERROR] " + mensaje);
    }
}
