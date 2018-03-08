package presentation.personnelui_hotelWorker.hotelpersonnel.ManageRoom;

import java.util.List;

import vo.HotelVO;
import vo.RoomVO;

public interface HotelRoomControllerService {

	public String getHotelId();
	
	public void setCreateRoomView(CreateRoomView view);
	
	public void setInitManageRoomView(InitManageRoomView view);
	
	public void setModifyRoomView(ModifyRoomView view);
	
	public void setModifyRoomTypeView(ModifyRoomWithTypeView view);
	
	public List<RoomVO> getAllRoomList(String hotelId);
	
	public String getRoomTypeAndPrice(String hotelId);
	
	public List<String> getRoomType(String hotelId);
	
	public List<String> getRoomState(String hotelId);
			
	public boolean deleteRoom(String hotelId,String roomId);
		
	public boolean createRoom(RoomVO vo);
	
	public List<RoomVO> getRoomByType(String hotelId,String type);
	
	public RoomVO getRoomByNum(String hotelId,String roomId);
	
	public boolean changeRoomType(String hotelId,String roomNumber,String type);
		
	public boolean changeRoomPrice (String hotelID,String roomType,double price);
	
	public boolean changeRoomPriceById(String hotelId,double price,String roomNumber);
	
	public boolean changeRoomState(String hotelId,String roomId,String state);
	
	public boolean changeRoomIntroByType(String hotelId,String roomType,String intro);
	
	public boolean changeRoomIntroById(String hotelId,String roomNumber,String intro);
	
	public void checkinButtonClicked();
	
	public void checkoutButtonClicked();
	
	public void modifyRoomButtonClicked_InitManageRoomView();
	
	public void addRoomButtonClicked_InitManageRoomView();
	
	public void deleteRoomButtonClicked_InitManageRoomView();
	
	public void changeRoomStateButtonClicked_InitManageRoomView();
	
	public void addRoomTypePriceButtonClicked();
	
	public void modifyRoomTypePriceButtonClicked();
	
	public void comfirmButtonClicked(int type);
	
	public void backButtonClicked(int type);
	
	public void manageHotelButtonClicked(int type);
	
	public void manageRoomButtonClicked(int type);
	
	public void manageStrategyButtonClicked(int type);

	public void manageOrderButtonClicked(int type);

	public void manageInfoButtonClicked(int type);
	
	public void manageCompanyButtonClicked(int type);
	
	public int getAvailableRoom(String hotelId,String type);
	
	public boolean addRoomTypeAndPrice(String hotelID,String roomType,double price);
	
    public HotelVO getHotelVO(String hotelId);
    
}
