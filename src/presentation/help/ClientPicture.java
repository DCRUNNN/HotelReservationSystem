package presentation.help;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ClientPicture {
	
	public static boolean isExist(String clientID){
		
		String filePathParent = "./picture/clientpicture/"+clientID;//客户图片的文件的目录
		String truePath = "./picture/clientpicture/"+clientID+"/"+clientID;
		
		File f1 = new File(filePathParent);
		File f2 = new File(truePath);
		
		if(!f1.exists()){
			return false;
		}else{
			if(!f2.exists()){
				return false;
			}
		}
		
		return true;
	}
	
	public static Image getLocalPicture(String clientID){
		
		String path = "./picture/clientpicture/"+clientID+"/"+clientID;
		File f = new File(path);
		try {
			BufferedImage bi = ImageIO.read(f);
			return (Image)bi;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static Image changeByteAndSave(byte[] b,String clientID){
		
		String path1 = "./picture";
		String path2 = "./picture/clientpicture";
		String path3 = "./picture/clientpicture/"+clientID;
		String path4 = "./picture/clientpicture/"+clientID+"/"+clientID;
		
		File f1 = new File(path1);
		File f2 = new File(path2);
		File f3 = new File(path3);
		File f4 = new File(path4);
		
		if(!f1.exists()){
			f1.mkdirs();
		}
		
		if(!f2.exists()){
			f2.mkdirs();
		}
		
		if(!f3.exists()){
			f3.mkdirs();
		}
		
		if(!f4.exists()){
			try {
				f4.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			//文件已经存在的话，就是删除文件
			f4.delete();
			try {
				f4.createNewFile();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		
		BufferedOutputStream bos;
		try {
			bos = new BufferedOutputStream(new FileOutputStream(f4));
			bos.write(b);
			bos.close();
			BufferedImage bi = ImageIO.read(f4);
			return (Image)bi;
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static byte[] changeFileToByte(File file){
		
		byte[] b = null;
		//b = new byte[(int)f.length()];
		try{
    		b = new byte[(int)file.length()];
    		BufferedInputStream bi = new BufferedInputStream(new FileInputStream(file));
    		bi.read(b);
    		bi.close();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
		return b;
	}
	

	public static boolean savePictureToLocal(File file,String hotelID){
		
		byte [] b = changeFileToByte(file);
		if(b==null){
			return false;
		}
		
		changeByteAndSave(b,hotelID);
		return true;
	}
}
