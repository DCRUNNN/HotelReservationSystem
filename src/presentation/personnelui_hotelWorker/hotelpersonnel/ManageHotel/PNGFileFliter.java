package presentation.personnelui_hotelWorker.hotelpersonnel.ManageHotel;

import java.io.File;

import javax.swing.filechooser.FileFilter;

	public class PNGFileFliter extends FileFilter{
	@Override
	public boolean accept(File f) {
		// TODO Auto-generated method stub
		if(f.isDirectory()){
			return true;
		}
		if(f.getName().endsWith(".png")){
			return true;
		}
		return false;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "*.png";
	}

}
