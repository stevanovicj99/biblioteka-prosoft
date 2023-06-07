/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.author;

import com.mysql.cj.jdbc.PreparedStatementWrapper;
import domain.AbstractDomainObject;
import domain.Author;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import operation.AbstractGenericOperation;
import repository.database.DBRepository;

/**
 *
 * @author Jelena
 */
public class AddAuthor extends AbstractGenericOperation {
    
    Author author;
    
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Author)) {
            throw new Exception("The last object is not an instance of the Author!");
        }
    }

    @Override
    protected void executeOperation(AbstractDomainObject ado) throws Exception {
//        DBRepository.getInstance().insert(ado);
        PreparedStatement ps = DBRepository.getInstance().insert(ado);
        ResultSet tableKeys = ps.getGeneratedKeys();
        tableKeys.next();
        
        Long authorID = tableKeys.getLong(1);
        author = (Author) ado;
        author.setId(authorID);
    }

    public Author getAuthor() {
        return author;
    }
    
    

}
