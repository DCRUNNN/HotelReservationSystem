package presentation.personnelui.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import presentation.personnelui.WebSaler.ManageWebStrategy.ManageWebStrategyControllerService;
import rmi.WebSalerRemoteHelper;
import service.Strategy.ManageWebsiteStrategy.ManageWebsiteStrategyService;
import vo.ClientVO;
import vo.StrategyVO;

public class ManageWebStrategyUiController implements ManageWebStrategyControllerService{

	ManageWebsiteStrategyService strategyservice=WebSalerRemoteHelper.getInstance().getManageWebsiteStrategyService();
	Vector<Vector<String>> strategyvo;
	List<StrategyVO> volist;
	Vector<Vector<String>> change(List<StrategyVO> list) throws RemoteException {
           Vector<Vector<String>> result=new Vector<Vector<String>>();
		for(StrategyVO vo:list){
			Vector<String> vector=new Vector<String>();
			String strategyid=vo.getStrategyID();
			String strategyname=vo.getName();
		
			String begintime=vo.getBeginTime();
			String endtime=vo.getEndTime();
			String usertype=vo.getUserType();

			String discount=String.valueOf(vo.getStrategy_discount());
			
			vector.addElement(strategyid);
			vector.add(strategyname);
			vector.add(begintime);
			vector.add(endtime);
			vector.add(usertype);
	
			vector.add(discount);
			
			result.add(vector);
		}
		return result;
		
	}
	@Override
	public Vector<Vector<String>> getAllWebsiteStrategy() {
	
		try {
			volist=strategyservice.getAllWebsiteStrategy();
			strategyvo=change(volist);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return strategyvo;
	}

	@Override
	public boolean addStrategy(StrategyVO strategyVO) {
		boolean result=false;
		try {
			result=strategyservice.addStrategy(strategyVO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean changeStrategy(StrategyVO strategyVO)  {
		StrategyVO vo=null;
		boolean q=false;
		try {
			q = strategyservice.changeStrategy(vo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return q;
	}

	@Override
	public boolean deleteStrategy(String strategyID) {
		boolean q=false;
		try {
			q = strategyservice.deleteStrategy(strategyID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return q;
	}
	@Override
	public StrategyVO getStrategyVO(String strategyid) {
		StrategyVO vo=null;
		try {
			volist=strategyservice.getAllWebsiteStrategy();
			for(int i=0;i<volist.size();i++){
				if(volist.get(i).getStrategyID().equals(strategyid)){
					vo=volist.get(i);
				}
		}
		}catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vo;
	}
	@Override
	public List<String> getAllProvinces()  {
		List<String> provinces=new ArrayList<String>();
		try {
			provinces = strategyservice.getAllProvinces();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return provinces;
	}
	@Override
	public List<String> getCities(String province) {
		List<String> cities=new ArrayList<String>();
		try{
			cities=strategyservice.getCities(province);
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return cities;
	}
	@Override
	public List<String> getCBDS(String province, String city)  {
		List<String> cbds=new ArrayList<String>();
		try{
			cbds=strategyservice.getCBDS(province, city);
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return cbds;
	}
	


}
