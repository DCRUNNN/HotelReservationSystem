package presentation.personnelui.WebSaler.CreditRecharge;

import java.rmi.RemoteException;

import presentation.personnelui.WebSaler.ManageWebStrategy.ManageWebStrategy;
import vo.ClientVO;

public interface CreditRechargeControllerService {
	/**
	 * 
	 * @param clientID
	 * @param point
	 * @return ���ó�ֵ�Ƿ�ɹ�
	 * @throws RemoteException 
	 */
	public boolean addCredit(String clientID,double point) throws RemoteException;
	
	
	/**
	 * 
	 * @param clientID
	 * @return ���ݿͻ�id�õ��ͻ���Ϣ
	 * @throws RemoteException
	 */
	public ClientVO getClientVO(String clientID)throws RemoteException;
	
	/**
	 * 
	 * @param clientID
	 * @return �жϿͻ�id�Ƿ����
	 * @throws RemoteException
	 */
	public boolean checkID(String clientID)throws RemoteException;
	
//	public void setManageWebStrategyView(ManageWebStrategy view);

}
