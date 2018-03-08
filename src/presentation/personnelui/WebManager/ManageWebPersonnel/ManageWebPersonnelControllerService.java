package presentation.personnelui.WebManager.ManageWebPersonnel;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Vector;

import vo.PersonnelVO;

public interface ManageWebPersonnelControllerService {
	/**
	 * 
	 * @return �õ����е���վӪ����Ա��Ϣ
	 */
	public Vector<Vector<String>> getAllWebSalers();
	/**
	 * @param vo �µ���վ������Ա����Ϣ
	 * @return �ɹ��Ļ�����Ӫ����Ա��id���������""
	 * */
	public String addNewWebsalers(PersonnelVO vo);
	
	/**
	 * 
	 * @param list
	 * @return
	 */
	public Vector<Vector<String>> change(List<PersonnelVO> list);

	/**
	 * @param vo �޸ĺ�Ĺ�����Ա��Ϣ
	 * @return �����Ƿ��޸ĳɹ�
	 * */
	public boolean modifyPersonnel(PersonnelVO vo);
	
	
	public boolean savePassword(String personnelID,String password);
	
}
