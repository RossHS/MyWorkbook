package designPatterns.creational.prototype;

/**
 * @author Ross Khapilov
 * @version 1.0 22.06.2019
 */
public class AccessControl implements Prototype {

    private final String controlLevel;
    private String access;

    public AccessControl(String controlLevel, String access) {
        this.controlLevel = controlLevel;
        this.access = access;
    }

    @Override
    public AccessControl clone() {
        try {
            return (AccessControl) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getControlLevel() {
        return controlLevel;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }
}
