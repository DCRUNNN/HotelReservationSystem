package presentation.personnelui.controller;

import java.rmi.RemoteException;

import presentation.loginUI.LoginControllerService;
import presentation.loginUI.LoginView;
import presentation.loginUI.RegisterView;
import rmi.LoginRemoteHelper;
import rmi.ClientRemoteHelper;
import service.Account.Login.LoginService;
import service.Client.ManageClientMessage_client.ManageClientMessage_clientService;
import service.Client.NewClient.NewClientService;
import vo.ClientVO;

public class LoginControllerImpl implements LoginControllerService {

	private LoginService loginService;
	
	private NewClientService clientService;
	
	private ManageClientMessage_clientService clientInfoService;
	
	private LoginView loginView;
	
	private RegisterView registerView;
	
	public LoginControllerImpl() {
		// TODO Auto-generated constructor stub
		loginService=LoginRemoteHelper.getInstance().getLoginService();
		clientService=LoginRemoteHelper.getInstance().getNewClientService();
		clientInfoService=ClientRemoteHelper.getInstance().getManageClientMessage_clientService();
	}
	
	@Override
	public void loginButtonClicked() {
		// TODO Auto-generated method stub
		loginView.loginButtonClicked();
	}

	@Override
	public boolean check(String id, String password) {
		try {
			return loginService.check(id, password);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void setLoginView(presentation.loginUI.LoginView view) {
		// TODO Auto-generated method stub
		this.loginView=view;
	}

	@Override
	public void registerButtonClicked() {
		// TODO Auto-generated method stub
		loginView.registerButtonClicked();
	}

	@Override
	public String getType(String ID) {
		// TODO Auto-generated method stub
		try {
			return loginService.getType(ID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	@Override
	public void setRegisterView(RegisterView view) {
		// TODO Auto-generated method stub
		this.registerView=view;
	}

	@Override
	public String insert(ClientVO vo) {
		// TODO Auto-generated method stub
		return clientService.insert(vo);
	}

	@Override
	public boolean savePassword(String clientID, String pass) {
		// TODO Auto-generated method stub
		return clientService.savePassword(clientID, pass);
	}

	@Override
	public boolean isExistPhoneNumber(String phoneNumber) {
		// TODO Auto-generated method stub
		return clientService.isExistPhoneNumber(phoneNumber);
	}

	@Override
	public void confirmRegisterButtonClicked() {
		// TODO Auto-generated method stub
		registerView.confirmRegisterButtonClicked();
	}

	@Override
	public byte[] getClientPicture(String clientID) {
		// TODO Auto-generated method stub
		try {
			return clientInfoService.getClientPicture(clientID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean uploadPicture(byte[] picture, String clientID) {
		// TODO Auto-generated method stub
		try {
			return clientInfoService.uploadPicture(picture, clientID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean changeClientPicture(byte[] b, String clientID) {
		// TODO Auto-generated method stub
		try {
			return clientInfoService.changeClientPicture(b, clientID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
