package presentation.controller;

import java.rmi.RemoteException;
import java.util.List;

import presentation.personnelui_hotelWorker.hotelpersonnel.ManageStrategy.AddHotelStrategyView;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageStrategy.HotelStrategyControllerService;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageStrategy.InitManageStrategyView;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageStrategy.ModifyStrategyView;
import rmi.HotelWorkerRemoteHelper;
import runner.HotelWorkerRunner;
import service.Hotel.MaintainHotelMessage.MaintainHotelMessageService;
import service.Strategy.ManageHotelStrategy.ManageHotelStrategyService;
import vo.HotelVO;
import vo.StrategyVO;

public class HotelStrategyControllerImpl implements HotelStrategyControllerService {

	private String hotelId;
	
	private String strategyId;
	
	private ManageHotelStrategyService strategyService;
	
	private MaintainHotelMessageService hotelService;
	
	private InitManageStrategyView initManageStrategyView;
	
	private AddHotelStrategyView addHotelStrategyView;
	
	private ModifyStrategyView modifyStrategyView;
	
	public HotelStrategyControllerImpl(String hotelId,String strategyId) {
		// TODO Auto-generated constructor stub
		new HotelWorkerRunner();
		this.hotelId=hotelId;
		this.strategyId=strategyId;
		strategyService=HotelWorkerRemoteHelper.getInstance().getManageHotelStrategyService();
		hotelService=HotelWorkerRemoteHelper.getInstance().getMaintainHotelMessageService();
	}
	
	@Override
	public void manageHotelButtonClicked(int type) {
		// TODO Auto-generated method stub
		if(type==1){
			initManageStrategyView.manageHotelButtonClicked();
		}else if(type==2){
			addHotelStrategyView.manageHotelButtonClicked();
		}else if(type==3){
			modifyStrategyView.manageHotelButtonClicked();
		}
	}

	@Override
	public void manageRoomButtonClicked(int type) {
		// TODO Auto-generated method stub
		if(type==1){
			initManageStrategyView.manageRoomButtonClicked();
		}else if(type==2){
			addHotelStrategyView.manageRoomButtonClicked();
		}else if(type==3){
			modifyStrategyView.manageRoomButtonClicked();
		}
	}

	@Override
	public void manageStrategyButtonClicked(int type) {
		// TODO Auto-generated method stub
		if(type==1){
			initManageStrategyView.manageStrategyButtonClicked();
		}else if(type==2){
			addHotelStrategyView.manageStrategyButtonClicked();
		}else if(type==3){
			modifyStrategyView.manageStrategyButtonClicked();
		}
	}

	@Override
	public void manageOrderButtonClicked(int type) {
		// TODO Auto-generated method stub
		if(type==1){
			initManageStrategyView.manageOrderButtonClicked();
		}else if(type==2){
			addHotelStrategyView.manageOrderButtonClicked();
		}else if(type==3){
			modifyStrategyView.manageOrderButtonClicked();
		}
	}

	@Override
	public void manageInfoButtonClicked(int type) {
		// TODO Auto-generated method stub
		if(type==1){
			initManageStrategyView.manageInfoButtonClicked();
		}else if(type==2){
			addHotelStrategyView.manageInfoButtonClicked();
		}else if(type==3){
			modifyStrategyView.manageInfoButtonClicked();
		}
	}
	
	@Override
	public void manageCompanyButtonClicked(int type) {
		// TODO Auto-generated method stub
		if(type==1){
			initManageStrategyView.manageCompanyButtonClicked();
		}else if(type==2){
			addHotelStrategyView.manageCompanyButtonClicked();
		}else if(type==3){
			modifyStrategyView.manageCompanyButtonClicked();
		}
	}
	

	@Override
	public List<StrategyVO> getAllHotelStrategy(String hotelId) {
		// TODO Auto-generated method stub
		try {
			return strategyService.getAllHotelStrategy(hotelId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void setInitManageStrategyView(InitManageStrategyView view) {
		// TODO Auto-generated method stub
		this.initManageStrategyView=view;
	}

	@Override
	public String getHotelId() {
		// TODO Auto-generated method stub
		return hotelId;
	}

	@Override
	public String getStrategyId() {
		// TODO Auto-generated method stub
		return strategyId;
	}
	
	@Override
	public void addStrategyButtonClicked() {
		// TODO Auto-generated method stub
		initManageStrategyView.addStrategyButtonClicked();
	}

	@Override
	public void setAddHotelStrategyView(AddHotelStrategyView view) {
		// TODO Auto-generated method stub
		this.addHotelStrategyView=view;
	}

	@Override
	public boolean addHotelStrategy(StrategyVO strategyVO) {
		// TODO Auto-generated method stub
		try {
			return strategyService.addHotelStrategy(strategyVO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean changeHotelStrategy(StrategyVO strategyVO) {
		// TODO Auto-generated method stub
		try {
			return strategyService.changeHotelStrategy(strategyVO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteHotelStrategy(String strategyID) {
		// TODO Auto-generated method stub
		try {
			return strategyService.deleteHotelStrategy(strategyID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void confirmAddStrategyButtonClicked() {
		// TODO Auto-generated method stub
		addHotelStrategyView.confirmAddStrategyButtonClicked();
	}

	@Override
	public HotelVO getHotelVO(String hotelId) {
		// TODO Auto-generated method stub
		try {
			return hotelService.getHotelVO(hotelId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void cancelButtonClicked(int type) {
		// TODO Auto-generated method stub
		if(type==1){
			initManageStrategyView.cancelButtonClicked();
		}else if(type==2){
			addHotelStrategyView.cancelButtonClicked();
		}else if(type==3){
			modifyStrategyView.cancelButtonClicked();
		}
	}

	@Override
	public void modifyStrategyButtonClicked() {
		// TODO Auto-generated method stub
		initManageStrategyView.modifyStrategyButtonClicked();
	}

	@Override
	public void setModifyHotelStrategyView(ModifyStrategyView view) {
		// TODO Auto-generated method stub
		this.modifyStrategyView=view;
	}

	@Override
	public void confirmModifyStrategyButtonClicked() {
		// TODO Auto-generated method stub
		modifyStrategyView.confirmModifyStrategyButtonClicked();
	}

	@Override
	public void deleteButtonClicked() {
		// TODO Auto-generated method stub
		initManageStrategyView.deleteButtonClicked();
	}


}
