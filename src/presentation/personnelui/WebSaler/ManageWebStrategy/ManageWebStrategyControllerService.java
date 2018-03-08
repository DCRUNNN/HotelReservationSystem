package presentation.personnelui.WebSaler.ManageWebStrategy;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Vector;

import vo.StrategyVO;

public interface ManageWebStrategyControllerService {
	/**
	 * @return 得到网站的所有营销策略
	 * */
	public Vector<Vector<String>> getAllWebsiteStrategy()throws RemoteException;
	
	/**
	 * @param StrategyVO  营销策略
	 * @return 增加新的营销策略
	 * */
	public boolean addStrategy(StrategyVO strategyVO)throws RemoteException;
	
	/**
	 * @param StrategyVO 营销策略
	 * @return StrategyID不变，对网站营销策略进行修改
	 * */
	public boolean changeStrategy(StrategyVO strategyVO)throws RemoteException;
	
	/**
	 * @param strategyID 策略编号
	 * @return 对策略进行删除
	 * */
	public boolean deleteStrategy(String strategyID)throws RemoteException;
	
	
	public StrategyVO getStrategyVO(String strategyid)throws RemoteException;
	
	/**
	 * @return 返回数据库现有的所有的酒店的省份
	 * */
	public List<String> getAllProvinces()throws RemoteException;
	
	/**
	 * @param province 酒店省份
	 * @return 返回省份对应的所有城市
	 * */
	public List<String> getCities(String province) throws RemoteException;
	
	/**
	 * @param province 酒店省份
	 * @param city 酒店市
	 * @return 返回省份和市的所有商圈
	 * */
	public List<String> getCBDS(String province,String city) throws RemoteException;
	
}
