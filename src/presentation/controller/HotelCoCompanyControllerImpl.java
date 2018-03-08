package presentation.controller;

import java.rmi.RemoteException;

import presentation.personnelui_hotelWorker.hotelpersonnel.ManageCompany.HotelCoCompanyControllerService;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageCompany.InitManageCompanyView;
import rmi.HotelWorkerRemoteHelper;
import service.Hotel.MaintainHotelMessage.MaintainHotelMessageService;
import vo.HotelVO;

public class HotelCoCompanyControllerImpl implements HotelCoCompanyControllerService {

	private String hotelId;
	
	private MaintainHotelMessageService hotelMessageService;
	
	private InitManageCompanyView initManageCompanyView;

	public HotelCoCompanyControllerImpl(String hotelId) {
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
	public boolean addCompany(String hotelID, String companyAddress) {
		// TODO Auto-generated method stub
		try {
			return hotelMessageService.addCompany(hotelID, companyAddress);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public boolean deleteCompany(String hotelID, String companyAddress) {
		// TODO Auto-generated method stub
		try {
			return hotelMessageService.deleteCompany(hotelID, companyAddress);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public void manageHotelButtonClicked() {
		// TODO Auto-generated method stub
		initManageCompanyView.manageHotelButtonClicked();
	}


	@Override
	public void manageRoomButtonClicked() {
		// TODO Auto-generated method stub
		initManageCompanyView.manageRoomButtonClicked();
	}


	@Override
	public void manageStrategyButtonClicked() {
		// TODO Auto-generated method stub
		initManageCompanyView.manageStrategyButtonClicked();
	}


	@Override
	public void manageOrderButtonClicked() {
		// TODO Auto-generated method stub
		initManageCompanyView.manageOrderButtonClicked();
	}


	@Override
	public void manageInfoButtonClicked() {
		// TODO Auto-generated method stub
		initManageCompanyView.manageInfoButtonClicked();
	}


	@Override
	public void manageCompanyButtonClicked() {
		// TODO Auto-generated method stub
		initManageCompanyView.manageCompanyButtonClicked();
	}


	@Override
	public void addCompanyButtonClicked() {
		// TODO Auto-generated method stub
		initManageCompanyView.addCompanyButtonClicked();
	}


	@Override
	public void deleteCompanyButtonClicked() {
		// TODO Auto-generated method stub
		initManageCompanyView.deleteCompanyButtonClicked();
	}


	@Override
	public HotelVO getHotelVO(String hotelID) {
		// TODO Auto-generated method stub
		try {
			return hotelMessageService.getHotelVO(hotelID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public void setInitManageCompanyView(InitManageCompanyView view) {
		// TODO Auto-generated method stub
		this.initManageCompanyView=view;
	}


	@Override
	public void backButtonClicked() {
		// TODO Auto-generated method stub
		initManageCompanyView.backButtonClicked();
	}

}
