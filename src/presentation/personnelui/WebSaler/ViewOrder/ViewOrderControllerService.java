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
	 * @throws 转换vo
	 */
	public Vector<Vector<String>> change(List<OrderVO> list) throws RemoteException;
	/**
	 * @return 得到所有的未执行订单
	 * */
	public Vector<Vector<String>> getAllUnexecutedOrders()throws RemoteException;
	
	/**
	 * @return 得到所有的异常订单
	 * */
	public Vector<Vector<String>> getAllAbnormalOrders()throws RemoteException;
	
	/**
	 * @return 将一个异常订单转变为已撤销订单
	 * */
	public boolean withdrawAbnormalOrder(String orderID)throws RemoteException;
	
	/**
	 * @return 根据订单编号返回订单信息
	 * */
    public Vector<Vector<String>> getOrderVO(String orderID)throws RemoteException;
    
    /**
     * @return 根据客户id得到客户的所有异常订单
     * */
    public Vector<Vector<String>> getClientAbnormalOrders(String clientID)throws RemoteException;
    
    public OrderVO getOrderVO1(String orderID)throws RemoteException;
    
}
