package presentation.controller;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Vector;
import service.Client.*;
import service.Client.ManageClientMessage_client.ManageClientMessage_clientService;
import service.Client.ManageClientMessage_webManager.ClientMessage_webManagerService;
import presentation.personnelui.ManageClient.ManageClientControllerService;
import rmi.WebManagerRemoteHelper;
import vo.ClientVO;

public class ManageClientUiController implements ManageClientControllerService{

	ClientMessage_webManagerService clientservice = WebManagerRemoteHelper.getInstance().getClientMessage_webManagerService();
	List<ClientVO> volist;
	Vector<Vector<String>> clientvo;
	
	public Vector<Vector<String>> change(List<ClientVO> list) {
		Vector<Vector<String>> result=new Vector<Vector<String>>();
		
		for(ClientVO vo:list){
			Vector<String> vector=new Vector<String>();
			String clientId=vo.getId();
			String name=vo.getName();
			String sex=vo.getSex();
			String phoneNumber=vo.getPhoneNumber();
			String type=vo.getClientType();
			String birthday=vo.getBirthday();
			String vipGrade=String.valueOf(vo.getVipGrade());
			String companyName=vo.getCompanyAddress();
			String credit=String.valueOf(vo.getCredit_point());
			String identityId=vo.getIdentityID();
			
			vector.add(clientId);
			vector.addElement(name);
			vector.add(sex);
			vector.add(phoneNumber);
			vector.add(type);
			vector.add(birthday);
			vector.add(vipGrade);
			vector.add(companyName);
			vector.add(credit);
			vector.add(identityId);
			
			result.add(vector);
		}
		return result;
	}


	@Override
	public List<ClientVO> getAllClientVO() {
		
		try {
			volist=clientservice.getAllClients();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return volist;
	}



	@Override
	public Vector<Vector<String>> getClientVO(String client_id) {
		
		ClientVO vo = null;
		try {
			vo = clientservice.getClientMessage(client_id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		volist.add(vo);
		clientvo=change(volist);
		return clientvo;
	}



	@Override
	public Vector<Vector<String>> getClientVO1(String name) {
		
		try {
			volist=clientservice.getClientsByName(name);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clientvo=change(volist);
		return clientvo;
	}



	@Override
	public Vector<Vector<String>> getClientVO2(String phonenumber) {
		
		try {
			volist=clientservice.getClientByPhoneNumber(phonenumber);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clientvo=change(volist);
		return clientvo;
	}

}
