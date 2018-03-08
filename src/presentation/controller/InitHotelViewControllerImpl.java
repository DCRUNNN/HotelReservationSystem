package presentation.controller;

import java.rmi.RemoteException;
import java.util.List;

import presentation.personnelui_hotelWorker.hotelpersonnel.Init.InitHotelView;
import presentation.personnelui_hotelWorker.hotelpersonnel.Init.InitHotelViewControllerService;
import rmi.HotelWorkerRemoteHelper;
import runner.HotelWorkerRunner;
import service.Hotel.MaintainHotelMessage.MaintainHotelMessageService;
import service.Order.ExecuteOrder.ExecuteOrderService;
import vo.HotelVO;
import vo.OrderVO;

public class InitHotelViewControllerImpl implements InitHotelViewControllerService {

	private String hotelId;
	
	private MaintainHotelMessageService hotelMessageService;
	
	private ExecuteOrderService orderService;
	
	private InitHotelView initHotelView;

	
	public InitHotelViewControllerImpl(String hotelId) {
		// TODO Auto-generated constructor stub
		this.hotelId=hotelId;
		orderService=HotelWorkerRemoteHelper.getInstance().getExecuteOrderService();
		hotelMessageService=HotelWorkerRemoteHelper.getInstance().getMaintainHotelMessageService();
	}
	
	@Override
	public String getHotelId() {
		// TODO Auto-generated method stub
		return hotelId;
	}

	@Override
	public void setView(InitHotelView view) {
		// TODO Auto-generated method stub
		this.initHotelView=view;
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
	public void CheckInButtonClicked() {
		// TODO Auto-generated method stub
		initHotelView.checkInButtonClicked();
	}

	@Override
	public void checkOutButtonClicked() {
		// TODO Auto-generated method stub
		initHotelView.checkOutButtonClicked();
	}
	
	@Override
	public void delayButtonClicked() {
		// TODO Auto-generated method stub
		initHotelView.delayButtonClicked();
	}
	

	@Override
	public List<OrderVO> getAbnormalOrders(String hotelID, String clientID) {
		// TODO Auto-generated method stub
		try {
			return orderService.getAbnormalOrders(hotelID, clientID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	@Override
	public void manageHotelButtonClicked() {
		// TODO Auto-generated method stub
		initHotelView.manageHotelButtonClicked();
	}

	@Override
	public void manageRoomButtonClicked() {
		// TODO Auto-generated method stub
		initHotelView.manageRoomButtonClicked();
	}

	@Override
	public void manageStrategyButtonClicked() {
		// TODO Auto-generated method stub
		initHotelView.manageStrategyButtonClicked();
	}

	@Override
	public void manageOrderButtonClicked() {
		// TODO Auto-generated method stub
		initHotelView.manageOrderButtonClicked();
	}

	@Override
	public void manageInfoButtonClicked() {
		// TODO Auto-generated method stub
		initHotelView.manageInfoButtonClicked();
		
	}

	@Override
	public void manageCompanyButtonClicked() {
		// TODO Auto-generated method stub
		initHotelView.manageCompanyButtonClicked();
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


}
