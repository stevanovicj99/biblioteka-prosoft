/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.rentalItem;

import com.mysql.cj.jdbc.PreparedStatementWrapper;
import domain.AbstractDomainObject;
import domain.RentalItem;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import operation.AbstractGenericOperation;
import repository.database.DBRepository;
import java.sql.PreparedStatement;

/**
 *
 * @author Jelena
 */
public class AddRentalItem extends AbstractGenericOperation {

    RentalItem rentalItem;
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof RentalItem)) {
            throw new Exception("The last object is not an instance of the rental item!");
        }
    }

    @Override
    protected void executeOperation(AbstractDomainObject ado) throws Exception {
        DBRepository.getInstance().insert(ado);
//        PreparedStatement ps = DBRepository.getInstance().insert(ado);
//        ResultSet tableKeys = ps.getGeneratedKeys();
//        tableKeys.next();
//        
//        Long rentalItemID = tableKeys.getLong(1);
//        rentalItem = (RentalItem) ado;
//        
//        rentalItem.setId(rentalItemID);

    }

    public RentalItem getRentalItem() {
        return rentalItem;
    }
    
    

}
