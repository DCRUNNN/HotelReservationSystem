package rmi;

import java.rmi.Remote;

import service.Account.Login.LoginService;
import service.Client.NewClient.NewClientService;

public class LoginRemoteHelper {

	private Remote remote;
	
	private static LoginRemoteHelper remoteHelper = new LoginRemoteHelper();
	
	private LoginRemoteHelper(){
		
	}
	
	public static LoginRemoteHelper getInstance (){
		
		return remoteHelper;
	}
	
	public void setRemote(Remote remote){
		this.remote = remote;
	}
	
	public LoginService getLoginService(){
		return (LoginService)remote;
	}
	
	public NewClientService getNewClientService(){
		return (NewClientService)remote;
	}
}
