package presentation.clientUI_book;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import rmi.ClientRemoteHelper;
import runner.ClientRunner;
import service.Order.CreateOrder.CreateOrderService;

public class bookDetailUIController implements bookDetailUIControllerService{

	private String clientID;
	private String hotelID ;
	private CreateOrderService service;
	private bookDetailUI view;
	private Map<String,ArrayList<String>> allTypeAndRooms ;
	
	public bookDetailUIController(String hotelID, String clientID){
		
		this.hotelID = hotelID;
		this.clientID = clientID;
		new ClientRunner();
		service = ClientRemoteHelper.getInstance().getCreateOrderService();
		
	}

	private void initMap() {
		
		try {
			String allRoomTypeAndPrice = service.getRoomTypeAndPrice(hotelID);
			String types[] = allRoomTypeAndPrice.split("/");
			for(String type:types){
				
				ArrayList<String> roomList = new ArrayList<String>();//房间类型对应的房间号码
				String str = type.split("[|]")[0];//房间类型
				
				String allRooms = service.getAllRoomNumber(hotelID, str);
				if("".equals(allRooms)){
					//返回的是""的话，直接下一个类型
					allTypeAndRooms.put(str, roomList);
					continue;
				}else{
					String rooms[] = allRooms.split("/");
					for(String room:rooms){
						roomList.add(room);
					}
					allTypeAndRooms.put(str, roomList);
				}
				
			}
		} catch (RemoteException e) {
		
			e.printStackTrace();
		}
	}

	@Override
	public void searchButtonClicked() {
		
		view.searchButtonClicked();
	}

	@Override
	public void setView(bookDetailUI bookDetailUI) {
		
		this.view = bookDetailUI;
	}

	@Override
	public void lastPageButtonClicked() {

		view.lastPageButtonClicked();
	}

	@Override
	public void nextPageButtonClicked() {
		
		view.nextPageButtonClicked();
	}

	@Override
	public String getRoomNumber(String roomType) {
		
		if(allTypeAndRooms == null){
			allTypeAndRooms = new HashMap<String,ArrayList<String>>();
			initMap();
		}
		
		ArrayList<String> list = allTypeAndRooms.get(roomType);
		if(list.size()==0){
			//没有房间了
			return "";
		}
		
	    return list.get(0);
	}

	@Override
	public double getPrice(String roomNumbers) {
		
		try {
			double price = service.getPriceByStrategy(hotelID, clientID, roomNumbers);
			return price;
		} catch (RemoteException e) {
		
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public String getNextRoomNumber(String roomType, String lastRoomNumber) {
		
		ArrayList<String> numbers = allTypeAndRooms.get(roomType);
		int index = numbers.indexOf(lastRoomNumber);//上一个房间的位置
		if(index==numbers.size()-1){
			return "";
		}else{
			return numbers.get(index+1);
		}
	}

	@Override
	public void ceateButtonClicked() {
		
		view.createButtonClicked();
	}

	@Override
	public boolean checkCredit(String clientID) {
		
		try {
			return service.checkCreditPoint(clientID);
		} catch (RemoteException e) {
		
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean checkRoom(String hotelID, String str) {
		
		
		try {
			return service.checkRoom(hotelID, str);
		} catch (RemoteException e) {
		
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean createOrder(String hotelID, String clientID, String types, String numbers) {
		
		try {
			return service.createOrder(hotelID, clientID, types, numbers);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return false;
	}	
}
