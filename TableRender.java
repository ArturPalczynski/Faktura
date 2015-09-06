/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faktura;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;


public class TableRender extends JLabel implements TableCellRenderer{

    public TableRender() {
        super();
        //setForeground(Color.red);
        setFont(new Font("Verdana", Font.BOLD, 11));
        setHorizontalAlignment(CENTER);
        setBorder(BorderFactory.createEtchedBorder());
        setPreferredSize(new Dimension(30, 35));
    }
    
    
    

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
         
        setText(String.valueOf(value));
        
        return this;
    
        }
    
}
