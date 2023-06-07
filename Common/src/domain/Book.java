/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Jelena
 */
public class Book extends AbstractDomainObject implements Serializable {

    private Long id;
    private String title;
    private int quantity;
    private int publication;

    private List<Author> authors;

    public Book() {
    }

    public Book(Long id, String title, int quantity, int publication, List<Author> authors) {
        this.id = id;
        this.title = title;
        this.quantity = quantity;
        this.publication = publication;
        this.authors = authors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPublication() {
        return publication;
    }

    public void setPublication(int publication) {
        this.publication = publication;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;
        if (this.quantity != other.quantity) {
            return false;
        }
        if (this.publication != other.publication) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.authors, other.authors);
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title=" + title + ", quantity=" + quantity + ", publication=" + publication + ", authors=" + authors + '}';
    }

    @Override
    public String getTableName() {
        return " book ";
    }

    @Override
    public String getAlias() {
        return " b ";
    }

    @Override
    public String join() {
//        return "JOIN author_book ab ON (b.id=ab.bookID)"
//                + " JOIN author aut ON (ab.authorID = aut.id)";
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> getList(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> list = new ArrayList<>();
        while (rs.next()) {
            Book b = new Book(rs.getLong("b.id"), rs.getString("b.title"), rs.getInt("b.quantity"), rs.getInt("b.publication"), null);
            list.add(b);
        }
        rs.close();
        return list;
    }

    @Override
    public String columnsForInsert() {
        return " (id, title, quantity, publication) ";
    }

    @Override
    public String valuesForPrimaryKey() {
        return " id = " + id;
    }

    @Override
    public String valuesForInsert() {
        return id + ", '" + title + "', " + quantity + ", " + publication + " ";
    }

    @Override
    public String valuesForUpdate() {
        return "title = '" + title + "', quantity = " + quantity + ", publication = " + publication + " ";
    }

    @Override
    public String query() {
        return "";
    }

}
