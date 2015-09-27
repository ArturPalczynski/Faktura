package faktura;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel {

    ArrayList<Object[]> listOfObjectArrays = new ArrayList<Object[]>();

    String columnNames[] = new String[]{"One", "Two", "Three", "Four"};

    Class classTable[] = new Class[]{Integer.class, Integer.class,
        Integer.class, Integer.class};

    public MyTableModel() {

        listOfObjectArrays.add(new Object[]{null, null, null, null});

    }

    @Override
    public int getColumnCount() {

        return columnNames.length;
    }

    @Override
    public int getRowCount() {

        return listOfObjectArrays.size();
    }

    @Override
    public Object getValueAt(int row, int column) {

        return listOfObjectArrays.get(row)[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return classTable[columnIndex];
    }

    @Override
    public String getColumnName(int column) {

        return columnNames[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {

        return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

        int firstColumn = 0;
        int secondColumn = 1;
        int thirdColumn = 2;
        
        if (columnIndex == firstColumn ) {
            listOfObjectArrays.get(rowIndex)[firstColumn] = aValue;
        }
        if (columnIndex == secondColumn) {
            listOfObjectArrays.get(rowIndex)[secondColumn] = aValue;
        }

        if ((listOfObjectArrays.get(rowIndex)[firstColumn] != null) && (listOfObjectArrays.get(rowIndex)[secondColumn] != null)) {

            listOfObjectArrays.get(rowIndex)[thirdColumn] = 
                    (int) listOfObjectArrays.get(rowIndex)[firstColumn] + (int) listOfObjectArrays.get(rowIndex)[secondColumn];
            fireTableChanged(new TableModelEvent(this));

        }

        listOfObjectArrays.get(rowIndex)[columnIndex] = aValue;

    }

    public void addRow() {

        listOfObjectArrays.add(new Object[]{null, null, null, null});
        fireTableStructureChanged();

    }

    public void removeRow() {

        try {
            listOfObjectArrays.remove(listOfObjectArrays.size() - 1);
            fireTableStructureChanged();
        } catch (ArrayIndexOutOfBoundsException arrayException) {
            JOptionPane.showMessageDialog(null, "Wiersz 0!");
            addRow();
        }
    }
}
