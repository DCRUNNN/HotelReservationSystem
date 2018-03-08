package presentation.personnelui_hotelWorker.hotelpersonnel.ManageHotel;

import vo.HotelVO;

public interface ModifyHotelInfoViewControllerService {

	public String getHotelId();
	
	public void setView(ModifyHotelInfoView view);
	
	public HotelVO getHotelVO(String hotelId);
	
	public boolean changeHotelInfo(String hotelId,String hotelProvince,String hotelCity,String hotelCBD,String hotelAddress,String hotelName,String introduction,String facilities,int star,String roomTypeAndPrices,String telephone);
	
	public void manageHotelButtonClicked();
	
	public void manageRoomButtonClicked();
	
	public void manageStrategyButtonClicked();

	public void manageOrderButtonClicked();

	public void manageInfoButtonClicked();
	
	public void manageCompanyButtonClicked();
	
	public boolean uploadHotelPicture(byte[] b,String hotelID);
	
	public byte[] getHotelPicture(String hotelID);
	
	public boolean changeHotelPicture(byte[] b, String hotelID);
}

