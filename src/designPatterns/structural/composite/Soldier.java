package designPatterns.structural.composite;

/**
 * @author Ross Khapilov
 * @version 1.0 24.06.2019
 */
public class Soldier extends Military {
    private String order;

    public Soldier(String rank) {
        super(rank);
    }

    @Override
    public void setOrder(String order) {
        this.order = order;
    }

    @Override
    public void executeTheOrder() {
        System.out.println("rank = " + getRank() + ", order = " + order + ";");
    }
}
