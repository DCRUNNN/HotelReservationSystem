package runner;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import rmi.HotelWorkerRemoteHelper;
import rmi.WebSalerRemoteHelper;

public class WebSalerRunner {

	private WebSalerRemoteHelper remoteHelper;
	
	public WebSalerRunner(){
		
		linkToServer();
	}

	private void linkToServer() {
		
		try {
			remoteHelper = WebSalerRemoteHelper.getInstance();
			remoteHelper.serRemote(Naming.lookup("rmi://localhost:6666/WebSalerDataRemoteObject"));
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
		
		new WebSalerRunner();
	}


}
