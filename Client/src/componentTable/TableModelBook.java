/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componentTable;

import communication.Communication;
import domain.Author;
import domain.AuthorBook;
import domain.Book;
import java.io.Serializable;
import java.lang.System.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jelena
 */
public class TableModelBook extends AbstractTableModel {

    private final String[] columnNames = new String[]{"ID", "Title", "Quantity", "Year of publication", "Authors"};
    private List<Book> books;
    private String parameter = "";

    public TableModelBook() throws Exception {
        books = Communication.getInstance().getAllBooks();
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
        if (books == null) {
            return 0;
        }
        return books.size();
    }

    @Override
    public int getColumnCount() {
        return 5;

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            Book book = books.get(rowIndex);

            List<AuthorBook> authorbooks = Communication.getInstance().getAllAuthorsByBook(book);
            switch (columnIndex) {
                case 0:
                    return book.getId();
                case 1:
                    return book.getTitle();
                case 2:
                    return book.getQuantity();
                case 3:
                    return book.getPublication();
                case 4:
                    List<Author> authors = new ArrayList<>();
                    for (AuthorBook ab : authorbooks) {
                        authors.add(ab.getAuthor());
                    }
                    return authors.toString().replace("[", "").replace("]", "");

                default:
                    return "n/a";
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(TableModelBook.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Book getBookAt(int row) {
        return books.get(row);
    }

    public void deleteBook(int row) {
        books.remove(row);
        fireTableDataChanged();
    }

    public void setParameter(String parameter) throws Exception {
        this.parameter = parameter;
        search();
    }

    public void addBook(Book b) {
        books.add(b);
        fireTableRowsInserted(books.size() - 1, books.size() - 1);
    }

    public void search() throws Exception {
        books = Communication.getInstance().getAllBooks();
        if (!parameter.equals("")) {
            ArrayList<Book> newList = new ArrayList<>();
            for (Book b : books) {
                if (b.getTitle().toLowerCase().contains(parameter.toLowerCase())) {
                    //|| b.getAuthors().toString().toLowerCase().contains(parameter.toLowerCase())) {
                    newList.add(b);
                }
            }
            books = newList;
        }
        fireTableDataChanged();
    }

    public void refreshTable() throws Exception {
        books = Communication.getInstance().getAllBooks();
        fireTableDataChanged();
    }
    String message = "";

    public Book rentBook(int row) throws Exception {
        Book book = books.get(row);
        int quantity = book.getQuantity();

        book.setQuantity(--quantity);
        fireTableDataChanged();
        return book;
    }

    public void rentAllBooks(List<Book> listBook) throws Exception {
        for (Book book : listBook) {
            int quantity = book.getQuantity();
            book.setQuantity(quantity);
            Communication.getInstance().editBook(book);
        }
    }

    public void returnAllBooks(List<Book> listBook) throws Exception {
        for (Book book : listBook) {
            int quantity = book.getQuantity();
            book.setQuantity(++quantity);
            Communication.getInstance().editBook(book);
        }
    }

    public String getMessage() {
        return message;
    }

    public void returnBook(Book book) {
        int quantity = book.getQuantity();
        book.setQuantity(++quantity);
        fireTableDataChanged();
    }
}
