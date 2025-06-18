package singleton;

public class Main {
    public static void main(String[] args) {
        // Get two references to the Logger
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Use the logger
        logger1.log("This is the first log message.");
        logger2.log("This is the second log message.");

        // Test if both references point to the same object
        if (logger1 == logger2) {
            System.out.println("Both logger1 and logger2 are the same instance.");
        } else {
            System.out.println("Different instances detected! Singleton pattern not implemented correctly.");
        }
    }
}
