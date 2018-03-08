package presentation.loginUI;

import vo.ClientVO;

public interface LoginControllerService {

	public void loginButtonClicked();
	
	public void registerButtonClicked();
	
	public boolean check(String id,String password);

	public String getType(String ID);
	
	public void setLoginView(LoginView view);
	
	public void setRegisterView(RegisterView view);
	
	public byte[] getClientPicture(String clientID);
	
	public boolean uploadPicture(byte[] picture,String clientID);
	
	public boolean changeClientPicture(byte[] b,String clientID);

	//зЂВс
	public String insert(ClientVO vo);
	
	public boolean savePassword(String clientID,String pass);
	
	public boolean isExistPhoneNumber(String phoneNumber);
	
	public void confirmRegisterButtonClicked();
}
