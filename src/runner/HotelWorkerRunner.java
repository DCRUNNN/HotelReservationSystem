package runner;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import rmi.HotelWorkerRemoteHelper;

public class HotelWorkerRunner {

	private HotelWorkerRemoteHelper remoteHelper;
	
	public HotelWorkerRunner(){
		
		linkToServer();
	}

	private void linkToServer() {
		
		try {
			remoteHelper = HotelWorkerRemoteHelper.getInstance();
			remoteHelper.serRemote(Naming.lookup("rmi://localhost:7777/HotelWorkerDataRemoteObject"));
			System.out.println("linked");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	

	public static void main(String args[]){
		
		new HotelWorkerRunner();
	}


}
