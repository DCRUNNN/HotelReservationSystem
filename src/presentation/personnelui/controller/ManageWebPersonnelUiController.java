package presentation.personnelui.controller;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Vector;

import presentation.personnelui.WebManager.ManageWebPersonnel.ManageWebPersonnelControllerService;
import rmi.WebManagerRemoteHelper;
import service.Personnel.ManagePersonnelMessage.ManagePersonnelMessageService;
import vo.PersonnelVO;

public class ManageWebPersonnelUiController implements ManageWebPersonnelControllerService{
	ManagePersonnelMessageService personnelservice = WebManagerRemoteHelper.getInstance().getManagePersonnelMessageService();
	List<PersonnelVO> voList;
	Vector<Vector<String>> personnelvo;
	@Override
	public Vector<Vector<String>> getAllWebSalers(){
			try {
				List<PersonnelVO> volist=personnelservice.getAllWebSalers();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				personnelvo=change(personnelservice.getAllWebSalers());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return personnelvo;
	}

	@Override
	public String addNewWebsalers(PersonnelVO vo) {
		String result="";
		try {
			result=personnelservice.addNewWebsalers(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}		
		return result;
	}

	@Override
	public Vector<Vector<String>> change(List<PersonnelVO> list) {
Vector<Vector<String>> result=new Vector<Vector<String>>();
		
		for(PersonnelVO vo:list){
			Vector<String> vector=new Vector<String>();
			String personnelId=vo.getpersonnelID();
			String name=vo.getname();
			String phoneNumber=vo.getphoneNumber();
			String sex=vo.getsex();
			String type=vo.getType();
			
			vector.add(personnelId);
			vector.add(name);
			vector.add(phoneNumber);
			vector.add(sex);
			vector.add(type);

			result.add(vector);
		}
		return result;
	}

	@Override
	public boolean modifyPersonnel(PersonnelVO vo) {
		boolean q=false;
		try {
			q=personnelservice.modifyPersonnel(vo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return q;
	}

	@Override
	public boolean savePassword(String personnelID, String password) {
		// TODO Auto-generated method stub
		try {
			return personnelservice.savePassword(personnelID, password);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	
}
