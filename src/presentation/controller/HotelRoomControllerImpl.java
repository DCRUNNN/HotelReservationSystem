package presentation.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import presentation.personnelui_hotelWorker.hotelpersonnel.ManageRoom.CreateRoomView;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageRoom.HotelRoomControllerService;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageRoom.InitManageRoomView;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageRoom.ModifyRoomView;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageRoom.ModifyRoomWithTypeView;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageRoom.RoomTypePriceTable;
import rmi.HotelWorkerRemoteHelper;
import runner.HotelWorkerRunner;
import service.Hotel.MaintainHotelMessage.MaintainHotelMessageService;
import service.Room.ChangeRoomInfo.ChangeRoomInfoService;
import service.Room.CreateRoom.CreateRoomInfoService;
import vo.HotelVO;
import vo.RoomVO;

public class HotelRoomControllerImpl implements HotelRoomControllerService {

	private String hotelId;
		
	private CreateRoomInfoService createRoomInfoService;
	
	private ChangeRoomInfoService changeRoomInfoService;
	
	private MaintainHotelMessageService hotelMessageService;
	
	private CreateRoomView createRoomView;
	
	private InitManageRoomView initManageRoomView;
	
	private ModifyRoomView modifyRoomView;
	
	private ModifyRoomWithTypeView modifyRoomTypeView;
	
	public HotelRoomControllerImpl(String hotelId) {
		// TODO Auto-generated constructor stub
		 this.hotelId=hotelId;
		 hotelMessageService=HotelWorkerRemoteHelper.getInstance().getMaintainHotelMessageService();
		 createRoomInfoService=HotelWorkerRemoteHelper.getInstance().getCreateRoomInfoService();
		 changeRoomInfoService=HotelWorkerRemoteHelper.getInstance().getChangeRoomInfoService();
	}
	
	@Override
	public String getHotelId() {
		// TODO Auto-generated method stub
		return hotelId;
	}

	@Override
	public void setCreateRoomView(CreateRoomView view) {
		// TODO Auto-generated method stub
		this.createRoomView=view;
	}

	@Override
	public void setInitManageRoomView(InitManageRoomView view) {
		// TODO Auto-generated method stub
		this.initManageRoomView=view;
	}

	@Override
	public void setModifyRoomView(ModifyRoomView view) {
		// TODO Auto-generated method stub
		this.modifyRoomView=view;
	}

	@Override
	public void setModifyRoomTypeView(ModifyRoomWithTypeView view) {
		// TODO Auto-generated method stub
		this.modifyRoomTypeView=view;
	}

	@Override
	public String getRoomTypeAndPrice(String hotelId) {
		// TODO Auto-generated method stub
		try {
			return createRoomInfoService.getAllRoomTypeAndPrice(hotelId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	@Override
	public List<String> getRoomType(String hotelId) {
		List<String> temp=new ArrayList<String>();
		// TODO Auto-generated method stub
		try {
			return changeRoomInfoService.getRoomType(hotelId);
		} catch (RemoteException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return temp;
	}
	
	@Override
	public List<String> getRoomState(String hotelId) {
		List<String> temp=new ArrayList<String>();
		// TODO Auto-generated method stub
		try {
			return changeRoomInfoService.getRoomState(hotelId);
		} catch (RemoteException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return temp;
	}

	@Override
	public boolean deleteRoom(String hotelId, String roomId) {
		// TODO Auto-generated method stub
		try {
			return changeRoomInfoService.deleteRoom(hotelId, roomId);
		} catch (RemoteException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean changeRoomState(String hotelId, String roomId, String roomState) {
		// TODO Auto-generated method stub
		try {
			return changeRoomInfoService.changeRoomState(hotelId, roomId, roomState);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean createRoom(RoomVO vo) {
		// TODO Auto-generated method stub
		try {
			return createRoomInfoService.CreateRoom(vo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<RoomVO> getRoomByType(String hotelId, String type) {
		// TODO Auto-generated method stub
		try {
			return changeRoomInfoService.getRoomByType(hotelId, type);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean changeRoomIntroByType(String hotelId, String roomType, String intro) {
		// TODO Auto-generated method stub
		try {
			return changeRoomInfoService.changeRoomIntroByType(hotelId, roomType, intro);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public boolean changeRoomIntroById(String hotelId, String roomNumber, String intro) {
		// TODO Auto-generated method stub
		try {
			return changeRoomInfoService.changeRoomIntroById(hotelId, roomNumber, intro);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public void modifyRoomButtonClicked_InitManageRoomView(){
		// TODO Auto-generated method stub
		initManageRoomView.modifyRoomButtonClicked();
	}


	@Override
	public void addRoomButtonClicked_InitManageRoomView(){
		// TODO Auto-generated method stub
		initManageRoomView.addRoomButtonClicked();
	}


	@Override
	public void deleteRoomButtonClicked_InitManageRoomView() {
		// TODO Auto-generated method stub
		initManageRoomView.deleteRoomButtonClicked();
	}


	@Override
	public void changeRoomStateButtonClicked_InitManageRoomView(){
		// TODO Auto-generated method stub
		initManageRoomView.changeRoomStateButtonClicked();
	}


	@Override
	public void comfirmButtonClicked(int type) {
		// TODO Auto-generated method stub
		switch (type) {
		case 1:
			createRoomView.comfirmButtonClicked();
			break;
		case 2:
			modifyRoomView.confirmButtonClicked();
			break;
		case 3:
			modifyRoomTypeView.confirmButtonClicked();
			break;
		default:
			break;
		}
	}


	@Override
	public void backButtonClicked(int type) {
		// TODO Auto-generated method stub
		switch (type) {
		case 1:
			createRoomView.cancelButtonClicked();
			break;
		case 2:
			modifyRoomView.backButtonClicked();
			break;
		case 3:
			modifyRoomTypeView.backButtonClicked();
		case 4:
			initManageRoomView.backButtonClicker();
		default:
			break;
		}
	}


	@Override
	public void manageHotelButtonClicked(int type) {
		// TODO Auto-generated method stub
		switch (type) {
		case 1:
			createRoomView.manageHotelButtonClicked();
			break;
		case 2:
			modifyRoomView.manageHotelButtonClicked();
			break;
		case 3:
			modifyRoomTypeView.manageHotelButtonClicked();
			break;
		default:
			break;
		}
	}


	@Override
	public void manageRoomButtonClicked(int type) {
		// TODO Auto-generated method stub
		switch (type) {
		case 1:
			createRoomView.manageRoomButtonClicked();
			break;
		case 2:
			modifyRoomView.manageRoomButtonClicked();
			break;
		case 3:
			modifyRoomTypeView.manageRoomButtonClicked();
			break;
		default:
			break;
		}
	}


	@Override
	public void manageOrderButtonClicked(int type) {
		// TODO Auto-generated method stub
		switch (type) {
		case 1:
			createRoomView.manageOrderButtonClicked();
			break;
		case 2:
			modifyRoomView.manageRoomButtonClicked();
			break;
		case 3:
			modifyRoomTypeView.manageOrderButtonClicked();
			break;
		default:
			break;
		}
	}


	@Override
	public void manageStrategyButtonClicked(int type) {
		// TODO Auto-generated method stub
		switch (type) {
		case 1:
			createRoomView.manageStrategyButtonClicked();
			break;
		case 2:
			modifyRoomView.manageStrategyButtonClicked();
			break;
		case 3:
			modifyRoomTypeView.manageStrategyButtonClicked();
			break;
		default:
			break;
		}
	}


	@Override
	public void manageInfoButtonClicked(int type) {
		// TODO Auto-generated method stub
		switch (type) {
		case 1:
			createRoomView.manageInfoButtonClicked();
			break;
		case 2:
			modifyRoomView.manageInfoButtonClicked();
			break;
		case 3:
			modifyRoomTypeView.manageInfoButtonClicked();
			break;
		default:
			break;
		}
	}

	@Override
	public void manageCompanyButtonClicked(int type) {
		// TODO Auto-generated method stub
		switch (type) {
		case 1:
			createRoomView.manageCompanyButtonClicked();
			break;
		case 2:
			modifyRoomView.manageCompanyButtonClicked();
			break;
		case 3:
			modifyRoomTypeView.manageCompanyButtonClicked();
			break;
		default:
			break;
		}
	}

	@Override
	public boolean changeRoomPriceById(String hotelId, double price, String roomNumber) {
		// TODO Auto-generated method stub
		try {
			return changeRoomInfoService.changeRoomPriceById(hotelId, price, roomNumber);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public boolean changeRoomType(String hotelId, String roomNumber, String type) {
		// TODO Auto-generated method stub
		try {
			return changeRoomInfoService.changeRoomType(hotelId, roomNumber, type);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void checkinButtonClicked() {
		// TODO Auto-generated method stub
		initManageRoomView.checkinButtonClicked();
	}

	@Override
	public void checkoutButtonClicked() {
		// TODO Auto-generated method stub
		initManageRoomView.checkoutButtonClicked();
	}

	@Override
	public List<RoomVO> getAllRoomList(String hotelId) {
		// TODO Auto-generated method stub
		try {
			return changeRoomInfoService.getAllRoomList(hotelId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int getAvailableRoom(String hotelId, String type) {
		// TODO Auto-generated method stub
		int num=0;
		try {
			List<RoomVO> temp=changeRoomInfoService.getRoomByType(hotelId, type);
			for(int i=0;i<temp.size();i++){
				if(temp.get(i).getRoomState().equals("¿ÕÏÐ")){
					num++;
				}
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		return num;
	}

	@Override
	public void addRoomTypePriceButtonClicked() {
		// TODO Auto-generated method stub
		initManageRoomView.addRoomTypePriceButtonClicked();
	}

	@Override
	public void modifyRoomTypePriceButtonClicked() {
		// TODO Auto-generated method stub
		initManageRoomView.modifyRoomTypePriceButtonClicked();
	}

	@Override
	public boolean addRoomTypeAndPrice(String hotelID, String roomType, double price) {
		// TODO Auto-generated method stub
		try {
			return hotelMessageService.addRoomTypeAndPrice(hotelID, roomType, price);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean changeRoomPrice(String hotelID, String roomType, double price) {
		// TODO Auto-generated method stub
		try {
			return hotelMessageService.changeRoomPrice(hotelID, roomType, price);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
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
	public RoomVO getRoomByNum(String hotelId, String roomId)
	{
		// TODO Auto-generated method stub
		try
		{
			return changeRoomInfoService.getRoomByNum(hotelId, roomId);
		}
		catch (RemoteException e)
		{
			e.printStackTrace();
		}
		return null;
	}


	
}
