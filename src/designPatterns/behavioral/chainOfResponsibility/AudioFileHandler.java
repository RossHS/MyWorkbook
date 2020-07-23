package designPatterns.behavioral.chainOfResponsibility;

/**
 * @author Ross Khapilov
 * @version 1.0 27.06.2019
 */
public class AudioFileHandler implements Handler {

    private Handler handler;
    private String handlerName;

    public AudioFileHandler(String handlerName) {
        this.handlerName = handlerName;
    }

    @Override
    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void process(File file) {
        if (file.getFileType().equals("audio")) {
            System.out.println("Process and saving audio file by " + handlerName);
        } else if (handler != null) {
            System.out.println(handlerName + " forward request to " + handler.getHandlerName());
            handler.process(file);
        } else System.out.println("File not support");
    }

    @Override
    public String getHandlerName() {
        return handlerName;
    }
}
