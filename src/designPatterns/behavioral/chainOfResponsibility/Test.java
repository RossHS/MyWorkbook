package designPatterns.behavioral.chainOfResponsibility;

/**
 * Цепочка обязанностей — это поведенческий паттерн проектирования, который позволяет передавать
 * запросы последовательно по цепочке обработчиков. Каждый последующий обработчик решает,
 * может ли он обработать запрос сам и стоит ли передавать запрос дальше по цепи.
 * <p>
 * Когда программа должна обрабатывать разнообразные запросы несколькими способами, но заранее неизвестно,
 * какие конкретно запросы будут приходить и какие обработчики для них понадобятся.
 * <p>
 * С помощью Цепочки обязанностей вы можете связать потенциальных обработчиков в одну цепь и при получении
 * запроса поочерёдно спрашивать каждого из них, не хочет ли он обработать запрос.
 * <p>
 * Когда важно, чтобы обработчики выполнялись один за другим в строгом порядке.
 * <p>
 * Цепочка обязанностей позволяет запускать обработчиков последовательно один за другим в том порядке,
 * в котором они находятся в цепочке.
 * <p>
 * Когда набор объектов, способных обработать запрос, должен задаваться динамически.
 * <p>
 * В любой момент вы можете вмешаться в существующую цепочку и переназначить связи так,
 * чтобы убрать или добавить новое звено.
 *
 * @author Ross Khapilov
 * @version 1.0 27.06.2019
 */
public class Test {
    public static void main(String[] args) {
        File file = null;
        Handler textHandler = new TextFileHandler("Text Handler");
        Handler docHandler = new DocFileHandler("Doc Handler");
        Handler audioHandler = new AudioFileHandler("Audio Handler");
        Handler videoHandler = new VideoFileHandler("Video Handler");

        textHandler.setHandler(docHandler);
        docHandler.setHandler(audioHandler);
        audioHandler.setHandler(videoHandler);

        file = new File("Abc.mp3", "audio", "c:");
        textHandler.process(file);
        System.out.println();

        file = new File("Abc.mvk", "video", "c:");
        textHandler.process(file);
        System.out.println();

        file = new File("Abc.bat", "bat", "c:");
        textHandler.process(file);
    }
}
