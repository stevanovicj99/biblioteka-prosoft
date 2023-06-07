/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;

import domain.Administrator;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jelena
 */
public class TableModelAdministrator extends AbstractTableModel{
    
    String[] columnNames = new String[]{"Username", "Firstname", "Lastname"};
    List<Administrator> administrators;

    public TableModelAdministrator(List<Administrator> administrators) {
        this.administrators = administrators;
    }

    @Override
    public String getColumnName(int column) {
        if (column > columnNames.length) {
            return "n/a";
        }
        return columnNames[column];

    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public int getRowCount() {
        return administrators.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Administrator administrator = administrators.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return administrator.getUsername();
            case 1:
                return administrator.getFirstname();
            case 2:
                return administrator.getLastname();
            default:
                return "n/a";
        }
    }

    public void addAdministrator(Administrator administrator) {
        if (administrators.contains(administrator)) {
            return;
        }
        administrators.add(administrator);
        fireTableDataChanged();
    }
}
