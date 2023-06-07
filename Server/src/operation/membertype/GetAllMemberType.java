/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.membertype;

import domain.AbstractDomainObject;
import domain.Author;
import domain.Member;
import domain.MemberType;
import java.util.ArrayList;
import operation.AbstractGenericOperation;
import repository.database.DBRepository;

/**
 *
 * @author Jelena
 */
public class GetAllMemberType extends AbstractGenericOperation {

    private ArrayList<MemberType> list;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof MemberType)) {
            throw new Exception("The last object is not an instance of the member type!");
        }
    }

    @Override
    protected void executeOperation(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> memberTypes = DBRepository.getInstance().select(ado);
        list = (ArrayList<MemberType>) (ArrayList<?>) memberTypes;
    }

    public ArrayList<MemberType> getList() {
        return list;
    }
}
