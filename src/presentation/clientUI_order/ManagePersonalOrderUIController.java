package presentation.clientUI_order;

import java.rmi.RemoteException;

import java.util.List;

import javax.swing.Icon;

import presentation.clientUI_account.ManageClientMessageUIController;
import presentation.clientUI_account.accountUI;
import rmi.ClientRemoteHelper;
import service.Order.EvaluateOrder.EvaluateOrderService;
import service.Order.MyOrder.MyOrderService;
import vo.OrderVO;

public class ManagePersonalOrderUIController implements ManagePersonalOrder_clientControllerService
{
	MyOrderService controllerService = ClientRemoteHelper.getInstance().getMyOrderService();
	
	EvaluateOrderService evaluateOrderControllerService = ClientRemoteHelper.getInstance().getEvaluateOrderService();
	
	private showAllOrdersUI showAllOrdersView;
	
	private showExecutedOrdersUI showExecutedOrdersView;
	
	private showUnexecutedOrdersUI showUnexecutedOrdersView;
	
	private showAbnormalOrdersUI showAbnormalOrdersView;
	
	private showWithdrawnOrdersUI showWithdrawnOrdersView;
	
	private showSingleOrderUI showSingleOrderView;
	
	private evaluateUI evaluateView;
	
	private String clientID;
	
	private String orderID;

	public ManagePersonalOrderUIController(String clientID)
	{
		this.clientID = clientID;
	}
	
	@Override
	public List<OrderVO> getExecutedOrders(String clientID) throws RemoteException
	{
		return controllerService.getExecutedOrders(clientID);
	}

	@Override
	public List<OrderVO> getUnexecutedOrders(String clientID) throws RemoteException
	{
		return controllerService.getUnexecutedOrders(clientID);
	}

	@Override
	public List<OrderVO> getWithdrawnOrders(String clientID) throws RemoteException
	{
		return controllerService.getWithdrawnOrders(clientID);
	}

	@Override
	public List<OrderVO> getAbnormalOrders(String clientID) throws RemoteException
	{
		return controllerService.getAbnormalOrders(clientID);
	}

	@Override
	public OrderVO getOrderVO(String orderID) throws RemoteException
	{
		return controllerService.getOrderVO(orderID);
	}

	@Override
	public boolean withdraw(String clientID, String orderID) throws RemoteException
	{
		return controllerService.withdraw(clientID, orderID);
	}

	@Override
	public String getClientID()
	{
		return clientID;
	}
	
	@Override
	public String getOrderID()
	{
		return orderID;
	}

	@Override
	public void accountButtonClicked_all()
	{
		showAllOrdersView.accountButtonClicked();
	}

	@Override
	public void hotelButtonClicked_all()
	{
		showAllOrdersView.hotelButtonClicked();
	}

	@Override
	public void creditButtonClicked_all()
	{
		showAllOrdersView.creditButtonClicked();
	}

	@Override
	public void memberButtonClicked_all()
	{
		showAllOrdersView.memberButtonClicked();
	}

	@Override
	public void setView(showAllOrdersUI view)
	{
		this.showAllOrdersView = view;
		view.setVisible(true);
	}

	@Override
	public void executedOrdersButtonClicked_all()
	{
		showAllOrdersView.executedOrdersButtonClicked_all();
	}

	@Override
	public void unexecutedOrdersButtonClicked_all()
	{
		showAllOrdersView.unexecutedOrdersButtonClicked_all();
	}

	@Override
	public void abnormalOrdersButtonClicked_all()
	{
		showAllOrdersView.abnormalOrdersButtonClicked_all();
	}

	@Override
	public void withdrawnOrdersButtonClicked_all()
	{
		showAllOrdersView.withdranOrdersButtonClicked_all();
	}

	@Override
	public void setView(showExecutedOrdersUI view)
	{
		this.showExecutedOrdersView = view;
		view.setVisible(true);
	}

	@Override
	public void setView(showUnexecutedOrdersUI view)
	{
		this.showUnexecutedOrdersView = view;
		view.setVisible(true);
	}

	@Override
	public void setView(showWithdrawnOrdersUI view)
	{
		this.showWithdrawnOrdersView = view;
		view.setVisible(true);
	}

	@Override
	public void setView(showAbnormalOrdersUI view)
	{
		this.showAbnormalOrdersView = view;
		view.setVisible(true);
	}

	@Override
	public void allOrdersButtonClicked_executed()
	{
		showExecutedOrdersView.allOrdersButtonClicked();
	}

	@Override
	public void unexecutedOrdersButtonClicked_executed()
	{
		showExecutedOrdersView.unExecutedOrdersButtonClicked();
	}

	@Override
	public void abnormalOrdersButtonClicked_executed()
	{
		showExecutedOrdersView.abnormalOrdersButtonClicked();
	}

	@Override
	public void withdrawnOrdersButtonClicked_executed()
	{
		showExecutedOrdersView.withdrawnOrdersButtonClicked();
	}

	@Override
	public void executedOrdersButtonClicked_unexecuted()
	{
		showUnexecutedOrdersView.executeOrdersButtonClicked();
	}

	@Override
	public void allOrdersButtonClicked_unexecuted()
	{
		showUnexecutedOrdersView.allOrdersButtonClicked();
	}

	@Override
	public void abnormalOrdersButtonClicked_unexecuted()
	{
		showUnexecutedOrdersView.abnormalOrdersButtonClicked();
	}

	@Override
	public void withdrawnOrdersButtonClicked_unexecuted()
	{
		showUnexecutedOrdersView.withdrawnOrdersButtonClicked();
	}

	@Override
	public void executedOrdersButtonClicked_withdrawn()
	{
		showWithdrawnOrdersView.executedOrdersButtonClicked();
	}

	@Override
	public void unexecutedOrdersButtonClicked_withdrawn()
	{
		showWithdrawnOrdersView.unexecutedOrdersButtonClicked();
	}

	@Override
	public void abnormalOrdersButtonClicked_withdrawn()
	{
		showWithdrawnOrdersView.abnormalOrdersButtonClicked();
	}

	@Override
	public void allOrdersButtonClicked_withdrawn()
	{
		showWithdrawnOrdersView.allOrdersButtonClicked();
	}

	@Override
	public void executedOrdersButtonClicked_abnormal()
	{
		showAbnormalOrdersView.executedOrdersButtonClicked();
	}

	@Override
	public void allOrdersButtonClicked_abnormal()
	{
		showAbnormalOrdersView.allOrdersButtonClicked();
	}

	@Override
	public void unexecutedOrdersButtonClicked_abnormal()
	{
		showAbnormalOrdersView.unexecutedOrdersButtonClicked();
	}

	@Override
	public void withdrawnOrdersButtonClicked_abnormal()
	{
		showAbnormalOrdersView.withdranOrdersButtonClicked();
	}

	@Override
	public void checkButton1Clicked_all()
	{
		showAllOrdersView.checkButton1Clicked_all();
	}

	@Override
	public void checkButton2Clicked_all()
	{
		showAllOrdersView.checkButton2Clicked_all();
	}

	@Override
	public void checkButton3Clicked_all()
	{
		showAllOrdersView.checkButton3Clicked_all();
	}

	@Override
	public void checkButton4Clicked_all()
	{
		showAllOrdersView.checkButton4Clicked_all();
	}

	@Override
	public void checkButton5Clicked_all()
	{
		showAllOrdersView.checkButton5Clicked_all();
	}

	@Override
	public void checkButton6Clicked_all()
	{
		showAllOrdersView.checkButton6Clicked_all();
	}

	@Override
	public void checkButton7Clicked_all()
	{
		showAllOrdersView.checkButton7Clicked_all();
	}

	@Override
	public void checkButton8Clicked_all()
	{
		showAllOrdersView.checkButton8Clicked_all();
	}

	@Override
	public void checkButton9Clicked_all()
	{
		showAllOrdersView.checkButton9Clicked_all();
	}

	@Override
	public void checkButton1Clicked_exe()
	{
		showExecutedOrdersView.checkButton1Clicked_exe();
	}

	@Override
	public void checkButton2Clicked_exe()
	{
		showExecutedOrdersView.checkButton2Clicked_exe();
	}

	@Override
	public void checkButton3Clicked_exe()
	{
		showExecutedOrdersView.checkButton3Clicked_exe();
	}

	@Override
	public void checkButton4Clicked_exe()
	{
		showExecutedOrdersView.checkButton4Clicked_exe();
	}

	@Override
	public void checkButton5Clicked_exe()
	{
		showExecutedOrdersView.checkButton5Clicked_exe();
	}

	@Override
	public void checkButton6Clicked_exe()
	{
		showExecutedOrdersView.checkButton6Clicked_exe();
	}

	@Override
	public void checkButton7Clicked_exe()
	{
		showExecutedOrdersView.checkButton7Clicked_exe();
	}

	@Override
	public void checkButton8Clicked_exe()
	{
		showExecutedOrdersView.checkButton8Clicked_exe();
	}

	@Override
	public void checkButton9Clicked_exe()
	{
		showExecutedOrdersView.checkButton9Clicked_exe();
	}

	@Override
	public void checkButton1Clicked_une()
	{
		showUnexecutedOrdersView.checkButton1Clicked_une();
	}

	@Override
	public void checkButton2Clicked_une()
	{
		showUnexecutedOrdersView.checkButton2Clicked_une();
	}

	@Override
	public void checkButton3Clicked_une()
	{
		showUnexecutedOrdersView.checkButton3Clicked_une();
	}

	@Override
	public void checkButton4Clicked_une()
	{
		showUnexecutedOrdersView.checkButton4Clicked_une();
	}

	@Override
	public void checkButton5Clicked_une()
	{
		showUnexecutedOrdersView.checkButton5Clicked_une();
	}

	@Override
	public void checkButton6Clicked_une()
	{
		showUnexecutedOrdersView.checkButton6Clicked_une();
	}

	@Override
	public void checkButton7Clicked_une()
	{
		showUnexecutedOrdersView.checkButton7Clicked_une();
	}

	@Override
	public void checkButton8Clicked_une()
	{
		showUnexecutedOrdersView.checkButton8Clicked_une();
	}

	@Override
	public void checkButton9Clicked_une()
	{
		showUnexecutedOrdersView.checkButton9Clicked_une();
	}

	@Override
	public void checkButton1Clicked_abn()
	{
		showAbnormalOrdersView.checkButton1Clicked_abn();
	}

	@Override
	public void checkButton2Clicked_abn()
	{
		showAbnormalOrdersView.checkButton2Clicked_abn();
	}

	@Override
	public void checkButton3Clicked_abn()
	{
		showAbnormalOrdersView.checkButton3Clicked_abn();
	}

	@Override
	public void checkButton4Clicked_abn()
	{
		showAbnormalOrdersView.checkButton4Clicked_abn();
	}

	@Override
	public void checkButton5Clicked_abn()
	{
		showAbnormalOrdersView.checkButton5Clicked_abn();
	}

	@Override
	public void checkButton6Clicked_abn()
	{
		showAbnormalOrdersView.checkButton6Clicked_abn();
	}

	@Override
	public void checkButton7Clicked_abn()
	{
		showAbnormalOrdersView.checkButton7Clicked_abn();
	}

	@Override
	public void checkButton8Clicked_abn()
	{
		showAbnormalOrdersView.checkButton8Clicked_abn();
	}

	@Override
	public void checkButton9Clicked_abn()
	{
		showAbnormalOrdersView.checkButton9Clicked_abn();
	}

	@Override
	public void checkButton1Clicked_wit()
	{
		showWithdrawnOrdersView.checkButton1Clicked_wit();
	}

	@Override
	public void checkButton2Clicked_wit()
	{
		showWithdrawnOrdersView.checkButton2Clicked_wit();
	}

	@Override
	public void checkButton3Clicked_wit()
	{
		showWithdrawnOrdersView.checkButton3Clicked_wit();
	}

	@Override
	public void checkButton4Clicked_wit()
	{
		showWithdrawnOrdersView.checkButton4Clicked_wit();
	}

	@Override
	public void checkButton5Clicked_wit()
	{
		showWithdrawnOrdersView.checkButton5Clicked_wit();
	}

	@Override
	public void checkButton6Clicked_wit()
	{
		showWithdrawnOrdersView.checkButton6Clicked_wit();
	}

	@Override
	public void checkButton7Clicked_wit()
	{
		showWithdrawnOrdersView.checkButton7Clicked_wit();
	}

	@Override
	public void checkButton8Clicked_wit()
	{
		showWithdrawnOrdersView.checkButton8Clicked_wit();
	}

	@Override
	public void checkButton9Clicked_wit()
	{
		showWithdrawnOrdersView.checkButton9Clicked_wit();
	}

	@Override
	public void setView(showSingleOrderUI view)
	{
		this.showSingleOrderView = view;
		view.setVisible(true);
	}

	@Override
	public void returnButtonClicked()
	{
		showSingleOrderView.returnButtonClicked();
	}

	@Override
	public void accountButtonClicked_abn()
	{
		showAbnormalOrdersView.accountButtonClicked();
	}

	@Override
	public void hotelButtonClicked_abn()
	{
		showAbnormalOrdersView.hotelButtonClicked();
	}

	@Override
	public void creditButtonClicked_abn()
	{
		showAbnormalOrdersView.creditButtonClicked();
	}

	@Override
	public void memberButtonClicked_abn()
	{
		showAbnormalOrdersView.memberButtonClicked();
	}

	@Override
	public void accountButtonClicked_exe()
	{
		showExecutedOrdersView.accountButtonClicked();
	}

	@Override
	public void hotelButtonClicked_exe()
	{
		showExecutedOrdersView.hotelButtonClicked();
	}

	@Override
	public void creditButtonClicked_exe()
	{
		showExecutedOrdersView.creditButtonClicked();
	}

	@Override
	public void memberButtonClicked_exe()
	{
		showExecutedOrdersView.memberButtonClicked();
	}

	@Override
	public void accountButtonClicked_une()
	{
		showUnexecutedOrdersView.accountButtonClicked();
	}

	@Override
	public void hotelButtonClicked_une()
	{
		showUnexecutedOrdersView.hotelButtonClicked();
	}

	@Override
	public void creditButtonClicked_une()
	{
		showUnexecutedOrdersView.creditButtonClicked();
	}

	@Override
	public void memberButtonClicked_une()
	{
		showUnexecutedOrdersView.memberButtonClicked();
	}

	@Override
	public void accountButtonClicked_wit()
	{
		showWithdrawnOrdersView.accountButtonClicked();
	}

	@Override
	public void hotelButtonClicked_wit()
	{
		showWithdrawnOrdersView.hotelButtonClicked();
	}

	@Override
	public void creditButtonClicked_wit()
	{
		showWithdrawnOrdersView.creditButtonClicked();
	}

	@Override
	public void memberButtonClicked_wit()
	{
		showWithdrawnOrdersView.memberButtonClicked();
	}

	@Override
	public void lastPageButtonClicked_all()
	{
		showAllOrdersView.lastPageButtonCliecked_all();
	}

	@Override
	public void nextPageButtonClicked_all()
	{
		showAllOrdersView.nextPageButtonClicked_all();
	}

	@Override
	public void lastPageButtonClicked_exe()
	{
		showExecutedOrdersView.lastPageButtonCliecked();
	}

	@Override
	public void nextPageButtonClicked_exe()
	{
		showExecutedOrdersView.nextPageButtonClicked();
	}

	@Override
	public void lastPageButtonClicked_abn()
	{
		showAbnormalOrdersView.lastPageButtonCliecked();
	}

	@Override
	public void nextPageButtonClicked_abn()
	{
		showAbnormalOrdersView.nextPageButtonClicked();
	}

	@Override
	public void lastPageButtonClicked_une()
	{
		showUnexecutedOrdersView.lastPageButtonCliecked();
	}

	@Override
	public void nextPageButtonClicked_une()
	{
		showUnexecutedOrdersView.nextPageButtonClicked();
	}

	@Override
	public void lastPageButtonClicked_wit()
	{
		showWithdrawnOrdersView.lastPageButtonCliecked();
	}

	@Override
	public void nextPageButtonClicked_wit()
	{
		showWithdrawnOrdersView.nextPageButtonClicked();
	}

	@Override
	public void accountButtonClicked_comment()
	{
		evaluateView.accountButtonClicked();
	}

	@Override
	public void hotelButtonClicked_comment()
	{
		evaluateView.hotelButtonClicked();
	}

	@Override
	public void creditButtonClicked_comment()
	{
		evaluateView.creditButtonClicked();
	}

	@Override
	public void memberButtonClicked_comment()
	{
		evaluateView.memberButtonClicked();
	}

	@Override
	public void commentButtonClicked()
	{
		evaluateView.commentButtonClicked();
	}

	@Override
	public void saveButtonClicked()
	{
		evaluateView.saveButtonClicked();
	}

	@Override
	public void setView(evaluateUI view)
	{
		this.evaluateView = view;
		view.setVisible(true);
	}

	@Override
	public void commentButton1Clicked()
	{
		showExecutedOrdersView.commentButton1Clicked();
	}

	@Override
	public void commentButton2Clicked()
	{
		showExecutedOrdersView.commentButton2Clicked();
	}

	@Override
	public void commentButton3Clicked()
	{
		showExecutedOrdersView.commentButton3Clicked();
	}

	@Override
	public void commentButton4Clicked()
	{
		showExecutedOrdersView.commentButton4Clicked();
	}

	@Override
	public void commentButton5Clicked()
	{
		showExecutedOrdersView.commentButton5Clicked();
	}

	@Override
	public void commentButton6Clicked()
	{
		showExecutedOrdersView.commentButton6Clicked();
	}

	@Override
	public void commentButton7Clicked()
	{
		showExecutedOrdersView.commentButton7Clicked();
	}

	@Override
	public void commentButton8Clicked()
	{
		showExecutedOrdersView.commentButton8Clicked();
	}

	@Override
	public void commentButton9Clicked()
	{
		showExecutedOrdersView.commentButton9Clicked();
	}

	@Override
	public void allOrdersButtonClicked_comment()
	{
		evaluateView.allOrdersButtonClicked();
	}

	@Override
	public void withdrawButton1Clicked()
	{
		showUnexecutedOrdersView.witButton1Clicked();
	}

	@Override
	public void withdrawButton2Clicked()
	{
		showUnexecutedOrdersView.witButton2Clicked();
	}

	@Override
	public void withdrawButton3Clicked()
	{
		showUnexecutedOrdersView.witButton3Clicked();
	}

	@Override
	public void withdrawButton4Clicked()
	{
		showUnexecutedOrdersView.witButton4Clicked();
	}

	@Override
	public void withdrawButton5Clicked()
	{
		showUnexecutedOrdersView.witButton5Clicked();
	}

	@Override
	public void withdrawButton6Clicked()
	{
		showUnexecutedOrdersView.witButton6Clicked();
	}

	@Override
	public void withdrawButton7Clicked()
	{
		showUnexecutedOrdersView.witButton7Clicked();
	}

	@Override
	public void withdrawButton8Clicked()
	{
		showUnexecutedOrdersView.witButton8Clicked();
	}

	@Override
	public void withdrawButton9Clicked()
	{
		showUnexecutedOrdersView.witButton9Clicked();
	}

	@Override
	public boolean addComment(String orderID, String comment, int point_facilities, int point_service, int surroundings)
			throws RemoteException
	{
		return evaluateOrderControllerService.addComment(orderID, comment, point_facilities, point_service, surroundings);
	}

	@Override
	public boolean addExtraComment(String orderID, String comment) throws RemoteException
	{
		return evaluateOrderControllerService.addExtraComment(orderID, comment);
	}

	@Override
	public void accountButtonClicked_single()
	{
		showSingleOrderView.accountButtonClicked();
	}

	@Override
	public void hotelButtonClicked_single()
	{
		showSingleOrderView.hotelButtonClicked();
	}

	@Override
	public void creditButtonClicked_single()
	{
		showSingleOrderView.creditButtonClicked();
	}

	@Override
	public void memberButtonClicked_single()
	{
		showSingleOrderView.memberButtonClicked();
	}

	@Override
	public void returnMainUIButtonClicked_all()
	{
		showAllOrdersView.returnMainUIButtonClicked();
	}

	@Override
	public void returnMainUIButtonClicked_exe()
	{
		showExecutedOrdersView.returnMainUIButtonClicked();
	}

	@Override
	public void returnMainUIButtonClicked_une()
	{
		showUnexecutedOrdersView.returnMainUIButtonClicked();
	}

	@Override
	public void returnMainUIButtonClicked_wit()
	{
		showWithdrawnOrdersView.returnMainUIButtonClicked();
	}

	@Override
	public void returnMainUIButtonClicked_abn()
	{
		showAbnormalOrdersView.returnMainUIButtonClicked();
	}

	@Override
	public void returnMainUIButtonClicked_single()
	{
		showSingleOrderView.returnMainUIButtonClicked();
	}

	@Override
	public void returnMainUIButtonClicked_evaluate()
	{
		evaluateView.returnMainUIButtonClicked();
	}

	@Override
	public Icon getHeadIcon()
	{
		ManageClientMessageUIController manageClientMessageUIController = new ManageClientMessageUIController(clientID);
		accountUI accountView = new accountUI(manageClientMessageUIController);
		return accountView.getHeadIcon();
	}

}
