package designPatterns.structural.facade;

/**
 * сам фасад, для упрощения работы со сложной системой
 *
 * @author Ross Khapilov
 * @version 1.0 26.06.2019
 */
public class ScheduleServerFacade {

    private final ScheduleServer scheduleServer;

    public ScheduleServerFacade(ScheduleServer scheduleServer) {
        this.scheduleServer = scheduleServer;
    }

    public void startServer() {
        scheduleServer.startBooting();
        scheduleServer.readSystemConfiguration();
        scheduleServer.init();
        scheduleServer.initializeContext();
        scheduleServer.initializeListeners();
        scheduleServer.createSystemObjects();
    }

    public void stopServer() {
        scheduleServer.destroy();
        scheduleServer.stopServer();
    }
}
