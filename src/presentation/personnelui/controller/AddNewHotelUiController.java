package presentation.personnelui.controller;

import java.rmi.RemoteException;

import presentation.personnelui.WebManager.AddNewHotel.AddNewHotelControllerService;
import rmi.WebManagerRemoteHelper;
import service.Hotel.AddHotel.AddHotelService;
import vo.HotelVO;
import vo.PersonnelVO;

public class AddNewHotelUiController implements AddNewHotelControllerService{
	AddHotelService addnewhotelservice=WebManagerRemoteHelper.getInstance().getAddHotelService();
	public String addHotel(HotelVO vo) {
			String result=null;
			try {
				result = addnewhotelservice.addHotel(vo);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return result;
	}

}
