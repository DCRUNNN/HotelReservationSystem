package presentation.clientUI_book;

import java.util.List;

import vo.HotelVO;
import vo.SearchVO;

public interface bookUIControllerService {

	public void initAllHotel(String hotelProvince, String hotelCity, String hotelCBD);

	public void search(SearchVO searchvo);

	public List<HotelVO> getThreeHotels();

	public int getAllPages();

	public int getCurrentPage();

	public List<HotelVO> getLastThreeHotels();

	public void showByprice();

	public void showByPoint();

	public void showByStar();

	public void showHotelOrdered();

	public String getClientID();

}
