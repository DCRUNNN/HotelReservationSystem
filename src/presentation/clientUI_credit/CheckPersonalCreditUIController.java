package presentation.clientUI_credit;

import java.rmi.RemoteException;
import java.util.List;

import javax.swing.Icon;

import presentation.clientUI_account.ManageClientMessageUIController;
import presentation.clientUI_account.accountUI;
import rmi.ClientRemoteHelper;
import service.Credit.ShowCreditRecord.ShowCreditRecordService;
import vo.CreditVO;

public class CheckPersonalCreditUIController implements CheckPersonalCredit_clientControllerService
{
	ShowCreditRecordService controllerService = ClientRemoteHelper.getInstance().getShowCreditRecordService();
	
	private creditUI view;
	
	private String clientID;
	
	public CheckPersonalCreditUIController(String clientID)
	{
		this.clientID =clientID;
	}
	
	@Override
	public List<CreditVO> ShowAllCredit(String clientID) throws RemoteException
	{
		return controllerService.ShowAllCredit(clientID);
	}

	@Override
	public double getCreditPoint(String clientID) throws RemoteException
	{
		return controllerService.getCreditPoint(clientID);
	}

	@Override
	public String getClientID()
	{
		return clientID;
	}

	@Override
	public void setView(creditUI view)
	{
		this.view = view;
		view.setVisible(true);
	}

	@Override
	public void accountButtonClicked()
	{
		view.accountButtonClicked();
	}

	@Override
	public void orderButtonClicked()
	{
		view.orderButtonClicked();
	}

	@Override
	public void hotelButtonClicked()
	{
		view.hotelButtonClicked();
	}

	@Override
	public void memberButtonClicked()
	{
		view.memberButtonClicked();
	}

	@Override
	public void lastPageButtonClicked()
	{
		view.lastPageButtonClicked();
	}

	@Override
	public void nextPageButtonClicked()
	{
		view.nextButtonClicked();
	}

	@Override
	public void returnMainUIButtonClicked()
	{
		view.returnMainUIButtonClicked();
	}
	
	public Icon getHeadIcon()
	{
		ManageClientMessageUIController manageClientMessageUIController = new ManageClientMessageUIController(clientID);
		accountUI accountView = new accountUI(manageClientMessageUIController);
		return accountView.getHeadIcon();
	}
}
