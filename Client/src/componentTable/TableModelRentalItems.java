/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componentTable;

import communication.Communication;
import domain.Author;
import domain.AuthorBook;
import domain.Book;
import domain.Rental;
import domain.RentalItem;
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
public class TableModelRentalItems extends AbstractTableModel {

    private ArrayList<RentalItem> list;
    private String[] columnNames = {"Order number", "Title", "Year of publication", "Author"};
    private int on = 0;
    private String message = "";
    private ArrayList<RentalItem> specificList;

    public TableModelRentalItems() {
        list = new ArrayList<>();
    }

    public TableModelRentalItems(Rental rental) {
        try {
            list = (ArrayList<RentalItem>) Communication.getInstance().getAllRentalItems(rental);
        } catch (Exception ex) {
            Logger.getLogger(TableModelRentalItems.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            RentalItem ri = list.get(rowIndex);
            List<AuthorBook> authorbooks = Communication.getInstance().getAllAuthorsByBook(ri.getBook());
            
            switch (columnIndex) {
                case 0:
                    return ri.getOrderNumber();
                case 1:
                    return ri.getBook().getTitle();
                case 2:
                    return ri.getBook().getPublication();
                case 3:
                    List<Author> authors = new ArrayList<>();
                    for (AuthorBook ab : authorbooks) {
                        authors.add(ab.getAuthor());
                    }
                    return authors.toString().replace("[", "").replace("]", "");
                default:
                    return "n/a";
            }
        } catch (Exception ex) {
            Logger.getLogger(TableModelRentalItems.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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

}
