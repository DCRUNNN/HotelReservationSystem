package presentation.personnelui_hotelWorker.hotelpersonnel.ManageStrategy;

import java.util.Calendar;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

import com.qt.datapicker.DatePicker;

public class ObservingTextField extends JTextField implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
		Calendar calendar = (Calendar) arg1;
		DatePicker dp = (DatePicker) arg0;
		setText(dp.formatDate(calendar,"yyyy-MM-dd"));
	}
}
