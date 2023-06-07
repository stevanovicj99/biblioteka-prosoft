/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.book;

import domain.AbstractDomainObject;
import domain.Author;
import domain.AuthorBook;
import domain.Book;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import operation.AbstractGenericOperation;
import repository.database.DBRepository;

/**
 *
 * @author Jelena
 */
public class AddBook extends AbstractGenericOperation {

    AuthorBook ab;
    Book book;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Book)) {
            throw new Exception("The last object is not an instance of the Book!");
        }

        Book b = (Book) ado;

        ArrayList<Book> books = (ArrayList<Book>) (ArrayList<?>) DBRepository.getInstance().select(ado);

        for (Book book : books) {
            if (book.getTitle().equals(b.getTitle()) && book.getPublication() == b.getPublication()) {
                throw new Exception("There is already a book with that title and year of publication");
            }
        }
    }

    @Override
    protected void executeOperation(AbstractDomainObject ado) throws Exception {
//        DBRepository.getInstance().insert(ado);
        PreparedStatement ps = DBRepository.getInstance().insert(ado);
        ResultSet tableKeys = ps.getGeneratedKeys();
        tableKeys.next();

        Long bookID = tableKeys.getLong(1);
        book = (Book) ado;
        book.setId(bookID);

        ab = new AuthorBook();
        for (Author author : book.getAuthors()) {
            ab.setAuthor(author);
            ab.setBook(book);
            DBRepository.getInstance().insert(ab);
        }
    }

    public Book getBook() {
        return book;
    }

}
