/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.book;

import domain.AbstractDomainObject;
import domain.Book;
import java.util.ArrayList;
import operation.AbstractGenericOperation;
import repository.database.DBRepository;

/**
 *
 * @author Jelena
 */
public class GetAllBooks extends AbstractGenericOperation {

    private ArrayList<Book> list;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Book)) {
            throw new Exception("The last object is not an instance of the book!");
        }
    }

    @Override
    protected void executeOperation(AbstractDomainObject ado) throws Exception {
        ArrayList<Book> books = (ArrayList<Book>) (ArrayList<?>) DBRepository.getInstance().select(ado);
        list = (ArrayList<Book>) (ArrayList<?>) books;

    }

    public ArrayList<Book> getList() {
        return list;
    }
}
