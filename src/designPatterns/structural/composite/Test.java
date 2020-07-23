package designPatterns.structural.composite;

/**
 * Компоновщик — это структурный паттерн проектирования, который позволяет сгруппировать множество объектов в
 * древовидную структуру, а затем работать с ней так, как будто это единичный объект.
 * Когда вам нужно представить древовидную структуру объектов.
 * <p>
 * Паттерн Компоновщик предлагает хранить в составных объектах ссылки на другие простые или составные объекты.
 * Те, в свою очередь, тоже могут хранить свои вложенные объекты и так далее. В итоге вы можете строить
 * сложную древовидную структуру данных, используя всего две основные разновидности объектов.
 * <p>
 * Когда клиенты должны единообразно трактовать простые и составные объекты.
 * <p>
 * Благодаря тому, что простые и составные объекты реализуют общий интерфейс, клиенту безразлично, с каким именно объектом ему предстоит работать.
 *
 * @author Ross Khapilov
 * @version 1.0 24.06.2019
 */
public class Test {
    public static void main(String[] args) {
        Military parentGeneral = new Officer("General");
        parentGeneral.setOrder("Очистить базу");

        Military parentOfficer = new Officer("Officer");
        parentOfficer.setOrder("Выполнить приказ по очистке базы");

        parentGeneral.addChildMilitary(parentOfficer);

        Military soldierSniper= new Soldier("Soldier sniper");
        soldierSniper.setOrder("Занять вышку");
        parentOfficer.addChildMilitary(soldierSniper);

        Military soldierForces = new Soldier("Soldier forces");
        soldierForces.setOrder("Ворваться на базу");
        parentOfficer.addChildMilitary(soldierForces);

        //выполнить все команды "главного" компонента и его "листьев"
        parentGeneral.executeTheOrder();
    }
}
