package presentation.clientUI_membership;

import java.rmi.RemoteException;

import javax.swing.Icon;

import presentation.clientUI_account.ManageClientMessageUIController;
import presentation.clientUI_account.accountUI;
import rmi.ClientRemoteHelper;
import service.Client.ApplyForVip.ApplyForVipService;
import vo.ClientVO;

public class ApplyforMemberUIController implements ApplyforMember_clientControllerService
{
	private ApplyForVipService controllerService = ClientRemoteHelper.getInstance().getApplyForVipService();
	
	private memberUI view;
	
	private String clientID;
	
	public ApplyforMemberUIController(String clientID)
	{
		this.clientID = clientID;
	}
	
	@Override
	public ClientVO getClientVO(String clientID) throws RemoteException
	{
		return controllerService.getClientVO(clientID);
	}

	@Override
	public boolean applyNormalVip(String clientID, String birthday) throws RemoteException
	{
		return controllerService.applyNormalVip(clientID, birthday);
	}

	@Override
	public boolean applyBusinessVip(String clientID, String companyAddress, String hotelID) throws RemoteException
	{
		return controllerService.applyBusinessVip(clientID, companyAddress, hotelID);
	}

	@Override
	public boolean checkNormalVip(String clientID) throws RemoteException
	{
		return controllerService.checkNormalVip(clientID);
	}

	@Override
	public boolean checkBusinessVip(String clientID) throws RemoteException
	{
		return controllerService.checkBusinessVip(clientID);
	}

	@Override
	public String getClientID()
	{
		return clientID;
	}

	@Override
	public void accountButtonClicked()
	{
		view.accountButtonClicked();
		
	}

	@Override
	public void hotelButtonClicked()
	{
		view.hotelButtonClicked();
	}

	@Override
	public void creditButtonClicked()
	{
		view.creditButtonClicked();
	}

	@Override
	public void orderButtonClicked()
	{
		view.OrderButtonClicked();
	}

	@Override
	public void setView(memberUI view)
	{
		this.view = view;
		view.setVisible(true);
	}

	@Override
	public void commomMemberButtonClicked()
	{
		view.commonMemberButtonClicked();
	}

	@Override
	public void companyMemberButtonClicked()
	{
		view.companyMemberButtonClicked();
	}

	@Override
	public void applyButtonClicked()
	{
		view.applyButtonClicked();
	}

	@Override
	public void returnMainUIButtonClicked()
	{
		view.returnMainUIButtonClicked();
	}

	@Override
	public Icon getHeadIcon()
	{
		ManageClientMessageUIController manageClientMessageUIController = new ManageClientMessageUIController(clientID);
		accountUI accountView = new accountUI(manageClientMessageUIController);
		return accountView.getHeadIcon();
	}

}
