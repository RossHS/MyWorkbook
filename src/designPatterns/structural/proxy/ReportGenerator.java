package designPatterns.structural.proxy;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author Ross Khapilov
 * @version 1.0 26.06.2019
 */
public interface ReportGenerator extends Remote {
    String generateDailyReport() throws RemoteException;
}
