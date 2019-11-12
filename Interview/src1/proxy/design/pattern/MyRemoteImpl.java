package proxy.design.pattern;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {
	public static final long serialVersionUID = 1L;

	public String sayHello() {
		return "hello shubham.";
	}

	MyRemoteImpl() throws RemoteException {
	}

	public static void main(String[] args) {
		try {
			MyRemote service = new MyRemoteImpl();
			Naming.bind("remoteShubham", service);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
