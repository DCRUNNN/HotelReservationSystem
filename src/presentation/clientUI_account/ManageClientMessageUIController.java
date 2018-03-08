package presentation.clientUI_account;


import java.rmi.RemoteException;
import presentation.clientUI_account.accountUI;
import rmi.ClientRemoteHelper;
import runner.ClientRunner;
import service.Client.ManageClientMessage_client.ManageClientMessage_clientService;
import vo.ClientVO;

public class ManageClientMessageUIController implements ManageClientMessage_clientControllerService
{
	ManageClientMessage_clientService clientService ;
	
	private String clientID;
	
	private accountUI accoutView;
	
	public ManageClientMessageUIController(String clientID)
	{
		this.clientID = clientID;
		clientService =  ClientRemoteHelper.getInstance().getManageClientMessage_clientService();
	}


	public ClientVO getClientVO(String clientID) throws RemoteException
	{
		this.clientID = clientID;
		return clientService.getClientVO(clientID);
	}


	public boolean changeClientMessage(ClientVO vo) throws RemoteException
	{
		return clientService.changeClientMessage(vo);
	}
	
	public void modifyButtonClicked()
	{
		accoutView.modifyButtonClicked();
	}
	
	public void saveButtonClicked()
	{
		accoutView.saveButtonClicked();
	}


	public String getClientID()
	{
		return clientID;
	}


	public void showPersonalMessage()
	{
		accoutView.setVisible(true);
	}


	@Override
	public void setView(accountUI view)
	{
		this.accoutView = view;
		view.setVisible(true);
		
	}

	@Override
	public void orderButtonClicked()
	{
		accoutView.OrderButtonClicked();
		
	}


	@Override
	public void hotelButtonClicked()
	{
		accoutView.hotelButtonClicked();
		
	}


	@Override
	public void creditButtonClicked()
	{
		accoutView.creditButtonClicked();
		
	}


	@Override
	public void memberButtonClicked()
	{
		accoutView.memberButtonClicked();
		
	}


	@Override
	public void returnMainUIButtonClicked()
	{
		accoutView.returnMainUIButtonClicked();
	}


	@Override
	public boolean uploadPicture(byte[] picture, String clientID)  
	{
		try
		{
			return clientService.uploadPicture(picture, clientID);
		} catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public byte[] getClientPicture(String clientID)  
	{
		try
		{
			return clientService.getClientPicture(clientID);
		} catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args){
		ManageClientMessageUIController test=new ManageClientMessageUIController("0000001");
		System.out.println(test.getClientPicture("0000001")==null);
	}

	@Override
	public boolean changeClientPicture(byte[] picture, String clientID)  
	{
		try
		{
			return clientService.changeClientPicture(picture, clientID);
		} catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
