package presentation.personnelui.controller;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Vector;

import presentation.personnelui.WebSaler.ViewOrder.ViewOrderControllerService;
import rmi.WebSalerRemoteHelper;
import service.Order.BrowseOrder_webWorker.BrowseOrder_webWorkerService;
import vo.OrderVO;
public class ViewOrderUiController implements ViewOrderControllerService{

	BrowseOrder_webWorkerService browseorderservice=WebSalerRemoteHelper.getInstance().getBrowseOrder_webWorkerService();
	Vector<Vector<String>> ordervo;
	List<OrderVO> volist;
	@Override
	public Vector<Vector<String>> change(List<OrderVO> list) throws RemoteException {
       Vector<Vector<String>> result=new Vector<Vector<String>>();
		
		for(OrderVO vo:list){
			Vector<String> vector=new Vector<String>();
			String orderId=vo.getOrderID();
			String clientid=vo.getClientID();
			String orderTime=vo.getOrderCreatedDate();
			String orderState=vo.getOrderStatus();
			String roomnumber=vo.getRoomNumber();
			String roomtype=vo.getRoomType();
			
			vector.add(orderId);
			vector.add(clientid);
			vector.add(orderTime);
			vector.add(orderState);
			vector.add(roomnumber);
			vector.add(roomtype);
			result.add(vector);
		}
		return result;
	}

	@Override
	public Vector<Vector<String>> getAllUnexecutedOrders()  {
		try {
			volist=browseorderservice.getAllUnexecutedOrders();
			ordervo=change(volist);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ordervo;
	}

	@Override
	public Vector<Vector<String>> getAllAbnormalOrders() {
		try {
			volist=browseorderservice.getAllAbnormalOrders();
			ordervo=change(volist);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ordervo;
	}

	@Override
	public boolean withdrawAbnormalOrder(String orderID) {
		boolean q=false;
		try {
			q=browseorderservice.withdrawAbnormalOrder(orderID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return q;
	}

	@Override
	public Vector<Vector<String>> getOrderVO(String orderID) {
		OrderVO vo;
		try {
			vo = browseorderservice.getOrderVO(orderID);
			volist.add(vo);
			ordervo=change(volist);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ordervo;
	}

	@Override
	public Vector<Vector<String>> getClientAbnormalOrders(String clientID) {
		try {
			volist=browseorderservice.getClientAbnormalOrders(clientID);
			ordervo=change(volist);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ordervo;
	}

	@Override
	public OrderVO getOrderVO1(String orderID)  {
		OrderVO vo=null;
		try {
			vo=browseorderservice.getOrderVO(orderID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}


}
