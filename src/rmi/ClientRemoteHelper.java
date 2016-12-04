package rmi;

import java.rmi.Remote;

import service.Client.ApplyForVip.ApplyForVipService;
import service.Client.ManageClientMessage_client.ManageClientMessage_clientService;
import service.Credit.ShowCreditRecord.ShowCreditRecordService;
import service.Hotel.BrowseHotel.BrowseHotelService;
import service.Hotel.MyHotel.MyHotelService;
import service.Hotel.SearchHotel.SearchHotelService;
import service.Order.CreateOrder.CreateOrderService;
import service.Order.EvaluateOrder.EvaluateOrderService;
import service.Order.MyOrder.MyOrderService;

public class ClientRemoteHelper {

	private Remote remote;
	private static ClientRemoteHelper remoteHelper = new ClientRemoteHelper();
	public static ClientRemoteHelper getInstance(){
		return remoteHelper;
	}
	
	private ClientRemoteHelper() {
	}
	
	public void setRemote(Remote remote){
		this.remote = remote;
	}
	
	public ApplyForVipService getApplyForVipService(){
		
		return (ApplyForVipService)remote;
	}
	
	public BrowseHotelService getBrowseHotelService(){
		
		return (BrowseHotelService)remote;
	}
	
	public CreateOrderService getCreateOrderService(){
		
		return (CreateOrderService)remote;
	}
	
	public EvaluateOrderService getEvaluateOrderService(){
		
		return (EvaluateOrderService)remote;
	}
	
	public ManageClientMessage_clientService getManageClientMessage_clientService(){
		
		return (ManageClientMessage_clientService)remote;
	}
	
	public MyHotelService getMyHotelService(){
		
		return (MyHotelService)remote;
	}
	
	public MyOrderService getMyOrderService(){
		
		return (MyOrderService)remote;
	}
	
	public SearchHotelService getSearchHotelService(){
		
		return (SearchHotelService)remote;
	}
	
	public ShowCreditRecordService getShowCreditRecordService(){
		
		return (ShowCreditRecordService)remote;
	}
}
