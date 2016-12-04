package rmi;

import java.rmi.Remote;

import service.Hotel.MaintainHotelMessage.MaintainHotelMessageService;
import service.Order.BrowseOrder_hotelWorker.BrowseOrder_hotelWorkerService;
import service.Order.ExecuteOrder.ExecuteOrderService;
import service.Room.ChangeRoomInfo.ChangeRoomInfoService;
import service.Room.CheckOutRoom.CheckOutRoomService;
import service.Room.CreateRoom.CreateRoomInfoService;
import service.Strategy.ManageHotelStrategy.ManageHotelStrategyService;

public class HotelWorkerRemoteHelper {

	private Remote remote;
	private static HotelWorkerRemoteHelper remoteHelper = new HotelWorkerRemoteHelper();
	
	public static HotelWorkerRemoteHelper getInstance (){
		
		return remoteHelper;
	}
	
	private HotelWorkerRemoteHelper(){
		
	}
	
	public void serRemote(Remote remote){
		this.remote = remote;
	}
	
	public MaintainHotelMessageService getMaintainHotelMessageService(){
		return (MaintainHotelMessageService)remote;
	}
	
	public CreateRoomInfoService getCreateRoomInfoService(){
		return (CreateRoomInfoService)remote;
	}
	
	public ManageHotelStrategyService getManageHotelStrategyService(){
		return (ManageHotelStrategyService)remote;
	}
	
	public ExecuteOrderService getExecuteOrderService(){
		return (ExecuteOrderService)remote;
	}
	
	public CheckOutRoomService getCheckOutRoomService(){
		return (CheckOutRoomService)remote;
	}
	
	public BrowseOrder_hotelWorkerService getBrowseOrder_hotelWorkerService(){
		return (BrowseOrder_hotelWorkerService)remote;
	}
	
	public ChangeRoomInfoService getChangeRoomInfoService(){
		return (ChangeRoomInfoService)remote;
	}
}
