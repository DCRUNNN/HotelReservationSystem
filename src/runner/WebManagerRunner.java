package runner;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import rmi.WebManagerRemoteHelper;

public class WebManagerRunner {
	
	private WebManagerRemoteHelper remoteHelper;
	
	public WebManagerRunner(){
		
		linkToServer();
	}

	private void linkToServer() {
		
		try {
			remoteHelper = WebManagerRemoteHelper.getInstance();
			remoteHelper.serRemote(Naming.lookup("rmi://localhost:5555/WebManagerDataRemoteObject"));
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
		
		new WebManagerRunner();
	}



}
