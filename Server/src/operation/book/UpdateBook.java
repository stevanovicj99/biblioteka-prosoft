/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.book;

import controller.Controller;
import domain.AbstractDomainObject;
import domain.Author;
import domain.AuthorBook;
import domain.Book;
import java.util.ArrayList;
import java.util.List;
import operation.AbstractGenericOperation;
import repository.database.DBRepository;

/**
 *
 * @author Jelena
 */
public class UpdateBook extends AbstractGenericOperation {

    AuthorBook ab;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Book)) {
            throw new Exception("The last object is not an instance of the Book!");
        }

        Book b = (Book) ado;

        ArrayList<Book> books = (ArrayList<Book>) (ArrayList<?>) DBRepository.getInstance().select(ado);

        for (Book book : books) {
            if (!book.getId().equals(b.getId())) {
                if (book.getTitle().equals(b.getTitle()) && book.getPublication() == b.getPublication()) {
                    throw new Exception("There is already a book with that title and year of publication");
                }
            }
        }
    }

    @Override
    protected void executeOperation(AbstractDomainObject ado) throws Exception {
        DBRepository.getInstance().update(ado);

        Book book = (Book) ado; // ovde sam poslala novog autora sa nikolom (i marka)

        ab = new AuthorBook();

        List<AuthorBook> listOfAuthors = Controller.getInstance().getAllAuthorsByBook(book); // nikolu
        List<Author> authors = new ArrayList<>();
        //authors = book.getAuthors();
        for (AuthorBook authorBook : listOfAuthors) {
            authors.add(authorBook.getAuthor()); //prebacila nikolu u listu
        }

        //prvo proveravam da li u ovim postojecim autorima u bazi za tu knjigu postoji nikola 
        //ako u ovoj sad operativnoj nikola postoji, a u bazi ne postoji, ja onda nikolu dodajem u bazu
        //ako u bazi nikola postoji, a u operativnoj ne postoji, ja onda njega brisem iz baze
        // sad ja uzmem autra i prolazim kroz operativnu 
        for (Author author : book.getAuthors()) {
            if (!authors.contains(author)) {
                ab.setAuthor(author);
                ab.setBook(book);
                DBRepository.getInstance().insert(ab);
            }
        }

        for (Author author : authors) {
            if (!book.getAuthors().contains(author)) {
                ab.setAuthor(author);
                ab.setBook(book);
                DBRepository.getInstance().delete(ab);
            }
        }
    }

}
