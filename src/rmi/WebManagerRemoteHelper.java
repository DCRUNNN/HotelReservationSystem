package rmi;

import java.rmi.Remote;

import service.Client.ManageClientMessage_webManager.ClientMessage_webManagerService;
import service.Hotel.AddHotel.AddHotelService;
import service.Personnel.ManagePersonnelMessage.ManagePersonnelMessageService;

public class WebManagerRemoteHelper {

	private Remote remote;
	private static WebManagerRemoteHelper remoteHelper = new WebManagerRemoteHelper();
	
	public static WebManagerRemoteHelper getInstance (){
		
		return remoteHelper;
	}
	
	private WebManagerRemoteHelper(){
		
	}
	
	public void serRemote(Remote remote){
		this.remote = remote;
	}
	
	public ClientMessage_webManagerService getClientMessage_webManagerService(){
		return (ClientMessage_webManagerService)remote;
	}

    public ManagePersonnelMessageService getManagePersonnelMessageService(){
    	return (ManagePersonnelMessageService)remote;
    }
    
    public AddHotelService getAddHotelService(){
    	return (AddHotelService)remote;
    }
}
