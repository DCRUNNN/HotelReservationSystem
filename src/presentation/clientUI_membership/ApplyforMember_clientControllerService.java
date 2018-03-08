package presentation.clientUI_membership;

import java.rmi.Remote;
import java.rmi.RemoteException;

import javax.swing.Icon;

import vo.ClientVO;

public interface ApplyforMember_clientControllerService extends Remote
{
	public ClientVO getClientVO(String clientID)  throws RemoteException;

	public boolean applyNormalVip(String clientID,String birthday)throws RemoteException;
	
    public boolean applyBusinessVip(String clientID,String companyAddress,String hotelID)throws RemoteException;
    
    public boolean checkNormalVip(String clientID)throws RemoteException;
    
    public boolean checkBusinessVip(String clientID)throws RemoteException;
    
    public String getClientID();
    
    public void accountButtonClicked();
    
    public void hotelButtonClicked();
    
    public void creditButtonClicked();
    
    public void orderButtonClicked();
    
    public void setView(memberUI view);
    
    public void commomMemberButtonClicked();
    
    public void companyMemberButtonClicked();
    
    public void applyButtonClicked();
    
    public void returnMainUIButtonClicked();
    
    public Icon getHeadIcon();
}
