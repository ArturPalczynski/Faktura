
package faktura;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;


public class Column4Renderer extends JLabel implements TableCellRenderer{

    public Column4Renderer() {
    
        super.setOpaque(true);
        setBackground(Color.GREEN);
    }

    
    
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        
        
        if(value == null){
            setText("");
        }else{
        
        setText(String.valueOf(value));
        }
        
        
    
    
    return this;
    
    }

    
}