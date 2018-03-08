package presentation.clientUI_order;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.Icon;

import vo.OrderVO;

public interface ManagePersonalOrder_clientControllerService extends Remote
{
	public List<OrderVO> getExecutedOrders(String clientID) throws RemoteException;
	
	public List<OrderVO> getUnexecutedOrders(String clientID) throws RemoteException;
	
	public List<OrderVO> getWithdrawnOrders(String clientID) throws RemoteException;
	
	public List<OrderVO> getAbnormalOrders(String clientID) throws RemoteException;
	
	public OrderVO getOrderVO(String orderID) throws RemoteException;

	public boolean withdraw(String clientID,String orderID) throws RemoteException;
	
	public boolean addComment(String orderID,String comment,int point_facilities,int point_service,int surroundings)throws RemoteException;
	
	public boolean addExtraComment(String orderID,String comment)throws RemoteException;
	
	public String getClientID();
	
	public String getOrderID();
	
	public void accountButtonClicked_all();
	
	public void hotelButtonClicked_all();
	
	public void creditButtonClicked_all();
	
	public void memberButtonClicked_all();
	
	public void accountButtonClicked_abn();
	
	public void hotelButtonClicked_abn();
	
	public void creditButtonClicked_abn();
	
	public void memberButtonClicked_abn();
	
	public void accountButtonClicked_exe();
	
	public void hotelButtonClicked_exe();
	
	public void creditButtonClicked_exe();
	
	public void memberButtonClicked_exe();
	
	public void accountButtonClicked_une();
	
	public void hotelButtonClicked_une();
	
	public void creditButtonClicked_une();
	
	public void memberButtonClicked_une();
	
	public void accountButtonClicked_wit();
	
	public void hotelButtonClicked_wit();
	
	public void creditButtonClicked_wit();
	
	public void memberButtonClicked_wit();
	
	public void setView(showAllOrdersUI view);
	
	public void lastPageButtonClicked_all();
	
	public void nextPageButtonClicked_all();
	
	public void lastPageButtonClicked_exe();
	
	public void nextPageButtonClicked_exe();
	
	public void lastPageButtonClicked_abn();
	
	public void nextPageButtonClicked_abn();
	
	public void lastPageButtonClicked_une();
	
	public void nextPageButtonClicked_une();
	
	public void lastPageButtonClicked_wit();
	
	public void nextPageButtonClicked_wit();
	
	public void executedOrdersButtonClicked_all();
	
	public void unexecutedOrdersButtonClicked_all();
	
	public void abnormalOrdersButtonClicked_all();
	
	public void withdrawnOrdersButtonClicked_all();
	
	public void allOrdersButtonClicked_executed();
	
	public void unexecutedOrdersButtonClicked_executed();
	
	public void abnormalOrdersButtonClicked_executed();
	
	public void withdrawnOrdersButtonClicked_executed();
	
	public void executedOrdersButtonClicked_unexecuted();
	
	public void allOrdersButtonClicked_unexecuted();
	
	public void abnormalOrdersButtonClicked_unexecuted();
	
	public void withdrawnOrdersButtonClicked_unexecuted();
	
	public void executedOrdersButtonClicked_withdrawn();
	
	public void unexecutedOrdersButtonClicked_withdrawn();
	
	public void abnormalOrdersButtonClicked_withdrawn();
	
	public void allOrdersButtonClicked_withdrawn();
	
	public void executedOrdersButtonClicked_abnormal();
	
	public void allOrdersButtonClicked_abnormal();
	
	public void unexecutedOrdersButtonClicked_abnormal();
	
	public void withdrawnOrdersButtonClicked_abnormal();
	
	public void setView(showExecutedOrdersUI view);
	
	public void setView(showUnexecutedOrdersUI view);
	
	public void setView(showWithdrawnOrdersUI view);
	
	public void setView(showAbnormalOrdersUI view);
	
	public void setView(showSingleOrderUI view);
	
	public void checkButton1Clicked_all();
	
	public void checkButton2Clicked_all();
	
	public void checkButton3Clicked_all();
	
	public void checkButton4Clicked_all();
	
	public void checkButton5Clicked_all();
	
	public void checkButton6Clicked_all();
	
	public void checkButton7Clicked_all();
	
	public void checkButton8Clicked_all();
	
	public void checkButton9Clicked_all();
	
	public void checkButton1Clicked_exe();
	
	public void checkButton2Clicked_exe();
	
	public void checkButton3Clicked_exe();
	
	public void checkButton4Clicked_exe();
	
	public void checkButton5Clicked_exe();
	
	public void checkButton6Clicked_exe();
	
	public void checkButton7Clicked_exe();
	
	public void checkButton8Clicked_exe();
	
	public void checkButton9Clicked_exe();
	
	public void checkButton1Clicked_une();
	
	public void checkButton2Clicked_une();
	
	public void checkButton3Clicked_une();
	
	public void checkButton4Clicked_une();
	
	public void checkButton5Clicked_une();
	
	public void checkButton6Clicked_une();
	
	public void checkButton7Clicked_une();
	
	public void checkButton8Clicked_une();
	
	public void checkButton9Clicked_une();
	
	public void checkButton1Clicked_abn();
	
	public void checkButton2Clicked_abn();
	
	public void checkButton3Clicked_abn();
	
	public void checkButton4Clicked_abn();
	
	public void checkButton5Clicked_abn();
	
	public void checkButton6Clicked_abn();
	
	public void checkButton7Clicked_abn();
	
	public void checkButton8Clicked_abn();
	
	public void checkButton9Clicked_abn();
	
	public void checkButton1Clicked_wit();
	
	public void checkButton2Clicked_wit();
	
	public void checkButton3Clicked_wit();
	
	public void checkButton4Clicked_wit();
	
	public void checkButton5Clicked_wit();
	
	public void checkButton6Clicked_wit();
	
	public void checkButton7Clicked_wit();
	
	public void checkButton8Clicked_wit();
	
	public void checkButton9Clicked_wit();
	
	public void returnButtonClicked();
	
	public void accountButtonClicked_comment();
	
	public void hotelButtonClicked_comment();
	
	public void creditButtonClicked_comment();
	
	public void memberButtonClicked_comment();
	
	public void commentButtonClicked();
	
	public void saveButtonClicked();
	
	public void setView(evaluateUI view);
	
	public void commentButton1Clicked();
	
	public void commentButton2Clicked();
	
	public void commentButton3Clicked();
	
	public void commentButton4Clicked();
	
	public void commentButton5Clicked();
	
	public void commentButton6Clicked();
	
	public void commentButton7Clicked();
	
	public void commentButton8Clicked();
	
	public void commentButton9Clicked();
	
	public void allOrdersButtonClicked_comment();
	
	public void withdrawButton1Clicked();
	
	public void withdrawButton2Clicked();
	
	public void withdrawButton3Clicked();
	
	public void withdrawButton4Clicked();
	
	public void withdrawButton5Clicked();
	
	public void withdrawButton6Clicked();
	
	public void withdrawButton7Clicked();
	
	public void withdrawButton8Clicked();
	
	public void withdrawButton9Clicked();
	
	public void accountButtonClicked_single();
	
	public void hotelButtonClicked_single();
	
	public void creditButtonClicked_single();
	
	public void memberButtonClicked_single();
	
	public void returnMainUIButtonClicked_all();
	
	public void returnMainUIButtonClicked_exe();

	public void returnMainUIButtonClicked_une();
	
	public void returnMainUIButtonClicked_wit();
	
	public void returnMainUIButtonClicked_abn();
	
	public void returnMainUIButtonClicked_single();
	
	public void returnMainUIButtonClicked_evaluate();
	
	public Icon getHeadIcon();
}
