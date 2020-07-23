package designPatterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ross Khapilov
 * @version 1.0 24.06.2019
 */
public class Officer extends Military {
    private List<Military> childrenMilitary;
    private String order;

    public Officer(String rank) {
        super(rank);
        childrenMilitary = new ArrayList<>();
    }

    @Override
    public void setOrder(String order) {
        this.order = order;
    }

    @Override
    public void addChildMilitary(Military military) {
        if (!this.equals(military)) //чтобы было нельзя добавить элемент в самого себя
            childrenMilitary.add(military);
    }

    @Override
    public void removeChildMilitary(Military military) {
        childrenMilitary.remove(military);
    }

    @Override
    public List<Military> getChildren() {
        return childrenMilitary;
    }

    @Override
    public void executeTheOrder() {
        System.out.println("rank = " + getRank() + ", order = " + order + ";");
        for (Military mil : childrenMilitary)
            mil.executeTheOrder();

    }
}
