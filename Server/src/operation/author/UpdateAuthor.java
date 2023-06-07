/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.author;

import domain.AbstractDomainObject;
import domain.Author;
import java.util.ArrayList;
import operation.AbstractGenericOperation;
import repository.database.DBRepository;

/**
 *
 * @author Jelena
 */
public class UpdateAuthor extends AbstractGenericOperation {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Author)) {
            throw new Exception("The last object is not an instance of the author!");
        }
    }

    @Override
    protected void executeOperation(AbstractDomainObject ado) throws Exception {
        DBRepository.getInstance().update(ado);
    }

}
