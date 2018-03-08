package presentation.personnelui_hotelWorker.hotelpersonnel.Init;

import java.util.List;

import vo.HotelVO;
import vo.OrderVO;

public interface InitHotelViewControllerService {
	
	public String getHotelId();
	
	public void setView(InitHotelView view);
	
	public HotelVO getHotelVO(String hotelId);
	
	public void CheckInButtonClicked();

	public void checkOutButtonClicked();

	public void delayButtonClicked();
	
	public List<OrderVO> getAbnormalOrders(String hotelID,String clientID);
	
	public void manageHotelButtonClicked();
	
	public void manageRoomButtonClicked();
	
	public void manageStrategyButtonClicked();

	public void manageOrderButtonClicked();

	public void manageInfoButtonClicked();
	
	public void manageCompanyButtonClicked();
	
	public byte[] getHotelPicture(String hotelID);

}
