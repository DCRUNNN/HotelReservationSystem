package presentation.personnelui_hotelWorker.hotelpersonnel.MyInfo;

import vo.HotelVO;

public interface MyInfoControllerService {

	public String getHotelId();
	
	public void setInfoView(MyInfoView view);
	
	public void manageHotelButtonClicked();
	
	public void manageRoomButtonClicked();
	
	public void manageStrategyButtonClicked();

	public void manageOrderButtonClicked();

	public void manageInfoButtonClicked();
	
	public void manageCompanyButtonClicked();
	
	public HotelVO getHotelVO(String hotelId);
	
	public byte[] getHotelPicture(String hotelID);
		
	public void backButtonClicked();
}
