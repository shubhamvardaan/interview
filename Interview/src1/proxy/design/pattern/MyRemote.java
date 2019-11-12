package proxy.design.pattern;

import java.rmi.*;

public interface MyRemote extends Remote {
	public String sayHello() throws RemoteException;
}
