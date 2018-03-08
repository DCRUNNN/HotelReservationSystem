package presentation.clientUI_book;

import java.util.List;

import vo.OrderVO;

public interface hotelDetailUIControllerService {

	public void setUI(hotelDetailUI hotelDetailUI);

	public List<OrderVO> getHistoryOrders();

	public byte[] getPicture(String hotelID);

}
