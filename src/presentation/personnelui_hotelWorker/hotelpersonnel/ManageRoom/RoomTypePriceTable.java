package presentation.personnelui_hotelWorker.hotelpersonnel.ManageRoom;

import javax.swing.table.AbstractTableModel;

public class RoomTypePriceTable extends AbstractTableModel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String[] titleName={};
	String[][] data;
	
	public RoomTypePriceTable(String[][] data,String[] title){
		this.titleName=title;
		this.data=data;
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return titleName.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return data.length;
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return data[rowIndex][columnIndex];
	}
	
	public String getColumnName(int col){
        return titleName[col];
    }
	
	public boolean isCellEditable(int row,int column){
        return false;
    }
	
	public void setValueAt(String value,int row,int column){
        data[row][column]=value;
        fireTableCellUpdated(row, column);
    }
	
	public void setRowCount(int size){
		
	}

}


