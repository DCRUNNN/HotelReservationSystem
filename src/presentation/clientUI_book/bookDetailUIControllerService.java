package presentation.clientUI_book;

public interface bookDetailUIControllerService {

	public void searchButtonClicked();

	public void setView(bookDetailUI bookDetailUI);

	public void lastPageButtonClicked();

	public void nextPageButtonClicked();

	public String getRoomNumber(String roomType);

	public double getPrice(String roomNumbers);

	public String getNextRoomNumber(String roomType, String lastRoomNumber);

	public void ceateButtonClicked();

	public boolean checkCredit(String clientID);

	public boolean checkRoom(String hotelID, String str);

	public boolean createOrder(String hotelID, String clientID, String types, String numbers);

	//public byte[] getHotelPicture(String hotelID);
}
