package presentation.personnelui.controller;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Vector;

import presentation.personnelui.WebManager.ManageHotelPersonnel.*;
import rmi.WebManagerRemoteHelper;
import service.Hotel.AddHotel.AddHotelService;
import service.Personnel.ManagePersonnelMessage.ManagePersonnelMessageService;
import vo.PersonnelVO;

public class ManageHotelPersonnelUiController implements ManageHotelPersonnelControllerService{

	ManagePersonnelMessageService personnelservice = WebManagerRemoteHelper.getInstance().getManagePersonnelMessageService();
	AddHotelService addnewhotelpersonnerservice= WebManagerRemoteHelper.getInstance().getAddHotelService();
	List<PersonnelVO> volist;
	Vector<Vector<String>> personnelvo;
	
	@Override
	public Vector<Vector<String>> getAllHotelWorkers() {
        Vector<Vector<String>> temp=new Vector<Vector<String>>();
		
		try {
			List<PersonnelVO> volist=personnelservice.getAllHotelWorkers();
			System.out.println(volist.size());
			temp= change(personnelservice.getAllHotelWorkers());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return temp;
	}

	@Override
	public Vector<Vector<String>> getHotelWorkerByHotelID(String hotelID) {
		PersonnelVO vo=null;
		try {
			vo = personnelservice.getHotelWorkerByHotelID(hotelID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		volist.add(vo);
		personnelvo=change(volist);
		return personnelvo;
	}

	@Override
	public Vector<Vector<String>> getPersonnelVO(String personnelID) {
		PersonnelVO vo=null;
		try {
			vo = personnelservice.getHotelWorkerByHotelID(personnelID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		volist.add(vo);
		personnelvo=change(volist);
		return personnelvo;
	}

	@Override
	public Vector<Vector<String>> getPersonnelVOByPersonnelName(String personnelName) {
		PersonnelVO vo=null;
		try {
			vo = personnelservice.getHotelWorkerByHotelID(personnelName);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		volist.add(vo);
		personnelvo=change(volist);
		return personnelvo;
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
	public Vector<Vector<String>> change(List<PersonnelVO> list) {
           Vector<Vector<String>> result=new Vector<Vector<String>>();
		
		for(PersonnelVO vo:list){
			Vector<String> vector=new Vector<String>();
			String personnelId=vo.getpersonnelID();
			String hotelId=vo.gethotelID();
			String name=vo.getname();
			String phoneNumber=vo.getphoneNumber();
			String sex=vo.getsex();
			String type=vo.getType();
			
			vector.add(personnelId);
			vector.add(hotelId);
			vector.add(name);
			vector.add(phoneNumber);
			vector.add(sex);
			vector.add(type);

			result.add(vector);
		}
		return result;
	}

	@Override
	public boolean addHotelWorker(PersonnelVO vo) {
		boolean q=false;
		try {
			q= addnewhotelpersonnerservice.addHotelWorker(vo);
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
			return addnewhotelpersonnerservice.savePassword(personnelID, password);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
