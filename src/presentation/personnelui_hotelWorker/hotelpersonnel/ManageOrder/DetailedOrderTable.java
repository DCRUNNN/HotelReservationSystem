package presentation.personnelui_hotelWorker.hotelpersonnel.ManageOrder;

import javax.swing.table.AbstractTableModel;

public class DetailedOrderTable extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String[] titleName={};
	Object[][] data;
	
	public DetailedOrderTable(String[][] data,String[] title){
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
        if(column==3||column==4){
        	return true;
        }
        return false;
    }
	
	public void setValueAt(Object value,int row,int column){
        data[row][column]=value;
        fireTableCellUpdated(row, column);
    }

	public Class getColumnClass(int col){
		return getValueAt(0, col).getClass();
	}
	
}
