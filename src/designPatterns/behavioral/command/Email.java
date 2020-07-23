package designPatterns.behavioral.command;

/**
 * There would be a different type of jobs that can be executed. The following are the different concrete classes whose instances
 * will be executed by the different command objects.
 * @author Ross Khapilov
 * @version 1.0 05.07.2019
 */
public class Email {
    public void sendEmail(){
        System.out.println("Sending Email......");
    }
}
