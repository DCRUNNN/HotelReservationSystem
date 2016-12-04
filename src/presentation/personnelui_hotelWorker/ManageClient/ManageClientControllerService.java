package presentation.personnelui_hotelWorker.ManageClient;

import java.util.List;
import java.util.Vector;

import vo.ClientVO;

public interface ManageClientControllerService {
	/*
	 * 转换vo
	 */
	public Vector<Vector<String>> change(List<ClientVO> list);
	
	/*
	 * 得到所有客户信息
	 */
	public List<ClientVO> getAllClientVO();
	
	/*
	 * 根据id得到某个客户的信息
	 */
	public Vector<Vector<String>> getClientVO(String client_id);
	
	/*
	 * 根据客户名称得到某个客户的信息
	 */
	public Vector<Vector<String>> getClientVO1(String name);
	
	/*
	 * 根据会员类型得到客户信息
	 */
	
	public Vector<Vector<String>> getClientVO2(String clienttype);
}
