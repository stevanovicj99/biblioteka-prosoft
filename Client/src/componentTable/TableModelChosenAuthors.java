/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componentTable;

import communication.Communication;
import communication.Response;
import communication.ResponseStatus;
import domain.Author;
import domain.AuthorBook;
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
public class TableModelChosenAuthors extends AbstractTableModel {

    private final String[] columnNames = new String[]{"ID", "Firstname", "Lastname", "Administrator"};
    private List<Book> books = Communication.getInstance().getAllBooks();

    private List<Author> authors;

    public TableModelChosenAuthors() throws Exception {
        authors = new ArrayList<>();
    }

    public TableModelChosenAuthors(Book book) throws Exception {
        authors = book.getAuthors();
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
        Author a = authors.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return a.getId();
            case 1:
                return a.getFirstname();
            case 2:
                return a.getLastname();
            case 3:
                return a.getAdministrator();
            default:
                return "n/a";
        }
    }

    public Author getAuthorAt(int row) {
        Author a = authors.get(row);
        return a;
    }

    public void deleteAuthor(int row) {
        authors.remove(row);
        fireTableDataChanged();
    }

    public List<Author> getAuthors() {
        return authors;
    }
    
//     public List<Author> getNewAuthors() {
//        return updatedAuthors;
//    }

    public void addAuthor(Author author) {
//        Author a = new AuthorBook(author, null);
        authors.add(author);
        //updatedAuthors.add(author);
        fireTableRowsInserted(authors.size() - 1, authors.size() - 1);
        //fireTableDataChanged();
    }

//    public void addAuthorNewList(Author author) {
//        Author a = new AuthorBook(author, null);
//        updatedAuthors.add(author);
//        fireTableDataChanged();
//    }

//    public void refreshTable() throws Exception {
//        authors = Communication.getInstance().getAllAuthors();
//        fireTableDataChanged();
//    }
}
