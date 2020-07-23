package designPatterns.behavioral.observer;

/**
 * @author Ross Khapilov
 * @version 1.0 27.06.2019
 */
public class SMSUsers implements Observer {
    private final Subject subject;
    private String desc;
    private String userInfo;

    public SMSUsers(Subject subject, String userInfo) {
        if (subject == null) {
            throw new IllegalArgumentException("No Publisher found.");
        }
        this.subject = subject;
        this.userInfo = userInfo;
    }

    @Override
    public void update(String desc) {
        this.desc = desc;
        display();
    }

    private void display() {
        System.out.println("[" + userInfo + "]: " + desc);
    }

    @Override
    public void subscribe() {
        System.out.println("Subscribing " + userInfo + " to " + subject.subjectDetails() + " ...");
        this.subject.subscribeObserver(this);
        System.out.println("Subscribed successfully.");
    }

    @Override
    public void unsubcribe() {
        System.out.println("Unsubscribing " + userInfo + " to " + subject.subjectDetails() + " ...");
        this.subject.unsubscribeObserver(this);
        System.out.println("Unsubscribed successfully.");
    }
}
