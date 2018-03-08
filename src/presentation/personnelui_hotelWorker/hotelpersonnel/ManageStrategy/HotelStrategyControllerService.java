package presentation.personnelui_hotelWorker.hotelpersonnel.ManageStrategy;

import java.util.List;

import vo.HotelVO;
import vo.StrategyVO;

public interface HotelStrategyControllerService {
	
	public String getHotelId();

	public String getStrategyId();
	
	public void manageHotelButtonClicked(int type);
	
	public void manageRoomButtonClicked(int type);
	
	public void manageStrategyButtonClicked(int type);
	
	public void manageOrderButtonClicked(int type);
	
	public void manageInfoButtonClicked(int type);
	
	public void manageCompanyButtonClicked(int type);
	
	public void addStrategyButtonClicked();
	
	public void confirmAddStrategyButtonClicked();
	
	public void cancelButtonClicked(int type);
	
	public void modifyStrategyButtonClicked();
	
	public void confirmModifyStrategyButtonClicked();
	
	public void deleteButtonClicked();
	
	public List<StrategyVO> getAllHotelStrategy(String hotelId);
	
	public void setInitManageStrategyView(InitManageStrategyView view);
	
	public void setAddHotelStrategyView(AddHotelStrategyView view);
	
	public void setModifyHotelStrategyView(ModifyStrategyView view);
	
	public boolean addHotelStrategy(StrategyVO strategyVO);
	
	public boolean changeHotelStrategy(StrategyVO strategyVO);
	
	public boolean deleteHotelStrategy(String strategyID);
	
	public HotelVO getHotelVO(String hotelId);
}
