package designPatterns.behavioral.command;

/**
 * @author Ross Khapilov
 * @version 1.0 05.07.2019
 */
public class LoggingJob implements Job {
    private Logging logging;

    public void setLogging(Logging logging) {
        this.logging = logging;
    }

    @Override
    public void run() {
        System.out.println("Job ID: " + Thread.currentThread().getId() + " executing logging jobs.");
        if (logging != null) logging.log();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}