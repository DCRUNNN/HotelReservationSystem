package presentation.controller;

import java.rmi.RemoteException;

import presentation.personnelui_hotelWorker.hotelpersonnel.MyInfo.MyInfoControllerService;
import presentation.personnelui_hotelWorker.hotelpersonnel.MyInfo.MyInfoView;
import rmi.HotelWorkerRemoteHelper;
import service.Hotel.MaintainHotelMessage.MaintainHotelMessageService;
import vo.HotelVO;

public class MyInfoControllerImpl implements MyInfoControllerService {

	private String hotelId;
	
	private MaintainHotelMessageService hotelMessageService;
	
	private MyInfoView myInfoView;
	
	public MyInfoControllerImpl(String hotelId) {
		// TODO Auto-generated constructor stub
		this.hotelId=hotelId;
		hotelMessageService=HotelWorkerRemoteHelper.getInstance().getMaintainHotelMessageService();
	}
	
	@Override
	public String getHotelId() {
		// TODO Auto-generated method stub
		return hotelId;
	}

	@Override
	public void setInfoView(MyInfoView view) {
		// TODO Auto-generated method stub
		this.myInfoView=view;
	}

	@Override
	public void manageHotelButtonClicked() {
		// TODO Auto-generated method stub
		myInfoView.manageHotelButtonClicked();
	}

	@Override
	public void manageRoomButtonClicked() {
		// TODO Auto-generated method stub
		myInfoView.manageRoomButtonClicked();
	}

	@Override
	public void manageStrategyButtonClicked() {
		// TODO Auto-generated method stub
		myInfoView.manageStrategyButtonClicked();
	}

	@Override
	public void manageOrderButtonClicked() {
		// TODO Auto-generated method stub
		myInfoView.manageOrderButtonClicked();
	}

	@Override
	public void manageInfoButtonClicked() {
		// TODO Auto-generated method stub
		myInfoView.manageInfoButtonClicked();
	}

	@Override
	public HotelVO getHotelVO(String hotelId) {
		// TODO Auto-generated method stub
		try {
			return hotelMessageService.getHotelVO(hotelId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public byte[] getHotelPicture(String hotelID) {
		// TODO Auto-generated method stub
		try {
			return hotelMessageService.getHotelPicture(hotelId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public void backButtonClicked() {
		// TODO Auto-generated method stub
		myInfoView.backButtonClicked();
	}

	@Override
	public void manageCompanyButtonClicked() {
		// TODO Auto-generated method stub
		myInfoView.manageCompanyButtonClicked();
	}

}
