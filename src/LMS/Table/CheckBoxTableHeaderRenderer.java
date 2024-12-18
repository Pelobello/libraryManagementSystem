/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LMS.Table;

import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author USER
 */
public class CheckBoxTableHeaderRenderer extends JCheckBox implements TableCellRenderer{
    private final JTable table;
    private final int column;

    public CheckBoxTableHeaderRenderer( JTable table,int column) {
        this.table = null;
        this.column = 0;
    }
    

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
      return this;
    }
    
}
