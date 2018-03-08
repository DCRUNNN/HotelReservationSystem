package presentation.clientUI_mainui;

import java.rmi.RemoteException;

import javax.swing.Icon;

import presentation.clientUI_account.ManageClientMessageUIController;
import presentation.clientUI_account.accountUI;
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

	@Override
	public void accountButtonClicked()
	{
		mainUI.accountButtonClicked();
	}

	@Override
	public void orderButtonClicked()
	{
		mainUI.orderButtonClicked();
	}

	@Override
	public void hotelButtonClicked()
	{
		mainUI.hotelButtonClicked();
	}

	@Override
	public void creditButtonClicked()
	{
		mainUI.creditButtonClicked();
	}

	@Override
	public void memberButtonClicked()
	{
		mainUI.memberButtonClicked();
	}

	@Override
	public void setView(mainUI view)
	{
		mainUI = view;
		view.setVisible(true);
	}

	@Override
	public Icon getHeadIcon()
	{
		ManageClientMessageUIController manageClientMessageUIController = new ManageClientMessageUIController(clientID);
		accountUI accountView = new accountUI(manageClientMessageUIController);
		return accountView.getHeadIcon();
	}

}
