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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import operation.AbstractGenericOperation;
import repository.database.DBRepository;

/**
 *
 * @author Jelena
 */
public class AddRental extends AbstractGenericOperation {

    Rental rental;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Rental)) {
            throw new Exception("The last object is not an instance of the rental!");
        }

        Rental r = (Rental) ado;
        
        if (r.getRentalItems().isEmpty()) {
            throw new Exception("Rental must have at least one book!");
        }
    }

    @Override
    protected void executeOperation(AbstractDomainObject ado) throws Exception {
        PreparedStatement ps = DBRepository.getInstance().insert(ado);
        ResultSet tableKeys = ps.getGeneratedKeys();
        tableKeys.next();

        Long rentalID = tableKeys.getLong(1);

        rental = (Rental) ado;
        rental.setId(rentalID);

        for (RentalItem rentalItem : rental.getRentalItems()) {
            rentalItem.setRental(rental);
            DBRepository.getInstance().insert(rentalItem);
        }
        
        ArrayList<Book> books = new ArrayList<>();
        for (RentalItem ri : rental.getRentalItems()) {
            books.add(ri.getBook());
        }

        for (Book book : books) {
            Controller.getInstance().updateBook(book);
        }
        
    }

    public Rental getRental() {
        return rental;
    }
    
    

}
