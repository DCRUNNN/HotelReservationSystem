package presentation.clientUI_book;

import rmi.ClientRemoteHelper;
import runner.ClientRunner;
import service.Order.CreateOrder.CreateOrderService;

public class bookDetailUIController implements bookDetailUIControllerService{

	private String hotelID ;
	private CreateOrderService service;
	
	public bookDetailUIController(String hotelID){
		
		this.hotelID = hotelID;
		new ClientRunner();
		service = ClientRemoteHelper.getInstance().getCreateOrderService();
	}
}
