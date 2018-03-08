package runner;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import presentation.personnelui_hotelWorker.hotelpersonnel.ManageStrategy.InitManageStrategyView;
import rmi.HotelWorkerRemoteHelper;
import service.Strategy.ManageHotelStrategy.ManageHotelStrategyService;
import vo.StrategyVO;

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
	
	public void test (){
		
		ManageHotelStrategyService service = remoteHelper.getManageHotelStrategyService();
		try {
			List<StrategyVO> volist = service.getAllHotelStrategy("1");
			for(StrategyVO vo:volist){
				System.out.println(vo.getName());
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String args[]){
		
		HotelWorkerRunner runner = new HotelWorkerRunner();
		runner.test();
	}


}
