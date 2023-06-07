/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.book;

import domain.AbstractDomainObject;
import domain.Book;
import operation.AbstractGenericOperation;
import repository.database.DBRepository;

/**
 *
 * @author Jelena
 */
public class DeleteBook extends AbstractGenericOperation {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Book)) {
            throw new Exception("The last object is not an instance of the book!");
        }
    }

    @Override
    protected void executeOperation(AbstractDomainObject ado) throws Exception {
        DBRepository.getInstance().delete(ado);
    }

}
