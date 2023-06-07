/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.authorbook;

import domain.AbstractDomainObject;
import domain.AuthorBook;
import java.util.ArrayList;
import operation.AbstractGenericOperation;
import repository.database.DBRepository;

/**
 *
 * @author Jelena
 */
public class GetAllAuthorBook extends AbstractGenericOperation {

    private ArrayList<AuthorBook> list;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof AuthorBook)) {
            throw new Exception("The last object is not an instance of the author_book!");
        }
    }

    @Override
    protected void executeOperation(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> ab = DBRepository.getInstance().select(ado);
        list = (ArrayList<AuthorBook>) (ArrayList<?>) ab;
    }

    public ArrayList<AuthorBook> getList() {
        return list;
    }
}
