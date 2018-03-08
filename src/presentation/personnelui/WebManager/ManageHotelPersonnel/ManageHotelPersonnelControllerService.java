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
	 * @return �õ����еľƵ깤����Ա��Ϣ
	 * */
	public Vector<Vector<String>> getAllHotelWorkers();
	
	/**
	 * @param hotelID �Ƶ���
	 * @return ���ݾƵ��ŷ��ع�����Ա��Ϣ
	 * */
	public Vector<Vector<String>> getHotelWorkerByHotelID(String hotelID);
	
	/**
	 * @param personnelID ������Ա���
	 * @return ���ع�����Ա��Ϣ
	 * */
	public Vector<Vector<String>> getPersonnelVO(String personnelID);
	
	/**
	 * @param personnelName ������Ա����
	 * @return ���ݹ�����Ա���ַ��ط��������Ĺ�����Ա��Ϣ
	 * */
	public Vector<Vector<String>> getPersonnelVOByPersonnelName(String personnelName);
	
	/**
	 * @param vo �޸ĺ�Ĺ�����Ա��Ϣ
	 * @return �����Ƿ��޸ĳɹ�
	 * */
	public boolean modifyPersonnel(PersonnelVO vo);
	/**
	 * @param vo
	 * @return �����ݲ����һ���־û�����PersonnelPO,�ɹ��Ļ�����true������false
	 * */
	public boolean addHotelWorker(PersonnelVO vo);
	
	public boolean savePassword(String personnelID, String password);
	
	
}
