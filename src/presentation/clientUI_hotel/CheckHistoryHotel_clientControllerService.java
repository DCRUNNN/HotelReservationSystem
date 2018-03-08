package presentation.clientUI_hotel;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.Icon;

import presentation.clientUI_order.showAbnormalOrdersUI;
import presentation.clientUI_order.showUnexecutedOrdersUI;
import presentation.clientUI_order.showWithdrawnOrdersUI;
import vo.HotelVO;

public interface CheckHistoryHotel_clientControllerService extends Remote
{
	public String getClientID();
	
	public List<HotelVO> getExecutedHotels(String clientID) throws RemoteException;
	
	public List<HotelVO> getUnexecutedHotels(String clientID) throws RemoteException;
	
	public List<HotelVO> getWithdrawnHotels(String clientID) throws RemoteException;
	
	public List<HotelVO> getAbnormalHotels(String clientID) throws RemoteException;
	
	public HotelVO getHotelVO(String clientID,String hotelID) throws RemoteException;
	
	public void accountButtonClicked_all();
	
	public void orderButtonClicked_all();
	
	public void memberButtonClicked_all();
	
	public void creditButtonClicked_all();
	
	public void setView(showAllHotelsUI view);
	
	public void checkButton1Clicked_all();
	
	public void checkButton2Clicked_all();
	
	public void checkButton3Clicked_all();
	
	public void checkButton4Clicked_all();
	
	public void checkButton5Clicked_all();
	
	public void checkButton6Clicked_all();
	
	public void checkButton7Clicked_all();
	
	public void checkButton8Clicked_all();
	
	public void checkButton9Clicked_all();
	
	public void setView(showSingleHotelUI view);
	
	public void lastButtonClicked();
	
	public void nextButtonClicked();
	
	public void lastPageButtonClicked_all();
	
	public void nextPageButtonClicked_all();
	
	public void exeButtonClicked_all();
	
	public void uneButtonClicked_all();
	
	public void witButtonClicked_all();
	
	public void abnButtonClicked_all();
	
	public void allButtonClicked_exe();
	
	public void uneButtonClicked_exe();
	
	public void witButtonClicked_exe();
	
	public void abnButtonClicked_exe();
	
	public void lastPageButtonClicked_exe();
	
	public void nextPageButtonClicked_exe();
	
	public void accountButtonClicked_exe();
	
	public void orderButtonClicked_exe();
	
	public void memberButtonClicked_exe();
	
	public void creditButtonClicked_exe();
	
	public void allButtonClicked_une();
	
	public void exeButtonClicked_une();
	
	public void witButtonClicked_une();
	
	public void abnButtonClicked_une();
	
	public void lastPageButtonClicked_une();
	
	public void nextPageButtonClicked_une();
	
	public void accountButtonClicked_une();
	
	public void orderButtonClicked_une();
	
	public void memberButtonClicked_une();
	
	public void creditButtonClicked_une();
	
	public void allButtonClicked_wit();
	
	public void uneButtonClicked_wit();
	
	public void exeButtonClicked_wit();
	
	public void abnButtonClicked_wit();
	
	public void lastPageButtonClicked_wit();
	
	public void nextPageButtonClicked_wit();
	
	public void accountButtonClicked_wit();
	
	public void orderButtonClicked_wit();
	
	public void memberButtonClicked_wit();
	
	public void creditButtonClicked_wit();
	
	public void allButtonClicked_abn();
	
	public void uneButtonClicked_abn();
	
	public void exeButtonClicked_abn();
	
	public void witButtonClicked_abn();
	
	public void lastPageButtonClicked_abn();
	
	public void nextPageButtonClicked_abn();
	
	public void accountButtonClicked_abn();
	
	public void orderButtonClicked_abn();
	
	public void memberButtonClicked_abn();
	
	public void creditButtonClicked_abn();
	
	public void setView(showExecutedHotelsUI view);
	
	public void setView(showUnexecutedHotelsUI view);
	
	public void setView(showWithdrawnHotelsUI view);
	
	public void setView(showAbnormalHotelsUI view);
	
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
	
	public void checkButton1Clicked_wit();
	
	public void checkButton2Clicked_wit();
	
	public void checkButton3Clicked_wit();
	
	public void checkButton4Clicked_wit();
	
	public void checkButton5Clicked_wit();
	
	public void checkButton6Clicked_wit();
	
	public void checkButton7Clicked_wit();
	
	public void checkButton8Clicked_wit();
	
	public void checkButton9Clicked_wit();
	
	public void checkButton1Clicked_abn();
	
	public void checkButton2Clicked_abn();
	
	public void checkButton3Clicked_abn();
	
	public void checkButton4Clicked_abn();
	
	public void checkButton5Clicked_abn();
	
	public void checkButton6Clicked_abn();
	
	public void checkButton7Clicked_abn();
	
	public void checkButton8Clicked_abn();
	
	public void checkButton9Clicked_abn();
	
	public void returnButtonClicked();
	
	public void accountButtonClicked_single();
	
	public void orderButtonClicked_single();
	
	public void creditButtonClicked_single();
	
	public void memberButtonClicked_single();
	
	public void returnMainUIButtonClicked_all();
	
	public void returnMainUIButtonClicked_exe();
	
	public void returnMainUIButtonClicked_une();
	
	public void returnMainUIButtonClicked_abn();
	
	public void returnMainUIButtonClicked_wit();
	
	public void returnMainUIButtonClicked_single();
	
	public Icon getHeadIcon();
}
