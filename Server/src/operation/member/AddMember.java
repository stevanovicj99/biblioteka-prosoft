/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.member;

import domain.AbstractDomainObject;
import domain.Author;
import domain.Member;
import domain.Rental;
import operation.AbstractGenericOperation;
import repository.database.DBRepository;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Jelena
 */
public class AddMember extends AbstractGenericOperation {
    
    Member member;
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Member)) {
            throw new Exception("The last object is not an instance of the member!");
        }
    }

    @Override
    protected void executeOperation(AbstractDomainObject ado) throws Exception {
        //DBRepository.getInstance().insert(ado);
        PreparedStatement ps = DBRepository.getInstance().insert(ado);
        ResultSet tableKeys = ps.getGeneratedKeys();
        tableKeys.next();

        Long memberID = tableKeys.getLong(1);
        member = (Member) ado;
        member.setId(memberID);
    }

    public Member getMember() {
        return member;
    }
    
    

}
