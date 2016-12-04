package rmi;

import java.rmi.Remote;

import service.Credit.AddClientCredit.AddClientCreditService;
import service.Order.BrowseOrder_webWorker.BrowseOrder_webWorkerService;
import service.Strategy.ManageWebsiteStrategy.ManageWebsiteStrategyService;

public class WebSalerRemoteHelper {

	private Remote remote;
	private static WebSalerRemoteHelper remoteHelper = new WebSalerRemoteHelper();
	
	public static WebSalerRemoteHelper getInstance (){
		
		return remoteHelper;
	}
	
	private WebSalerRemoteHelper(){
		
	}
	
	public void serRemote(Remote remote){
		this.remote = remote;
	}
	
	public ManageWebsiteStrategyService getManageWebsiteStrategyService(){
		return (ManageWebsiteStrategyService)remote;
	}
	
	public BrowseOrder_webWorkerService getBrowseOrder_webWorkerService(){
		return (BrowseOrder_webWorkerService)remote;
	}
	
	public AddClientCreditService getAddClientCreditService(){
		return (AddClientCreditService)remote;
	}
}
