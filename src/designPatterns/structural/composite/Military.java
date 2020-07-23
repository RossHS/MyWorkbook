package designPatterns.structural.composite;

import java.util.List;

/**
 * @author Ross Khapilov
 * @version 1.0 24.06.2019
 */
public abstract class Military {
    private String rank;

    public String getRank(){
        return rank;
    }

    public Military(String rank) {
        this.rank = rank;
    }

    public abstract void setOrder(String order);

    public void addChildMilitary(Military military) {
        throw new UnsupportedOperationException("Current operation is not supported for this object");
    }

    public void removeChildMilitary(Military military) {
        throw new UnsupportedOperationException("Current operation is not supported for this object");
    }

    public List<Military> getChildren() {
        throw new UnsupportedOperationException("Current operation is not supported for this object");
    }

    public abstract void executeTheOrder();

}


