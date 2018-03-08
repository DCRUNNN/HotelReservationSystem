package service.Room.ChangeRoomInfo;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import vo.RoomVO;

public interface ChangeRoomInfoService extends Remote{

	/**
	 * @return ���ؾƵ�����з�����Ϣ
	 */
	public List<RoomVO> getAllRoomList(String hotelID) throws RemoteException;
	
	/**
	 * @param roomId �������
	 * @return ���ط�����Ϣ
	 * */
	public RoomVO getRoomByNum(String hotelID,String roomId)throws RemoteException;
	
	/**
	 * @param state ����״̬
	 * @return �����ض�״̬�µ����з�����Ϣ
	 * */
	public List<RoomVO> getRoomByState(String hotelID,String state)throws RemoteException;
	
	/**
	 * @param type ��������
	 * @return ���ظ����͵����з�����Ϣ
	 * */
	public List<RoomVO> getRoomByType(String hotelID,String type)throws RemoteException;
	
	/**
	 * @param type ��������
	 * @param price �۸�
	 * @param hotelId �Ƶ���
	 * @return �����Ƿ��޸ĳɹ�
	 * */
	public boolean changeRoomPrice(String type,double price,String hotelId)throws RemoteException;
	
	public boolean changeRoomPriceById(String hotelId,double price,String roomNumber)throws RemoteException;
	
	public boolean changeRoomType(String hotelId,String roomNumber,String type)throws RemoteException;

	/**
	 * @param hotelId �Ƶ���
	 * @param roomId ������
	 * @param state �µķ���״̬
	 * @return �����Ƿ��޸ĳɹ�
	 * */
	public boolean changeRoomState(String hotelId,String roomId,String state)throws RemoteException;
	
	public boolean changeRoomIntroByType(String hotelId,String roomType,String intro)throws RemoteException;
	
	public boolean changeRoomIntroById(String hotelId,String roomNumber,String intro)throws RemoteException;
	
	/**
	 * @param hotelId �Ƶ���
	 * @param roomId �������
	 * @return �����Ƿ�ɾ���ɹ�
	 * */
	public boolean deleteRoom(String hotelId,String roomId)throws RemoteException;
	
    public List<String> getRoomType(String hotelId)throws RemoteException;
	
	public List<String> getRoomState(String hotelId)throws RemoteException;
}
