package runner;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import rmi.ClientRemoteHelper;
import vo.CreditVO;

public class ClientRunner {

	private ClientRemoteHelper remoteHelper;
	
	public ClientRunner(){
		
		linkToServer();
	}

	private void linkToServer() {
		
		try {
			remoteHelper = ClientRemoteHelper.getInstance();
			remoteHelper.setRemote(Naming.lookup("rmi://localhost:8888/ClientDataRemoteObject"));
			System.out.println("linked");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	public void test(){
		
		try {
			List<CreditVO> volist = remoteHelper.getShowCreditRecordService().ShowAllCredit("0000001");
			
			System.out.println(volist.size());
			//String provinces = remoteHelper.getBrowseHotelService().getProvinces();
			//System.out.println(provinces);
		} catch (RemoteException e) {
			
			e.printStackTrace();
		}
		
	}
	public static void main(String args[]){
		
		ClientRunner runner =new ClientRunner();
		runner.test();
	}
}
