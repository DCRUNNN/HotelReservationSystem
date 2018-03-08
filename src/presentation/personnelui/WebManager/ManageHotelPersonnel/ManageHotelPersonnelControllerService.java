package presentation.personnelui.WebManager.ManageHotelPersonnel;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Vector;

import vo.PersonnelVO;

public interface ManageHotelPersonnelControllerService {
	/**
	 * 
	 * @param list
	 * @return
	 */
	public Vector<Vector<String>> change(List<PersonnelVO> list);
	/**
	 * @return 得到所有的酒店工作人员信息
	 * */
	public Vector<Vector<String>> getAllHotelWorkers();
	
	/**
	 * @param hotelID 酒店编号
	 * @return 根据酒店编号返回工作人员信息
	 * */
	public Vector<Vector<String>> getHotelWorkerByHotelID(String hotelID);
	
	/**
	 * @param personnelID 工作人员编号
	 * @return 返回工作人员信息
	 * */
	public Vector<Vector<String>> getPersonnelVO(String personnelID);
	
	/**
	 * @param personnelName 工作人员姓名
	 * @return 根据工作人员名字返回符合条件的工作人员信息
	 * */
	public Vector<Vector<String>> getPersonnelVOByPersonnelName(String personnelName);
	
	/**
	 * @param vo 修改后的工作人员信息
	 * @return 返回是否修改成功
	 * */
	public boolean modifyPersonnel(PersonnelVO vo);
	/**
	 * @param vo
	 * @return 往数据层添加一个持久化数据PersonnelPO,成功的话返回true，否则false
	 * */
	public boolean addHotelWorker(PersonnelVO vo);
	
	public boolean savePassword(String personnelID, String password);
	
	
}
