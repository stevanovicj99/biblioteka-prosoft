/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.Administrator;
import domain.Author;
import domain.AuthorBook;
import domain.Book;
import domain.Member;
import domain.MemberType;
import domain.Rental;
import domain.RentalItem;
import java.util.ArrayList;
import operation.author.AddAuthor;
import operation.author.DeleteAuthor;
import operation.author.UpdateAuthor;
import operation.book.AddBook;
import operation.book.DeleteBook;
import operation.book.UpdateBook;
import operation.login.Login;
import operation.member.AddMember;
import operation.member.DeleteMember;
import operation.member.UpdateMember;
import operation.membertype.GetAllMemberType;
import operation.author.GetAllAuthors;
import operation.book.GetAllBooks;
import operation.member.GetAllMembers;
import operation.administrator.GetAllAdministrators;
import operation.authorbook.GetAllAuthorBook;
import operation.rental.AddRental;
import operation.rental.GetAllRentals;
import operation.rental.UpdateRental;
import operation.rentalItem.AddRentalItem;
import operation.rentalItem.GetAllRentalItems;

/**
 *
 * @author Jelena
 */
public class Controller {

    private static Controller instance;

    private Controller() {
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public Administrator login(Administrator administrator) throws Exception {
        Login log = new Login();
        log.execute(administrator);
        return log.getAdministrator();
    }

    public Author addAuthor(Author author) throws Exception {
        //(new AddAuthor()).execute(author);
        AddAuthor aa = new AddAuthor();
        aa.execute(author);
        return aa.getAuthor();
    }

    public Book addBook(Book book) throws Exception {
        //(new AddBook()).execute(book);

        AddBook ab = new AddBook();

        ab.execute(book);

        return ab.getBook();
    }

    public Member addMember(Member member) throws Exception {
        //(new AddMember()).execute(member);

        AddMember am = new AddMember();

        am.execute(member);
        return am.getMember();
    }

    public Rental addRental(Rental rental) throws Exception {
        //(new AddRental()).execute(rental);

        AddRental ar = new AddRental();

        ar.execute(rental);

        return ar.getRental();
    }

    public void addRentalItem(RentalItem rentalItem) throws Exception {
        AddRentalItem ari = new AddRentalItem();
        ari.execute(rentalItem);
//        return ari.getRentalItem();
    }

    public void deleteAuthor(Author author) throws Exception {
        (new DeleteAuthor()).execute(author);
    }

    public void deleteBook(Book book) throws Exception {
        (new DeleteBook()).execute(book);
    }

    public void deleteMember(Member member) throws Exception {
        (new DeleteMember()).execute(member);
    }

    public void updateAuthor(Author author) throws Exception {
        (new UpdateAuthor()).execute(author);
    }

    public void updateBook(Book book) throws Exception {
        (new UpdateBook()).execute(book);
    }

    public void updateMember(Member member) throws Exception {
        (new UpdateMember()).execute(member);
    }

    public void updateRental(Rental rental) throws Exception {
        (new UpdateRental()).execute(rental);
    }

    public ArrayList<Administrator> getAllAdministrators() throws Exception {
        GetAllAdministrators gaa = new GetAllAdministrators();
        gaa.execute(new Administrator());
        return gaa.getList();
    }

    public ArrayList<MemberType> getAllMemberType() throws Exception {
        GetAllMemberType mt = new GetAllMemberType();
        mt.execute(new MemberType());
        return mt.getList();
    }

    public ArrayList<Author> getAllAuthors() throws Exception {
        GetAllAuthors gaa = new GetAllAuthors();
        gaa.execute(new Author());
        return gaa.getList();
    }

    public ArrayList<AuthorBook> getAllAuthorsByBook(Book book) throws Exception {
        GetAllAuthorBook gaab = new GetAllAuthorBook();
        
        AuthorBook ab = new AuthorBook();
        ab.setBook(book);
        
        gaab.execute(ab);
        return gaab.getList();
    }

    public ArrayList<Book> getAllBooks(Author author) throws Exception {
        GetAllBooks gab = new GetAllBooks();

        Book book = new Book();
        ///book.setAuthor(author);

        gab.execute(book);
        return gab.getList();
    }

    public ArrayList<Member> getAllMembers(MemberType memberType) throws Exception {
        GetAllMembers gam = new GetAllMembers();

        Member member = new Member();
        member.setMemberType(memberType);

        gam.execute(member);
        return gam.getList();
    }

    public ArrayList<Rental> getAllRentals() throws Exception {
        GetAllRentals gar = new GetAllRentals();

        gar.execute(new Rental());
        return gar.getList();
    }

    public ArrayList<Rental> getAllRentalsByMember(Member member) throws Exception {
        GetAllRentals gar = new GetAllRentals();

        Rental rental = new Rental();
        rental.setMember(member);
        gar.execute(rental);
        return gar.getList();
    }

    public ArrayList<RentalItem> getAllRentalItems(Rental rental) throws Exception {
        GetAllRentalItems gari = new GetAllRentalItems();

        RentalItem ri = new RentalItem();
        ri.setRental(rental);

        gari.execute(ri);
        return gari.getList();
    }

}
