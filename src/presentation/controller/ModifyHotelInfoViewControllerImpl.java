package presentation.controller;

import java.rmi.RemoteException;

import presentation.personnelui_hotelWorker.hotelpersonnel.ManageHotel.ModifyHotelInfoView;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageHotel.ModifyHotelInfoViewControllerService;
import rmi.HotelWorkerRemoteHelper;
import service.Hotel.MaintainHotelMessage.MaintainHotelMessageService;
import vo.HotelVO;

public class ModifyHotelInfoViewControllerImpl implements ModifyHotelInfoViewControllerService {

	private String hotelid;
	
	private ModifyHotelInfoView view;
	
	private MaintainHotelMessageService hotelMessageService;
	
	public ModifyHotelInfoViewControllerImpl(String hotelId) {
		// TODO Auto-generated constructor stub
		this.hotelid=hotelId;
		hotelMessageService=HotelWorkerRemoteHelper.getInstance().getMaintainHotelMessageService();
	}
	
	@Override
	public String getHotelId() {
		// TODO Auto-generated method stub
		return hotelid;
	}

	@Override
	public void setView(ModifyHotelInfoView view) {
		// TODO Auto-generated method stub
		this.view=view;
	}

	@Override
	public HotelVO getHotelVO(String hotelId) {
		// TODO Auto-generated method stub
		try{
			return hotelMessageService.getHotelVO(hotelId);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean changeHotelInfo(String hotelId, String hotelProvince, String hotelCity, String hotelCBD,
			String hotelAddress, String hotelName, String introduction, String facilities, int star,
			String roomTypeAndPrices, String telephone) {
		// TODO Auto-generated method stub
		try {
			return hotelMessageService.changeHotelInfo(hotelId, hotelProvince, hotelCity, hotelCBD, hotelAddress, hotelName, introduction, facilities, star, roomTypeAndPrices, telephone);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void manageHotelButtonClicked() {
		// TODO Auto-generated method stub
		view.manageHotelButtonClicked();
	}

	@Override
	public void manageRoomButtonClicked() {
		// TODO Auto-generated method stub
		view.manageRoomButtonClicked();
	}

	@Override
	public void manageStrategyButtonClicked() {
		// TODO Auto-generated method stub
		view.manageStrategyButtonClicked();
	}

	@Override
	public void manageOrderButtonClicked() {
		// TODO Auto-generated method stub
		view.manageOrderButtonClicked();
	}

	@Override
	public void manageInfoButtonClicked() {
		// TODO Auto-generated method stub
		view.manageInfoButtonClicked();
	}

	@Override
	public void manageCompanyButtonClicked() {
		// TODO Auto-generated method stub
		view.manageCompanyButtonClicked();
	}

	@Override
	public boolean uploadHotelPicture(byte[] b, String hotelID) {
		// TODO Auto-generated method stub
		try {
			return hotelMessageService.uploadHotelPicture(b, hotelID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public byte[] getHotelPicture(String hotelID) {
		// TODO Auto-generated method stub
		try {
			return hotelMessageService.getHotelPicture(hotelID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean changeHotelPicture(byte[] b, String hotelID) {
		// TODO Auto-generated method stub
		try {
			return hotelMessageService.changeHotelPicture(b, hotelID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
