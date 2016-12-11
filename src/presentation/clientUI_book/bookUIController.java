package presentation.clientUI_book;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import rmi.ClientRemoteHelper;
import runner.ClientRunner;
import service.Hotel.SearchHotel.SearchHotelService;
import vo.HotelVO;
import vo.SearchVO;

public class bookUIController implements bookUIControllerService {

	private String clientID ;
	private SearchHotelService search;
	private List<HotelVO> allHotels = new ArrayList<HotelVO>();
	private int currentSize = 0;
    private boolean hasOrdered = false;
    private List<HotelVO> historyHotel;
    
	public bookUIController(String clientID){
		
		new ClientRunner();
		this.clientID = clientID;
		search = ClientRemoteHelper.getInstance().getSearchHotelService();
	}
	
	@Override
	public void initAllHotel(String hotelProvince,String hotelCity,String hotelCBD) {
	
		try {
			search.initAllHotel(clientID, hotelProvince, hotelCity, hotelCBD);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void search(SearchVO searchvo) {
		
		try {
			currentSize =0;
			allHotels = search.search(searchvo);
			showByPoint();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<HotelVO> getThreeHotels() {
	
		List<HotelVO> volist = new ArrayList<HotelVO>();
		if(!hasOrdered){
			//不要求显示历史预订酒店
			int size = allHotels.size();
			//System.out.println(allHotels.size());
			if(currentSize+3>size){
				//剩余酒店数目不足3间
				if(currentSize<size){
					for(int i=currentSize;i<size;i++){
						volist.add(allHotels.get(i));
						currentSize++;
					}
				}
			}else{
				//剩余酒店数目充足
				int curSize = currentSize;
				for(int i=curSize;i<curSize+3;i++){
					volist.add(allHotels.get(i));
					currentSize++;//currentSize加一
				}
			}
		}else{
			//要求显示历史酒店的话
			int size = historyHotel.size();
			if(currentSize+3>size){
				if(currentSize<size){
					for(int i=currentSize;i<size;i++){
						volist.add(historyHotel.get(i));
						currentSize++;
					}
				}
			}else{
				int curSize = currentSize;
				for(int i=curSize;i<curSize+3;i++){
					volist.add(historyHotel.get(i));
					currentSize++;//currentSize加一
				}
			}
		}
		
		return volist;
	}

	@Override
	public int getAllPages() {
		
		if(!hasOrdered){	
			int size = allHotels.size();
			if(size%3==0){
				return size/3;
			}else{
				return size/3+1;
			}
		}else{	
			int size = historyHotel.size();
			if(size%3==0){
				return size/3;
			}else{
				return size/3+1;
			}
		
		}
	}

	@Override
	public int getCurrentPage() {
		
		if(currentSize%3==0){
			return currentSize/3;
		}
		return currentSize/3+1;
	}

	@Override
	public List<HotelVO> getLastThreeHotels() {
		
		List<HotelVO> volist = new ArrayList<HotelVO>();
		if(currentSize<=3){
			//上一页没有可以显示的酒店
			return volist;
		}else{
			int end = 0; //end是上一页的结束的酒店序号
			if(currentSize%3==0){
				end = (currentSize/3-1)*3;
			}else{
				end = (currentSize/3)*3;
			}
			currentSize = end;//把当前页码置为结束序号
			
			if(!hasOrdered){
				for(int i=end-3;i<end;i++){
					volist.add(allHotels.get(i));
				}
			}else{
				for(int i=end-3;i<end;i++){
					volist.add(historyHotel.get(i));
				}
			}
			
			return volist;
		}
		
	}
	
	/**
	 * @return 按酒店星级从高到低的顺序进行排列酒店信息
	 * */
	public void showByStar() {
		
		HotelVO vo1;
		HotelVO vo2;
		int star1;
		int star2;
		for(int i=0;i<allHotels.size()-1;i++){
			for(int j=0;j<allHotels.size()-1-i;j++){
			    vo1 = allHotels.get(j);
			    vo2 = allHotels.get(j+1);
			    star1 = vo1.getHotelStar();
			    star2 = vo2.getHotelStar();
			    if(star1<star2){
			    	allHotels.set(j, vo2);
			    	allHotels.set(j+1, vo1);
			    }
			}
		}
		
		hasOrdered = false;
		currentSize = 0;
	}

	/**
	 * @return 根据评分从高到低的顺序对酒店列表进行排序
	 * */
	public void showByPoint(){
		
		HotelVO vo;
		HotelVO vo2;
		double point;
		double point2;
	    for(int i=0;i<allHotels.size()-1;i++){
	    	for(int j=0;j<allHotels.size()-1-i;j++){
	    		 vo = allHotels.get(j);
	    		 vo2 = allHotels.get(j+1);
	    		 point = vo.getPoint_facilities()+vo.getPoint_service()+vo.getPoint_surroundings();
	    		 point2 = vo2.getPoint_facilities()+vo2.getPoint_service()+vo2.getPoint_surroundings();
	    		if(point<point2){
	    			allHotels.set(j, vo2);
	    			allHotels.set(j+1, vo);//把两个vo进行交换
	    		}
	    	}
	    }
	    
	    hasOrdered = false;
	    currentSize = 0;
	}

	/**
	 * @return 根据酒店最低价格从低到高显示酒店信息
	 * */
	public void showByprice() {
		
		HotelVO vo1;
		HotelVO vo2;
		double minPrice1;
		double minPrice2;
		String [] typeAndPrice1;
		String [] typeAndPrice2;
		for(int i=0;i<allHotels.size()-1;i++){
			for(int j=0;j<allHotels.size()-1-i;j++){
				vo1 = allHotels.get(j);
				vo2 = allHotels.get(j+1);
				typeAndPrice1 = vo1.getRoomTypeAndPrice().split("/");
				minPrice1 = Double.valueOf(typeAndPrice1[0].split("[|]")[1]);
				for(int k=0;k<typeAndPrice1.length;k++){
					String str = typeAndPrice1[k];
					double price = Double.valueOf(str.split("[|]")[1]);
					if(price<minPrice1){
						minPrice1 = price;
					}
				}//得到vo1的最低价格
				
				typeAndPrice2 = vo2.getRoomTypeAndPrice().split("/");
				minPrice2 = Double.valueOf(typeAndPrice2[0].split("[|]")[1]);
				for(int k=0;k<typeAndPrice2.length;k++){
					String str = typeAndPrice2[k];
					double price = Double.valueOf(str.split("[|]")[1]);
					if(price<minPrice2){
						minPrice2 = price;
					}
				}//得到vo2的最低价格
				
				if(minPrice1>minPrice2){
					allHotels.set(j, vo2);
					allHotels.set(j+1, vo1);
				}
			}
		}
		
		hasOrdered = false;
		currentSize=0;
	}

	/**
	 * @return 返回历史预订过的酒店信息列表
	 * */
	public void showHotelOrdered() {
		
		historyHotel = new ArrayList<HotelVO>();
		for(HotelVO vo:allHotels){
			String orderID = vo.getOrderID();
			String ids [] = orderID.split("[|]");
			if(ids.length>=1&&!ids[0].equals("")){
				historyHotel.add(vo);
			}//订单id不为0，就是历史预订过
		}
		System.out.println(historyHotel.size());
		hasOrdered = true;//把标记位置为true
		currentSize = 0;
	}

	@Override
	public String getClientID() {
		
		return clientID;
	}
}
