package presentation.clientUI_credit;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.Icon;

import org.ietf.jgss.Oid;

import vo.CreditVO;

public interface CheckPersonalCredit_clientControllerService extends Remote
{
	public List<CreditVO> ShowAllCredit(String clientID)throws RemoteException;
	
	public double getCreditPoint(String clientID)throws RemoteException;
	
	public String getClientID();
	
	public void setView(creditUI view);
	
	public void accountButtonClicked();
	
	public void orderButtonClicked();
	
	public void hotelButtonClicked();
	
	public void memberButtonClicked();
	
	public void lastPageButtonClicked();
	
	public void nextPageButtonClicked();
	
	public void returnMainUIButtonClicked();
	
	public Icon getHeadIcon();
}
