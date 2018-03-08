package runner;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import rmi.LoginRemoteHelper;
import service.Account.Login.LoginService;

public class LoginRunner {

	private static LoginRemoteHelper remoteHelper;
	
	public LoginRunner(){
		
		linkToServer();
	}

	private void linkToServer() {
		
		try {
			remoteHelper = LoginRemoteHelper.getInstance();
			remoteHelper.setRemote(Naming.lookup("rmi://localhost:9999/LoginDataRemoteObject"));
			System.out.println("linked");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	

	public static void main(String args[]) throws IOException{
		
		new LoginRunner();
		//System.out.println("asdasd");
		LoginService service = remoteHelper.getLoginService();
		try {
			//System.out.println(service.getClientPicture("123").getName());
			byte[] b = service.getClientPicture("asd");
			String filePath = "./0000001.jpg";
			File f = new File(filePath);
			if(!f.exists()){
				f.createNewFile();
			}
			BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(f));
			os.write(b);//写到文件里面
			
			BufferedImage bi = ImageIO.read(f);
			Image im = (Image)bi;//这样就是一个图片文件
			JButton bt = new JButton(new ImageIcon(im));
			JFrame frame = new JFrame();
			frame.setLocationRelativeTo(null);
			frame.setSize(500, 500);
			frame.add(bt);
			frame.setVisible(true);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*String filePath = "./picture/clientpicture/"+"0000001";
		File f = new File(filePath);
		if(!f.exists()){
			f.mkdirs();
			System.out.println("Make a directory successfully!");
		}*/
		
	}
}
