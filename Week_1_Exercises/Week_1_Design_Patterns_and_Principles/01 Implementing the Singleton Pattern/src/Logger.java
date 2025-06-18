package singleton;

public class Logger {
    // Step 1: Create a private static instance
    private static Logger instance;

    // Step 2: Private constructor to prevent instantiation
    private Logger() {
        System.out.println("Logger initialized.");
    }

    // Step 3: Public static method to get the instance
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();  // lazy initialization
        }
        return instance;
    }

    // Utility logging method
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}
