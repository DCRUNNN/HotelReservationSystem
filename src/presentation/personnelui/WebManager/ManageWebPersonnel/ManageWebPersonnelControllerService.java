package presentation.personnelui.WebManager.ManageWebPersonnel;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Vector;

import vo.PersonnelVO;

public interface ManageWebPersonnelControllerService {
	/**
	 * 
	 * @return 得到所有的网站营销人员信息
	 */
	public Vector<Vector<String>> getAllWebSalers();
	/**
	 * @param vo 新的网站销售人员的信息
	 * @return 成功的话返回营销人员的id，否则就是""
	 * */
	public String addNewWebsalers(PersonnelVO vo);
	
	/**
	 * 
	 * @param list
	 * @return
	 */
	public Vector<Vector<String>> change(List<PersonnelVO> list);

	/**
	 * @param vo 修改后的工作人员信息
	 * @return 返回是否修改成功
	 * */
	public boolean modifyPersonnel(PersonnelVO vo);
	
	
	public boolean savePassword(String personnelID,String password);
	
}
