package presentation.personnelui.WebManager.ManageClient;

import java.util.List;
import java.util.Vector;

import vo.ClientVO;

public interface ManageClientControllerService {
	/*
	 * ת��vo
	 */
	public Vector<Vector<String>> change(List<ClientVO> list);
	
	/*
	 * �õ����пͻ���Ϣ
	 */
	public Vector<Vector<String>> getAllClientVO();
	
	/*
	 * ����id�õ�ĳ���ͻ�����Ϣ
	 */
	public Vector<Vector<String>> getClientVO(String client_id);

	
	/*
	 * �޸Ŀͻ���Ϣ
	 */
	public boolean changeClientMessage(ClientVO po);
	
	
	public ClientVO getClientMessgae (String clientid);
}
