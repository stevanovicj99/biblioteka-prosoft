/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.rental;

import controller.Controller;
import domain.AbstractDomainObject;
import domain.Book;
import domain.Rental;
import domain.RentalItem;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import operation.AbstractGenericOperation;
import repository.database.DBRepository;

/**
 *
 * @author Jelena
 */
public class UpdateRental extends AbstractGenericOperation {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Rental)) {
            throw new Exception("The last object is not an instance of the rental!");
        }
    }

    @Override
    protected void executeOperation(AbstractDomainObject ado) throws Exception {
        DBRepository.getInstance().update(ado);
        Rental rental = (Rental) ado;
        ArrayList<RentalItem> rentalItems = rental.getRentalItems();
        ArrayList<Book> books = new ArrayList<>();
        for (RentalItem ri : rentalItems) {
            books.add(ri.getBook());
        }

        for (Book book : books) {
            int quantity = book.getQuantity();
            book.setQuantity(++quantity);
            Controller.getInstance().updateBook(book);
        }
    }

}
