/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.rentalItem;

import domain.AbstractDomainObject;
import domain.RentalItem;
import java.util.ArrayList;
import operation.AbstractGenericOperation;
import repository.database.DBRepository;

/**
 *
 * @author Jelena
 */
public class GetAllRentalItems extends AbstractGenericOperation {

    private ArrayList<RentalItem> list;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof RentalItem)) {
            throw new Exception("The last object is not an instance of the rental item!");
        }
    }

    @Override
    protected void executeOperation(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> rentalItems = DBRepository.getInstance().select(ado);
        list = (ArrayList<RentalItem>) (ArrayList<?>) rentalItems;

    }

    public ArrayList<RentalItem> getList() {
        return list;
    }
    
    
}
