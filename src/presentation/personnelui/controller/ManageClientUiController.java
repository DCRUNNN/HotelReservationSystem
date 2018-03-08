package presentation.personnelui.controller;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Vector;
import service.Client.ManageClientMessage_webManager.ClientMessage_webManagerService;
import presentation.personnelui.WebManager.ManageClient.ManageClientControllerService;
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
			String identityId=vo.getIdentityID();
			String credit_point=String.valueOf(vo.getCredit_point());
			String phoneNumber=vo.getPhoneNumber();
			String type=vo.getClientType();

			vector.add(clientId);
			vector.addElement(name);
			vector.add(sex);
			vector.add(identityId);
			vector.add(credit_point);
			vector.add(phoneNumber);
			vector.add(type);
			result.add(vector);
		}
		return result;
	}


	@Override
	public Vector<Vector<String>> getAllClientVO() {
		
		Vector<Vector<String>> temp=new Vector<Vector<String>>();
		
		try {
			List<ClientVO> volist=clientservice.getAllClients();
			System.out.println(volist.size());
			temp= change(clientservice.getAllClients());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return temp;
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
	public boolean changeClientMessage(ClientVO vo) {
		boolean q=false;
		try {
		    q= clientservice.modifyClientMessage(vo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return q;
	}


	@Override
	public ClientVO getClientMessgae(String clientid) {
		ClientVO vo=null;
		try {
			vo=clientservice.getClientMessage(clientid);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}

}
