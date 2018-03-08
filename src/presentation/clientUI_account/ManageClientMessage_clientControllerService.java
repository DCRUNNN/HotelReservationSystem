package presentation.clientUI_account;

import java.rmi.Remote;

import java.rmi.RemoteException;
import vo.ClientVO;

public interface ManageClientMessage_clientControllerService extends Remote
{
	public ClientVO getClientVO(String clientID) throws RemoteException;
	
	public boolean changeClientMessage(ClientVO vo) throws RemoteException;
	
	public boolean uploadPicture(byte[] picture,String clientID) throws RemoteException;
	
	public byte[] getClientPicture(String clientID)throws RemoteException;
	
	public boolean changeClientPicture(byte[] picture,String clientID)throws RemoteException;
	
	public void modifyButtonClicked();//to be added
	
	public void saveButtonClicked();// to be added
	
	public void orderButtonClicked();//to be added
	
	public void hotelButtonClicked();//to be added
	
	public void creditButtonClicked();//to be added
	
	public void memberButtonClicked();//to be added
	
	public String getClientID();//to be added;
	
	public void setView(accountUI view);//to be added
	
	public void returnMainUIButtonClicked();
}
