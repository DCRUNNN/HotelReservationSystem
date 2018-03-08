package presentation.personnelui_hotelWorker.hotelpersonnel.ManageCompany;

import vo.HotelVO;

public interface HotelCoCompanyControllerService {

	public String getHotelId();

	public boolean addCompany(String hotelID,String companyAddress);
	
	public boolean deleteCompany(String hotelID,String companyAddress);
	
	public void setInitManageCompanyView(InitManageCompanyView view);
	
	public void manageHotelButtonClicked();
	
	public void manageRoomButtonClicked();
	
	public void manageStrategyButtonClicked();

	public void manageOrderButtonClicked();

	public void manageInfoButtonClicked();
	
	public void manageCompanyButtonClicked();	
	
	public void addCompanyButtonClicked();
	
	public void deleteCompanyButtonClicked();
	
	public HotelVO getHotelVO(String hotelID);
	 
	public void backButtonClicked();
} 
