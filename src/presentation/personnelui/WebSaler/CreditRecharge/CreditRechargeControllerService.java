package presentation.personnelui.WebSaler.CreditRecharge;

import java.rmi.RemoteException;

import presentation.personnelui.WebSaler.ManageWebStrategy.ManageWebStrategy;
import vo.ClientVO;

public interface CreditRechargeControllerService {
	/**
	 * 
	 * @param clientID
	 * @param point
	 * @return 信用充值是否成功
	 * @throws RemoteException 
	 */
	public boolean addCredit(String clientID,double point) throws RemoteException;
	
	
	/**
	 * 
	 * @param clientID
	 * @return 根据客户id得到客户信息
	 * @throws RemoteException
	 */
	public ClientVO getClientVO(String clientID)throws RemoteException;
	
	/**
	 * 
	 * @param clientID
	 * @return 判断客户id是否存在
	 * @throws RemoteException
	 */
	public boolean checkID(String clientID)throws RemoteException;
	
//	public void setManageWebStrategyView(ManageWebStrategy view);

}
