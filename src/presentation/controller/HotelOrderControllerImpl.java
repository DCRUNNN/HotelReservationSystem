package presentation.controller;

import java.rmi.RemoteException;
import java.util.List;

import presentation.personnelui_hotelWorker.hotelpersonnel.Init.InitHotelView;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageOrder.HotelOrderControllerService;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageOrder.ManageOrderView;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageOrder.ProcessOrderView;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageOrder.ShowClientAbnormalOrderView;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageOrder.ShowClientExecutedOrderView;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageOrder.ShowClientOrderView;
import rmi.HotelWorkerRemoteHelper;
import runner.HotelWorkerRunner;
import service.Order.BrowseOrder_hotelWorker.BrowseOrder_hotelWorkerService;
import service.Order.ExecuteOrder.ExecuteOrderService;
import service.Room.ChangeRoomInfo.ChangeRoomInfoService;
import service.Room.CheckOutRoom.CheckOutRoomService;
import vo.OrderVO;
import vo.RoomVO;

public class HotelOrderControllerImpl implements HotelOrderControllerService {

	private String hotelId;
	
	private String clientId;
	
	private String orderId;
	
	private ProcessOrderView processOrderView;
	
	private ShowClientOrderView showClientOrderView;
	
	private ShowClientExecutedOrderView showClientExecutedOrderView;
	
	private ShowClientAbnormalOrderView showClientAbnormalOrderView;
	
	private ManageOrderView manageOrderView;
		
	private BrowseOrder_hotelWorkerService orderService;
	
	private ChangeRoomInfoService roomInfoService;
	
	private ExecuteOrderService executeOrderService;
	
	private CheckOutRoomService checkOutRoomService;
			
	private InitHotelView initHotelView;
	
	
	public HotelOrderControllerImpl(String hotelId,String clientId,String orderId) {
		// TODO Auto-generated constructor stub
		checkOutRoomService=HotelWorkerRemoteHelper.getInstance().getCheckOutRoomService();
		executeOrderService=HotelWorkerRemoteHelper.getInstance().getExecuteOrderService();
		orderService=HotelWorkerRemoteHelper.getInstance().getBrowseOrder_hotelWorkerService();
		roomInfoService=HotelWorkerRemoteHelper.getInstance().getChangeRoomInfoService();
		this.hotelId=hotelId;
		this.clientId=clientId;
		this.orderId=orderId;
	}
	
	@Override
	public String getHotelId() {
		// TODO Auto-generated method stub
		return hotelId;
	}

	@Override
	public String getClientId() {
		// TODO Auto-generated method stub
		return clientId;
	}
	
	@Override
	public String getOrderId() {
		// TODO Auto-generated method stub
		return orderId;
	}
	
	@Override
	public void setProcessOrderView(ProcessOrderView view) {
		// TODO Auto-generated method stub
		this.processOrderView=view;
	}
	
	@Override
	public void setManageOrderView(ManageOrderView view) {
		// TODO Auto-generated method stub
		this.manageOrderView=view;
	}

	@Override
	public void setShowClientAbnormalOrderView(ShowClientAbnormalOrderView view) {
		// TODO Auto-generated method stub
		this.showClientAbnormalOrderView=view;
	}
	
	@Override
	public List<OrderVO> getUnexecutedOrders(String hotelID,String clientID) {
		// TODO Auto-generated method stub
		try {
			return executeOrderService.getUnexecutedOrders(hotelID, clientID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<OrderVO> getAbnormalOrders(String hotelID, String clientID) {
		// TODO Auto-generated method stub
		try {
			return executeOrderService.getAbnormalOrders(hotelID, clientID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	
	@Override
	public List<OrderVO> getAllOrders(String hotelID) {
		// TODO Auto-generated method stub
		try {
			return orderService.getAllOrders(hotelID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<OrderVO> getUnexecutedOrders(String hotelID) {
		// TODO Auto-generated method stub
		try {
			return orderService.getUnexecutedOrders(hotelID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	@Override
	public List<OrderVO> getExecutedOrders(String hotelID) {
		// TODO Auto-generated method stub
		try {
			return orderService.getExecutedOrders(hotelID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<OrderVO> getAbnormalOrders(String hotelID) {
		// TODO Auto-generated method stub
		try {
			return orderService.getAbnormalOrders(hotelID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<OrderVO> getWithdrawnOrders(String hotelID) {
		// TODO Auto-generated method stub
		try {
			return orderService.getWithdrawnOrders(hotelID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	@Override
	public void setShowClientOrderView(ShowClientOrderView view) {
		// TODO Auto-generated method stub
		this.showClientOrderView=view;
	}

	@Override
	public void executeOrderButtonClicked() {
		// TODO Auto-generated method stub
		showClientOrderView.executeOrderButtonClicked();
	}

	@Override
	public OrderVO getOrder(String orderID) {
		// TODO Auto-generated method stub
		try {
			return orderService.getOrder(orderID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public RoomVO getRoomByNum(String hotelID, String roomId) {
		// TODO Auto-generated method stub
		try {
			return roomInfoService.getRoomByNum(hotelID, roomId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void confirmButtonClicked() {
		// TODO Auto-generated method stub
		processOrderView.confirmButtonClicked();
	}

	@Override
	public void setRoomPeople(String roomNumber, int peopleNumber) {
		// TODO Auto-generated method stub
		try {
			executeOrderService.setRoomPeople(roomNumber, peopleNumber);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void setRoomChild(String roomNumber, boolean hasChild) {
		// TODO Auto-generated method stub
		try {
			executeOrderService.setRoomChild(roomNumber, hasChild);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean executeOrder() {
		// TODO Auto-generated method stub
		try {
			return executeOrderService.executeOrder();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public String getAllRoomNumber(String orderID) {
		// TODO Auto-generated method stub
		try {
			return executeOrderService.getAllRoomNumber(orderID,hotelId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getAllRoomType(String orderID) {
		// TODO Auto-generated method stub
		try {
			return executeOrderService.getAllRoomType(orderID,hotelId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void entryButtonClicked() {
		// TODO Auto-generated method stub
		manageOrderView.entryButtonClicked();
	}

	@Override
	public void updateTable(String selected) {
		// TODO Auto-generated method stub
		manageOrderView.updateTable(selected);
	}

	@Override
	public void searchButtonClicked() {
		// TODO Auto-generated method stub
		manageOrderView.searchButtonClicked();
	}

	@Override
	public void detailedButtonClicked() {
		// TODO Auto-generated method stub
		manageOrderView.detailedButtonClicked();
	}

	@Override
	public void delayButtonClicked() {
		// TODO Auto-generated method stub
		manageOrderView.delayButtonClicked();
	}

	@Override
	public void backButtonClicked() {
		// TODO Auto-generated method stub
		manageOrderView.backButtonClicked();
	}

	@Override
	public void manageHotelButtonClicked() {
		// TODO Auto-generated method stub
		manageOrderView.manageHotelButtonClicked();
	}

	@Override
	public void manageRoomButtonClicked() {
		// TODO Auto-generated method stub
		manageOrderView.manageRoomButtonClicked();
	}

	@Override
	public void manageStrategyButtonClicked() {
		// TODO Auto-generated method stub
		manageOrderView.manageStrategyButtonClicked();
	}

	@Override
	public void manageOrderButtonClicked() {
		// TODO Auto-generated method stub
		manageOrderView.manageOrderButtonClicked();
	}

	@Override
	public void manageInfoButtonClicked() {
		// TODO Auto-generated method stub
		manageOrderView.manageInfoButtonClicked();
	}
	
	@Override
	public void manageCompanyButtonClicked() {
		// TODO Auto-generated method stub
		manageOrderView.manageCompanyButtonClicked();
	}

	@Override
	public boolean checkOutRoom(String clientID, String hotelID, String roomNumber) {
		// TODO Auto-generated method stub
		try {
			return checkOutRoomService.checkOutRoom(clientID, hotelID, roomNumber);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public List<RoomVO> getAllRooms(String clientID, String hotelID) {
		// TODO Auto-generated method stub
		try {
			return checkOutRoomService.getAllRooms(clientID, hotelID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public void confirmCheckOutButtonClicked() {
		// TODO Auto-generated method stub
		showClientExecutedOrderView.confirmButtonClicked();
	}

	@Override
	public void setShowClientExecutedOrderView(ShowClientExecutedOrderView view) {
		// TODO Auto-generated method stub
		this.showClientExecutedOrderView=view;
	}


	@Override
	public String getDelayRoomNumber(String orderID,String hotelId) {
		// TODO Auto-generated method stub
		try {
			return executeOrderService.getDelayRoomNumber(orderID,hotelId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void confirmDelayButtonClicked() {
		// TODO Auto-generated method stub
		showClientAbnormalOrderView.executeOrderButtonClicked();
	}

}
