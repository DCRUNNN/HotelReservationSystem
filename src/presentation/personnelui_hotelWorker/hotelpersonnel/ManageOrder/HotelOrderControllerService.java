package presentation.personnelui_hotelWorker.hotelpersonnel.ManageOrder;

import java.util.List;

import vo.ClientVO;
import vo.OrderVO;
import vo.RoomVO;

public interface HotelOrderControllerService {

	public String getHotelId();
	
	public String getClientId();
	
	public String getOrderId();
	
	public OrderVO getOrder(String orderID);
	
	public void setProcessOrderView(ProcessOrderView view);

	public void setShowClientOrderView(ShowClientOrderView view);
	
	public void setManageOrderView(ManageOrderView view);
	
	public void setShowClientExecutedOrderView(ShowClientExecutedOrderView view);
	
	public void setShowClientAbnormalOrderView(ShowClientAbnormalOrderView view);
	
	public List<OrderVO> getUnexecutedOrders(String hotelID,String clientID);
	
	public List<OrderVO> getAbnormalOrders(String hotelID,String clientID);
	
	public List<OrderVO> getAllOrders(String hotelID);
	
	public List<OrderVO> getExecutedOrders(String hotelID);
	
	public List<OrderVO> getUnexecutedOrders(String hotelID);
	
	public List<OrderVO> getAbnormalOrders(String hotelID);
	
	public List<OrderVO> getWithdrawnOrders(String hotelID);
	
	public void executeOrderButtonClicked();
	
	public RoomVO getRoomByNum(String hotelID,String roomId);
	
	public void confirmButtonClicked();

	public String getAllRoomNumber(String orderID);
	
	public String getAllRoomType(String orderID);
	
	public String getDelayRoomNumber(String orderID,String hotelId);
	
	public void setRoomPeople(String roomNumber, int peopleNumber);
	
	public void setRoomChild(String roomNumber, boolean hasChild);
	
	public boolean executeOrder();
	
	public void entryButtonClicked();
	
	public void updateTable(String selected);
	
	public void searchButtonClicked();

	public void detailedButtonClicked();
	
	public void delayButtonClicked();
	
	public void backButtonClicked();
	
	public void manageHotelButtonClicked();
	
	public void manageRoomButtonClicked();
	
	public void manageStrategyButtonClicked();

	public void manageOrderButtonClicked();

	public void manageInfoButtonClicked();
	
	public void manageCompanyButtonClicked();
	
	public boolean checkOutRoom(String clientID,String hotelID,String roomNumber);
	
	public void confirmCheckOutButtonClicked();
	
	public List<RoomVO> getAllRooms(String clientID,String hotelID);
	
	public void confirmDelayButtonClicked();
				
}
