package presentation.personnelui.WebManager.ManageClient;

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
	public Vector<Vector<String>> getAllClientVO();
	
	/*
	 * 根据id得到某个客户的信息
	 */
	public Vector<Vector<String>> getClientVO(String client_id);

	
	/*
	 * 修改客户信息
	 */
	public boolean changeClientMessage(ClientVO po);
	
	
	public ClientVO getClientMessgae (String clientid);
}
