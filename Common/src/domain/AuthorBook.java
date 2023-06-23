/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Jelena
 */
public class AuthorBook extends AbstractDomainObject implements Serializable {

    private Author author;
    private Book book;

    public AuthorBook() {
    }

    public AuthorBook(Author author, Book book) {
        this.author = author;
        this.book = book;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final AuthorBook other = (AuthorBook) obj;
        if (!Objects.equals(this.author, other.author)) {
            return false;
        }
        return Objects.equals(this.book, other.book);
    }

    @Override
    public String toString() {
        return "AuthorBook{" + "author=" + author + ", book=" + book + '}';
    }

    @Override
    public String getTableName() {
        return "author_book";
    }

    @Override
    public String getAlias() {
        return "ab";
    }

    @Override
    public String join() {
        return "JOIN book b ON (ab.bookID=b.id)"
                + " JOIN author aut ON (ab.authorID = aut.id)";
    }

    @Override
    public ArrayList<AbstractDomainObject> getList(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> list = new ArrayList<>();

        while (rs.next()) {
            Author a = new Author(rs.getLong("aut.id"), rs.getString("aut.firstname"), rs.getString("aut.lastname"));

            Book b = new Book(rs.getLong("b.id"), rs.getString("b.title"), rs.getInt("b.quantity"), rs.getInt("b.publication"));

            AuthorBook ab = new AuthorBook(a, b);

            list.add(ab);
        }
        rs.close();
        return list;
    }

    @Override
    public String columnsForInsert() {
        return "(authorID, bookID)";
    }

    @Override
    public String valuesForPrimaryKey() {
        return " authorID = " + author.getId() + " AND bookID = " + book.getId();
    }

    @Override
    public String valuesForInsert() {
        return author.getId() + ", " + book.getId() + " ";
    }

    @Override
    public String valuesForUpdate() {
        return "authorID = " + author.getId() + ", bookID = " + book.getId() + " ";

    }

    @Override
    public String query() {
        if (book != null) {
            return " WHERE b.id = " + book.getId();
        }

        return "";
    }

}
