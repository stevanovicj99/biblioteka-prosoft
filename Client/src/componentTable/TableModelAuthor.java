/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componentTable;

import communication.Communication;
import communication.Response;
import communication.ResponseStatus;
import domain.Author;
import domain.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jelena
 */
public class TableModelAuthor extends AbstractTableModel {

    private final String[] columnNames = new String[]{"ID", "Firstname", "Lastname", "Administrator"};
    private List<Author> authors;
    private String parameter = "";

    public TableModelAuthor() throws Exception {
        authors = Communication.getInstance().getAllAuthors();
    }
    
    @Override
    public String getColumnName(int column) {
        if (column > columnNames.length) {
            return "n/a";
        }
        return columnNames[column];

    }

    @Override
    public int getRowCount() {
        if (authors == null) {
            return 0;
        }
        return authors.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Author author = authors.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return author.getId();
            case 1:
                return author.getFirstname();
            case 2:
                return author.getLastname();
            case 3:
                return author.getAdministrator();
            default:
                return "n/a";
        }
    }

    public Author getAuthorAt(int row) {
        return authors.get(row);
    }

    public void deleteAuthor(int row) {
        authors.remove(row);
        fireTableDataChanged();
    }

    public void setParameter(String parameter) throws Exception {
        this.parameter = parameter;
        search();
    }

    public List<Author> getAuthors() {
        return authors;
    }

    private void search() throws Exception {
        authors = Communication.getInstance().getAllAuthors();
        if (!parameter.equals("")) {
            ArrayList<Author> newList = new ArrayList<>();
            for (Author a : authors) {
                if (a.getFirstname().toLowerCase().contains(parameter.toLowerCase())) {
                    newList.add(a);
                }
            }
            authors = newList;
        }

        fireTableDataChanged();
    }

    public void addAuthor(Author author) {
        authors.add(author);
        fireTableRowsInserted(authors.size() - 1, authors.size() - 1);
    }

    public void refreshTable() throws Exception {
        authors = Communication.getInstance().getAllAuthors();
        fireTableDataChanged();
    }

}
