package presentation.personnelui.WebManager.AddNewHotel;

import java.rmi.RemoteException;

import vo.HotelVO;
import vo.PersonnelVO;

public interface AddNewHotelControllerService{
	/**
	 * @param HotelPO
	 * 记住调用顺序，一定要先增添一个hotel，才能增加对应的hotelworker
	 * @return 添加成功的话，返回酒店编号，不成功的话，返回""
	 * */
	public String addHotel(HotelVO vo);
	
}
