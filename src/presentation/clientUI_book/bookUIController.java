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
			//��Ҫ����ʾ��ʷԤ���Ƶ�
			int size = allHotels.size();
			//System.out.println(allHotels.size());
			if(currentSize+3>size){
				//ʣ��Ƶ���Ŀ����3��
				if(currentSize<size){
					for(int i=currentSize;i<size;i++){
						volist.add(allHotels.get(i));
						currentSize++;
					}
				}
			}else{
				//ʣ��Ƶ���Ŀ����
				int curSize = currentSize;
				for(int i=curSize;i<curSize+3;i++){
					volist.add(allHotels.get(i));
					currentSize++;//currentSize��һ
				}
			}
		}else{
			//Ҫ����ʾ��ʷ�Ƶ�Ļ�
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
					currentSize++;//currentSize��һ
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
			//��һҳû�п�����ʾ�ľƵ�
			return volist;
		}else{
			int end = 0; //end����һҳ�Ľ����ľƵ����
			if(currentSize%3==0){
				end = (currentSize/3-1)*3;
			}else{
				end = (currentSize/3)*3;
			}
			currentSize = end;//�ѵ�ǰҳ����Ϊ�������
			
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
	 * @return ���Ƶ��Ǽ��Ӹߵ��͵�˳��������оƵ���Ϣ
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
	 * @return �������ִӸߵ��͵�˳��ԾƵ��б��������
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
	    			allHotels.set(j+1, vo);//������vo���н���
	    		}
	    	}
	    }
	    
	    hasOrdered = false;
	    currentSize = 0;
	}

	/**
	 * @return ���ݾƵ���ͼ۸�ӵ͵�����ʾ�Ƶ���Ϣ
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
				}//�õ�vo1����ͼ۸�
				
				typeAndPrice2 = vo2.getRoomTypeAndPrice().split("/");
				minPrice2 = Double.valueOf(typeAndPrice2[0].split("[|]")[1]);
				for(int k=0;k<typeAndPrice2.length;k++){
					String str = typeAndPrice2[k];
					double price = Double.valueOf(str.split("[|]")[1]);
					if(price<minPrice2){
						minPrice2 = price;
					}
				}//�õ�vo2����ͼ۸�
				
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
	 * @return ������ʷԤ�����ľƵ���Ϣ�б�
	 * */
	public void showHotelOrdered() {
		
		historyHotel = new ArrayList<HotelVO>();
		for(HotelVO vo:allHotels){
			String orderID = vo.getOrderID();
			String ids [] = orderID.split("[|]");
			if(ids.length>=1&&!ids[0].equals("")){
				historyHotel.add(vo);
			}//����id��Ϊ0��������ʷԤ����
		}
		System.out.println(historyHotel.size());
		hasOrdered = true;//�ѱ��λ��Ϊtrue
		currentSize = 0;
	}

	@Override
	public String getClientID() {
		
		return clientID;
	}

	@Override
	public byte[] getHotelImage(String hotelID) {
		
		try {
			return search.getHotelPicture(hotelID);
		} catch (RemoteException e) {
			return null;
		}
	}
}
