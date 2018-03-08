package presentation.clientUI_hotel;

import java.rmi.RemoteException;
import java.util.List;

import javax.swing.Icon;

import presentation.clientUI_account.ManageClientMessageUIController;
import presentation.clientUI_account.accountUI;
import rmi.ClientRemoteHelper;
import service.Hotel.MyHotel.MyHotelService;
import vo.HotelVO;

public class CheckHistoryHotelUIController implements CheckHistoryHotel_clientControllerService
{
	MyHotelService clientService = ClientRemoteHelper.getInstance().getMyHotelService();
	
	showAllHotelsUI showAllHotelsView;
	
	showSingleHotelUI showSingleHotelView;
	
	showExecutedHotelsUI showExecutedHotelsView;
	
	showUnexecutedHotelsUI showUnexecutedHotelsView;
	
	showWithdrawnHotelsUI showWithdrawnHotelsView;
	
	showAbnormalHotelsUI showAbnormalHotelsView;
	
	private String clientID;
	
	public CheckHistoryHotelUIController(String clientID)
	{
		this.clientID = clientID;
	}
	
	public String getClientID()
	{
		return clientID;
	}
	
	@Override
	public List<HotelVO> getExecutedHotels(String clientID) throws RemoteException
	{
		return clientService.getExecutedHotels(clientID);
	}

	@Override
	public List<HotelVO> getUnexecutedHotels(String clientID) throws RemoteException
	{
		return clientService.getUnexecutedHotels(clientID);
	}

	@Override
	public List<HotelVO> getWithdrawnHotels(String clientID) throws RemoteException
	{
		return clientService.getWithdrawnHotels(clientID);
	}

	@Override
	public List<HotelVO> getAbnormalHotels(String clientID) throws RemoteException
	{
		return clientService.getAbnormalHotels(clientID);
	}

	@Override
	public HotelVO getHotelVO(String clientID, String hotelID) throws RemoteException
	{
		return clientService.getHotelVO(clientID, hotelID);
	}

	@Override
	public void accountButtonClicked_all()
	{
		showAllHotelsView.accountButtonClicked();
	}

	@Override
	public void orderButtonClicked_all()
	{
		showAllHotelsView.orderButtonClicked();
	}

	@Override
	public void memberButtonClicked_all()
	{
		showAllHotelsView.memberButtonClicked();
	}

	@Override
	public void creditButtonClicked_all()
	{
		showAllHotelsView.creditButtonClicked();
	}

	@Override
	public void setView(showAllHotelsUI view)
	{
		this.showAllHotelsView = view;
		view.setVisible(true);
		
	}

	@Override
	public void checkButton1Clicked_all()
	{
		showAllHotelsView.checkButton1Clicked();
	}

	@Override
	public void checkButton2Clicked_all()
	{
		showAllHotelsView.checkButton2Clicked();
	}

	@Override
	public void checkButton3Clicked_all()
	{
		showAllHotelsView.checkButton3Clicked();
	}

	@Override
	public void checkButton4Clicked_all()
	{
		showAllHotelsView.checkButton4Clicked();
	}

	@Override
	public void checkButton5Clicked_all()
	{
		showAllHotelsView.checkButton5Clicked();
	}

	@Override
	public void checkButton6Clicked_all()
	{
		showAllHotelsView.checkButton6Clicked();
	}

	@Override
	public void checkButton7Clicked_all()
	{
		showAllHotelsView.checkButton7Clicked();
	}

	@Override
	public void checkButton8Clicked_all()
	{
		showAllHotelsView.checkButton8Clicked();
	}

	@Override
	public void checkButton9Clicked_all()
	{
		showAllHotelsView.checkButton9Clicked();
	}

	@Override
	public void setView(showSingleHotelUI view)
	{
		showSingleHotelView = view;
		view.setVisible(true);
	}

	@Override
	public void lastButtonClicked()
	{
		showSingleHotelView.lastButtonClicked();
	}

	@Override
	public void nextButtonClicked()
	{
		showSingleHotelView.nextButtonClicked();
	}

	@Override
	public void lastPageButtonClicked_all()
	{
		showAllHotelsView.lastPageButtonClicked();
	}

	@Override
	public void nextPageButtonClicked_all()
	{
		showAllHotelsView.nextPageButtonClicked();
	}

	@Override
	public void exeButtonClicked_all()
	{
		showAllHotelsView.exeButtonClicked_all();
	}

	@Override
	public void uneButtonClicked_all()
	{
		showAllHotelsView.uneButtonClicked_all();
	}

	@Override
	public void witButtonClicked_all()
	{
		showAllHotelsView.witButtonClicked_all();
	}

	@Override
	public void abnButtonClicked_all()
	{
		showAllHotelsView.abnButtonClicked_all();
	}

	@Override
	public void allButtonClicked_exe()
	{
		showExecutedHotelsView.allButtonClicked_exe();
	}

	@Override
	public void uneButtonClicked_exe()
	{
		showExecutedHotelsView.uneButtonClicked_exe();
	}

	@Override
	public void witButtonClicked_exe()
	{
		showExecutedHotelsView.witButtonClicked_exe();
	}

	@Override
	public void abnButtonClicked_exe()
	{
		showExecutedHotelsView.abnButtonClicked_exe();
	}

	@Override
	public void lastPageButtonClicked_exe()
	{
		showExecutedHotelsView.lastPageButtonClicked();
	}

	@Override
	public void nextPageButtonClicked_exe()
	{
		showExecutedHotelsView.nextPageButtonClicked();
	}

	@Override
	public void accountButtonClicked_exe()
	{
		showExecutedHotelsView.accountButtonClicked();
	}

	@Override
	public void orderButtonClicked_exe()
	{
		showExecutedHotelsView.orderButtonClicked();
	}

	@Override
	public void memberButtonClicked_exe()
	{
		showExecutedHotelsView.memberButtonClicked();
	}

	@Override
	public void creditButtonClicked_exe()
	{
		showExecutedHotelsView.creditButtonClicked();
	}

	@Override
	public void allButtonClicked_une()
	{
		showUnexecutedHotelsView.allButtonClicked_une();
	}

	@Override
	public void exeButtonClicked_une()
	{
		showUnexecutedHotelsView.exeButtonClicked_une();
	}

	@Override
	public void witButtonClicked_une()
	{
		showUnexecutedHotelsView.witButtonClicked_une();
	}

	@Override
	public void abnButtonClicked_une()
	{
		showUnexecutedHotelsView.abnButtonClicked_une();
	}

	@Override
	public void lastPageButtonClicked_une()
	{
		showUnexecutedHotelsView.lastPageButtonClicked();
	}

	@Override
	public void nextPageButtonClicked_une()
	{
		showUnexecutedHotelsView.nextPageButtonClicked();
	}

	@Override
	public void accountButtonClicked_une()
	{
		showUnexecutedHotelsView.accountButtonClicked();
	}

	@Override
	public void orderButtonClicked_une()
	{
		showUnexecutedHotelsView.orderButtonClicked();
	}

	@Override
	public void memberButtonClicked_une()
	{
		showUnexecutedHotelsView.memberButtonClicked();
	}

	@Override
	public void creditButtonClicked_une()
	{
		showUnexecutedHotelsView.creditButtonClicked();
	}

	@Override
	public void allButtonClicked_wit()
	{
		showWithdrawnHotelsView.allButtonClicked_wit();
	}

	@Override
	public void uneButtonClicked_wit()
	{
		showWithdrawnHotelsView.uneButtonClicked_wit();
	}

	@Override
	public void exeButtonClicked_wit()
	{
		showWithdrawnHotelsView.exeButtonClicked_wit();
	}

	@Override
	public void abnButtonClicked_wit()
	{
		showWithdrawnHotelsView.abnButtonClicked_wit();
	}

	@Override
	public void lastPageButtonClicked_wit()
	{
		showWithdrawnHotelsView.lastPageButtonClicked();
	}

	@Override
	public void nextPageButtonClicked_wit()
	{
		showWithdrawnHotelsView.nextPageButtonClicked();
	}

	@Override
	public void accountButtonClicked_wit()
	{
		showWithdrawnHotelsView.accountButtonClicked();
	}

	@Override
	public void orderButtonClicked_wit()
	{
		showWithdrawnHotelsView.orderButtonClicked();
	}

	@Override
	public void memberButtonClicked_wit()
	{
		showWithdrawnHotelsView.memberButtonClicked();
	}

	@Override
	public void creditButtonClicked_wit()
	{
		showWithdrawnHotelsView.creditButtonClicked();
	}

	@Override
	public void allButtonClicked_abn()
	{
		showAbnormalHotelsView.allButtonClicked_abn();
	}

	@Override
	public void uneButtonClicked_abn()
	{
		showAbnormalHotelsView.uneButtonClicked_abn();
	}

	@Override
	public void exeButtonClicked_abn()
	{
		showAbnormalHotelsView.exeButtonClicked_abn();
	}

	@Override
	public void witButtonClicked_abn()
	{
		showAbnormalHotelsView.witButtonClicked_abn();
	}

	@Override
	public void lastPageButtonClicked_abn()
	{
		showAbnormalHotelsView.lastPageButtonClicked();
	}

	@Override
	public void nextPageButtonClicked_abn()
	{
		showAbnormalHotelsView.nextPageButtonClicked();
	}

	@Override
	public void accountButtonClicked_abn()
	{
		showAbnormalHotelsView.accountButtonClicked();
	}

	@Override
	public void orderButtonClicked_abn()
	{
		showAbnormalHotelsView.orderButtonClicked();
	}

	@Override
	public void memberButtonClicked_abn()
	{
		showAbnormalHotelsView.memberButtonClicked();
	}

	@Override
	public void creditButtonClicked_abn()
	{
		showAbnormalHotelsView.creditButtonClicked();
	}

	@Override
	public void setView(showExecutedHotelsUI view)
	{
		this.showExecutedHotelsView = view;
		view.setVisible(true);
	}

	@Override
	public void setView(showUnexecutedHotelsUI view)
	{
		this.showUnexecutedHotelsView = view;
		view.setVisible(true);
	}

	@Override
	public void setView(showWithdrawnHotelsUI view)
	{
		this.showWithdrawnHotelsView = view;
		view.setVisible(true);
	}

	@Override
	public void setView(showAbnormalHotelsUI view)
	{
		this.showAbnormalHotelsView = view;
		view.setVisible(true);
	}

	@Override
	public void checkButton1Clicked_exe()
	{
		showExecutedHotelsView.checkButton1Clicked();
	}

	@Override
	public void checkButton2Clicked_exe()
	{
		showExecutedHotelsView.checkButton2Clicked();
	}

	@Override
	public void checkButton3Clicked_exe()
	{
		showExecutedHotelsView.checkButton3Clicked();
	}

	@Override
	public void checkButton4Clicked_exe()
	{
		showExecutedHotelsView.checkButton4Clicked();
	}

	@Override
	public void checkButton5Clicked_exe()
	{
		showExecutedHotelsView.checkButton5Clicked();
	}

	@Override
	public void checkButton6Clicked_exe()
	{
		showExecutedHotelsView.checkButton6Clicked();
	}

	@Override
	public void checkButton7Clicked_exe()
	{
		showExecutedHotelsView.checkButton7Clicked();
	}

	@Override
	public void checkButton8Clicked_exe()
	{
		showExecutedHotelsView.checkButton8Clicked();
	}

	@Override
	public void checkButton9Clicked_exe()
	{
		showExecutedHotelsView.checkButton9Clicked();
	}

	@Override
	public void checkButton1Clicked_une()
	{
		showUnexecutedHotelsView.checkButton1Clicked();
	}

	@Override
	public void checkButton2Clicked_une()
	{
		showUnexecutedHotelsView.checkButton2Clicked();
	}

	@Override
	public void checkButton3Clicked_une()
	{
		showUnexecutedHotelsView.checkButton3Clicked();
	}

	@Override
	public void checkButton4Clicked_une()
	{
		showUnexecutedHotelsView.checkButton4Clicked();
	}

	@Override
	public void checkButton5Clicked_une()
	{
		showUnexecutedHotelsView.checkButton5Clicked();
	}

	@Override
	public void checkButton6Clicked_une()
	{
		showUnexecutedHotelsView.checkButton6Clicked();
	}

	@Override
	public void checkButton7Clicked_une()
	{
		showUnexecutedHotelsView.checkButton7Clicked();
	}

	@Override
	public void checkButton8Clicked_une()
	{
		showUnexecutedHotelsView.checkButton8Clicked();
	}

	@Override
	public void checkButton9Clicked_une()
	{
		showUnexecutedHotelsView.checkButton9Clicked();
	}

	@Override
	public void checkButton1Clicked_wit()
	{
		showWithdrawnHotelsView.checkButton1Clicked();
	}

	@Override
	public void checkButton2Clicked_wit()
	{
		showWithdrawnHotelsView.checkButton2Clicked();
	}

	@Override
	public void checkButton3Clicked_wit()
	{
		showWithdrawnHotelsView.checkButton3Clicked();
	}

	@Override
	public void checkButton4Clicked_wit()
	{
		showWithdrawnHotelsView.checkButton4Clicked();
	}

	@Override
	public void checkButton5Clicked_wit()
	{
		showWithdrawnHotelsView.checkButton5Clicked();
	}

	@Override
	public void checkButton6Clicked_wit()
	{
		showWithdrawnHotelsView.checkButton6Clicked();
	}

	@Override
	public void checkButton7Clicked_wit()
	{
		showWithdrawnHotelsView.checkButton7Clicked();
	}

	@Override
	public void checkButton8Clicked_wit()
	{
		showWithdrawnHotelsView.checkButton8Clicked();
	}

	@Override
	public void checkButton9Clicked_wit()
	{
		showWithdrawnHotelsView.checkButton9Clicked();
	}

	@Override
	public void checkButton1Clicked_abn()
	{
		showAbnormalHotelsView.checkButton1Clicked();
	}

	@Override
	public void checkButton2Clicked_abn()
	{
		showAbnormalHotelsView.checkButton2Clicked();
	}

	@Override
	public void checkButton3Clicked_abn()
	{
		showAbnormalHotelsView.checkButton3Clicked();
	}

	@Override
	public void checkButton4Clicked_abn()
	{
		showAbnormalHotelsView.checkButton4Clicked();
	}

	@Override
	public void checkButton5Clicked_abn()
	{
		showAbnormalHotelsView.checkButton5Clicked();
	}

	@Override
	public void checkButton6Clicked_abn()
	{
		showAbnormalHotelsView.checkButton6Clicked();
	}

	@Override
	public void checkButton7Clicked_abn()
	{
		showAbnormalHotelsView.checkButton7Clicked();
	}

	@Override
	public void checkButton8Clicked_abn()
	{
		showAbnormalHotelsView.checkButton8Clicked();
	}

	@Override
	public void checkButton9Clicked_abn()
	{
		showAbnormalHotelsView.checkButton9Clicked();
	}

	@Override
	public void returnButtonClicked()
	{
		showSingleHotelView.returnButtonClicked();
	}

	@Override
	public void accountButtonClicked_single()
	{
		showSingleHotelView.accountButtonClicked();
	}

	@Override
	public void orderButtonClicked_single()
	{
		showSingleHotelView.orderButtonClicked();
	}

	@Override
	public void creditButtonClicked_single()
	{
		showSingleHotelView.creditButtonClicked();
	}

	@Override
	public void memberButtonClicked_single()
	{
		showSingleHotelView.memberButtonClicked();
	}

	@Override
	public void returnMainUIButtonClicked_all()
	{
		showAllHotelsView.returnMainUIButtonClicked();
	}

	@Override
	public void returnMainUIButtonClicked_exe()
	{
		showExecutedHotelsView.returnMainUIButtonClicked();
	}

	@Override
	public void returnMainUIButtonClicked_une()
	{
		showUnexecutedHotelsView.returnMainUIButtonClicked();
	}

	@Override
	public void returnMainUIButtonClicked_abn()
	{
		showAbnormalHotelsView.returnMainUIButtonClicked();
	}

	@Override
	public void returnMainUIButtonClicked_wit()
	{
		showWithdrawnHotelsView.returnMainUIButtonClicked();
	}

	@Override
	public void returnMainUIButtonClicked_single()
	{
		showSingleHotelView.returnMainUIButtonClicked();
	}

	@Override
	public Icon getHeadIcon()
	{
		ManageClientMessageUIController manageClientMessageUIController = new ManageClientMessageUIController(clientID);
		accountUI accountView = new accountUI(manageClientMessageUIController);
		return accountView.getHeadIcon();
	}
}
