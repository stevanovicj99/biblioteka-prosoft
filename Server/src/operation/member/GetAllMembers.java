/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.member;

import domain.AbstractDomainObject;
import domain.Author;
import domain.Member;
import java.util.ArrayList;
import operation.AbstractGenericOperation;
import repository.database.DBRepository;

/**
 *
 * @author Jelena
 */
public class GetAllMembers extends AbstractGenericOperation {

    private ArrayList<Member> list;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Member)) {
            throw new Exception("The last object is not an instance of the member!");
        }
    }

    @Override
    protected void executeOperation(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> members = DBRepository.getInstance().select(ado);
        list = (ArrayList<Member>) (ArrayList<?>) members;
    }
    
    public ArrayList<Member> getList() {
        return list;
    }

}
