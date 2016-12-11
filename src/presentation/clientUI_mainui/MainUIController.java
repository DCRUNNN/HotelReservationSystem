package presentation.clientUI_mainui;

import java.rmi.RemoteException;

import rmi.ClientRemoteHelper;
import service.Hotel.SearchHotel.SearchHotelService;

public class MainUIController implements MainUIControllerService{

	private String clientID;
	private SearchHotelService search ;
	private mainUI mainUI;
	
	public MainUIController(String clientID){
		
		this.clientID = clientID;
		search = ClientRemoteHelper.getInstance().getSearchHotelService();
	}
	
	public void setUI(mainUI main){
		
		this.mainUI = main;
	}
	
	@Override
	public String getProvinces() {
		
		try {
			return search.getAllProvinces();
		} catch (RemoteException e) {
			return "";
		}
	}

	@Override
	public String getClientName() {

		return clientID;
	}

	@Override
	public void selectProvince() {
		
		mainUI.selectProvince();
	}

	@Override
	public String getCities(String province) {
		
		String cities = "";
		try {
			cities = search.getCities(province);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return cities;
	}

	@Override
	public void selectCity() {
	
		mainUI.selectCity();
	}

	@Override
	public String getCBDs(String province,String city) {
		
		String cbds = "";
		try {
			cbds = search.getCBDS(province, city);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return cbds;
	}

	@Override
	public void initSearch(String hotelProvince, String hotelCity, String hotelCBD) {
		
		try {
			search.initAllHotel(clientID, hotelProvince, hotelCity, hotelCBD);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void searchButtonClicked() {
		
		mainUI.searchButtonClicked();
		
	}

	@Override
	public String getClientID() {
	
		return clientID;
	}

}
