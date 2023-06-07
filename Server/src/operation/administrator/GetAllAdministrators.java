/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.administrator;

import domain.AbstractDomainObject;
import domain.Administrator;
import java.util.ArrayList;
import operation.AbstractGenericOperation;
import repository.database.DBRepository;

/**
 *
 * @author Jelena
 */
public class GetAllAdministrators extends AbstractGenericOperation {

    private ArrayList<Administrator> list;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Administrator)) {
            throw new Exception("The last object is not an instance of the Administrator!");
        }
    }

    @Override
    protected void executeOperation(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> administrators = DBRepository.getInstance().select(ado);
        list = (ArrayList<Administrator>) (ArrayList<?>) administrators;
    }

    public ArrayList<Administrator> getList() {
        return list;
    }
}
