package Main;

import presentation.controller.InitHotelViewControllerImpl;
import presentation.controller.LoginControllerImpl;
import presentation.loginUI.LoginControllerService;
import presentation.loginUI.LoginView;
import presentation.personnelui_hotelWorker.hotelpersonnel.Init.InitHotelView;
import presentation.personnelui_hotelWorker.hotelpersonnel.Init.InitHotelViewControllerService;
import runner.ClientRunner;
import runner.HotelWorkerRunner;
import runner.LoginRunner;
import runner.WebManagerRunner;
import runner.WebSalerRunner;

public class Runnn {
	
	
	public static void main(String[] args) {
		new HotelWorkerRunner();
//		String hotelId="00001";
//		InitHotelViewControllerService controller=new InitHotelViewControllerImpl(hotelId);
//		InitHotelView view=new InitHotelView(controller);
//		controller.setView(view);
//		view.setVisible(true);
		
		new ClientRunner();
		new HotelWorkerRunner();
		new WebManagerRunner();
		new WebSalerRunner();
		new LoginRunner();
		LoginControllerService controller=new LoginControllerImpl();
		LoginView view=new LoginView(controller);
		controller.setLoginView(view);
		view.setVisible(true);
		
	}
}
