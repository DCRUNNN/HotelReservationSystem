package presentation.clientUI_mainui;

public interface MainUIControllerService {

	public String getProvinces();

	public String getClientName();

	public void selectProvince();

	public String getCities(String province);

	public void selectCity();

	public String getCBDs(String province,String city);

	public void initSearch(String hotelProvince, String hotelCity, String hotelCBD);

	public void searchButtonClicked();

	public String getClientID();

}
