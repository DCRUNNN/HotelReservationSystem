package presentation.personnelui.WebSaler.ViewOrder;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Vector;

import vo.OrderVO;

public interface ViewOrderControllerService {
	/**
	 * 
	 * @param list
	 * @return
	 * @throws ת��vo
	 */
	public Vector<Vector<String>> change(List<OrderVO> list) throws RemoteException;
	/**
	 * @return �õ����е�δִ�ж���
	 * */
	public Vector<Vector<String>> getAllUnexecutedOrders()throws RemoteException;
	
	/**
	 * @return �õ����е��쳣����
	 * */
	public Vector<Vector<String>> getAllAbnormalOrders()throws RemoteException;
	
	/**
	 * @return ��һ���쳣����ת��Ϊ�ѳ�������
	 * */
	public boolean withdrawAbnormalOrder(String orderID)throws RemoteException;
	
	/**
	 * @return ���ݶ�����ŷ��ض�����Ϣ
	 * */
    public Vector<Vector<String>> getOrderVO(String orderID)throws RemoteException;
    
    /**
     * @return ���ݿͻ�id�õ��ͻ��������쳣����
     * */
    public Vector<Vector<String>> getClientAbnormalOrders(String clientID)throws RemoteException;
    
    public OrderVO getOrderVO1(String orderID)throws RemoteException;
    
}
