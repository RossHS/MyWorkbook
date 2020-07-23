package designPatterns.structural.facade;

/**
 * Фасад — это структурный паттерн проектирования, который предоставляет простой интерфейс
 * к сложной системе классов, библиотеке или фреймворку.
 * <p>
 * Когда вам нужно представить простой или урезанный интерфейс к сложной подсистеме.
 * <p>
 * Часто подсистемы усложняются по мере развития программы. Применение большинства паттернов приводит к появлению
 * меньших классов, но в бóльшем количестве. Такую подсистему проще повторно использовать, настраивая её каждый
 * раз под конкретные нужды, но вместе с тем, применять подсистему без настройки становится труднее.
 * Фасад предлагает определённый вид системы по умолчанию, устраивающий большинство клиентов.
 * <p>
 * Когда вы хотите разложить подсистему на отдельные слои.
 * <p>
 * Используйте фасады для определения точек входа на каждый уровень подсистемы. Если подсистемы зависят друг
 * от друга, то зависимость можно упростить, разрешив подсистемам обмениваться информацией только через фасады.
 * <p>
 * Например, возьмём ту же сложную систему видеоконвертации. Вы хотите разбить её на слои работы с аудио и видео.
 * Для каждой из этих частей можно попытаться создать фасад и заставить классы аудио и видео обработки общаться друг с другом через эти фасады, а не напрямую.
 *
 * @author Ross Khapilov
 * @version 1.0 26.06.2019
 */
public class Test {
    public static void main(String[] args) {
        ScheduleServer scheduleServer = new ScheduleServer();
        ScheduleServerFacade facade = new ScheduleServerFacade(scheduleServer);

        //т.е. мы упростили методику работы с объектом, путем предоставления удобного интерфейса
        facade.startServer();
        facade.stopServer();
    }
}
