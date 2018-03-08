package presentation.clientUI_book;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import rmi.ClientRemoteHelper;
import service.Hotel.SearchHotel.SearchHotelService;
import vo.OrderVO;

public class hotelDetailUIController implements hotelDetailUIControllerService{

	private String hotelID;
	private String clientID;
	private SearchHotelService service;
	
	public hotelDetailUIController(String hotelID, String clientID) {
		
		service = ClientRemoteHelper.getInstance().getSearchHotelService();
		this.hotelID = hotelID;
		this.clientID = clientID;
		try {
			service.getAllOrders(clientID, hotelID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setUI(hotelDetailUI hotelDetailUI) {
	}

	@Override
	public List<OrderVO> getHistoryOrders() {
		
		List<OrderVO> orders = new ArrayList<OrderVO>();
		try {
			orders = service.getAllOrders(clientID, hotelID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return orders;
	}

	@Override
	public byte[] getPicture(String hotelID) {
		
		try {
			return service.getHotelPicture(hotelID);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	
}
