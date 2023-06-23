/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componentTable;

import domain.RentalItemComparator;
import communication.Communication;
import domain.Author;
import domain.AuthorBook;
import domain.Book;
import domain.Rental;
import domain.RentalItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jelena
 */
public class TableModelRentalItems extends AbstractTableModel {

    private ArrayList<RentalItem> list;
    private String[] columnNames = {"Order number", "Title", "Year of publication", "Author", "Administrator"};
    private int on = 0;
    private String message = "";

    public TableModelRentalItems() {
        list = new ArrayList<>();
    }

    public TableModelRentalItems(Rental rental) {
        list = rental.getRentalItems();
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
            RentalItem ri = list.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    return ri.getOrderNumber();
                case 1:
                    return ri.getBook().getTitle();
                case 2:
                    return ri.getBook().getPublication();
                case 3:
                    return ri.getBook().getAuthors().toString().replace("[", "").replace("]", "");
                case 4:
                    return ri.getBook().getAdministrator();
                default:
                    return "n/a";
            }
    }

    public void addRentalItem(RentalItem ri) throws Exception {
        ri.setOrderNumber(++on);
        list.add(ri);
        fireTableDataChanged();
    }

    public Book returnRentalItem(int row) {
        RentalItem rentalItem = list.get(row);
        list.remove(row);

        on = 0;
        for (RentalItem ri : list) {
            ri.setOrderNumber(++on);
        }
        fireTableDataChanged();

        return rentalItem.getBook();
    }

    public ArrayList<Book> getAllBooks() {
        ArrayList<Book> books = new ArrayList<>();

        for (RentalItem ri : list) {
            books.add(ri.getBook());
        }
        return books;
    }

    public ArrayList<RentalItem> getList() {
        return list;
    }

    public RentalItem getRentalItemAt(int row) {
        return list.get(row);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void sort(ArrayList<RentalItem> rentItems) {
        Collections.sort(rentItems, new RentalItemComparator());
    }
}
