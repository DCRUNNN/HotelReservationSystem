package presentation.personnelui.controller;

import java.rmi.RemoteException;

import presentation.personnelui.WebSaler.CreditRecharge.CreditRechargeControllerService;
import presentation.personnelui.WebSaler.ManageWebStrategy.ManageWebStrategy;
import rmi.WebSalerRemoteHelper;
import service.Credit.AddClientCredit.AddClientCreditService;
import vo.ClientVO;

public class CreditRechargeUiController implements CreditRechargeControllerService{
	AddClientCreditService creditrechargeservice=WebSalerRemoteHelper.getInstance().getAddClientCreditService();
	
	@Override
	public boolean addCredit(String clientID, double point){
		boolean q=false;
		try {
			q=creditrechargeservice.addCredit(clientID, point);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return q;
	}


	@Override
	public ClientVO getClientVO(String clientID) {
		ClientVO vo=null;
		try {
			vo = creditrechargeservice.getClientVO(clientID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}


	@Override
	public boolean checkID(String clientID){
		boolean q=false;
		try {
			q=creditrechargeservice.checkID(clientID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return q;
	}


//	@Override
//	public void setManageWebStrategyView(ManageWebStrategy view) {
//		// TODO Auto-generated method stub
//		this.manageWebStrategyView=view;
//	}

	

}
