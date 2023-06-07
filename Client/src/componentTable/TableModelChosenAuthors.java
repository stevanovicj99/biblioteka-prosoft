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

    private final String[] columnNames = new String[]{"ID", "Firstname", "Lastname"};
    private List<AuthorBook> authorsbooks = new ArrayList<>();
    private List<Author> authors;

    public TableModelChosenAuthors() throws Exception {
        authorsbooks = new ArrayList<>();
    }

    public TableModelChosenAuthors(Book book) throws Exception {
        authorsbooks = Communication.getInstance().getAllAuthorsByBook(book);
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
        if (authorsbooks == null) {
            return 0;
        }
        return authorsbooks.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        AuthorBook ab = authorsbooks.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return ab.getAuthor().getId();
            case 1:
                return ab.getAuthor().getFirstname();
            case 2:
                return ab.getAuthor().getLastname();
            default:
                return "n/a";
        }
    }

    public Author getAuthorAt(int row) {
        AuthorBook ab = authorsbooks.get(row);
        return ab.getAuthor();
    }

    public void deleteAuthor(int row) {
        authorsbooks.remove(row);
        fireTableDataChanged();
    }

    public List<Author> getAuthors() {
        for (AuthorBook ab : authorsbooks) {
            authors.add(ab.getAuthor());
        }
        return authors;
    }

    public List<AuthorBook> getAuthorsbooks() {
        return authorsbooks;
    }

    public void addAuthor(Author author) {
        AuthorBook ab = new AuthorBook(author, null);
        authorsbooks.add(ab);
        fireTableRowsInserted(authorsbooks.size() - 1, authorsbooks.size() - 1);
        //fireTableDataChanged();
    }

//    public void refreshTable() throws Exception {
//        authors = Communication.getInstance().getAllAuthors();
//        fireTableDataChanged();
//    }
}
