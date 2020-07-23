package designPatterns.behavioral.state;

/**
 * @author Ross Khapilov
 * @version 1.0 06.07.2019
 */
public abstract class State {
    Player player;
    /**
     * Контекст передаёт себя в конструктор состояния, чтобы состояние могло
     * обращаться к его данным и методам в будущем, если потребуется.
     */
    State(Player player) {
        this.player = player;
    }

    public abstract String onLock();
    public abstract String onPlay();
    public abstract String onNext();
    public abstract String onPrevious();
}
