/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.member;

import domain.AbstractDomainObject;
import domain.Member;
import operation.AbstractGenericOperation;
import repository.database.DBRepository;

/**
 *
 * @author Jelena
 */
public class DeleteMember extends AbstractGenericOperation {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Member)) {
            throw new Exception("The last object is not an instance of the member!");
        }
    }

    @Override
    protected void executeOperation(AbstractDomainObject ado) throws Exception {
        DBRepository.getInstance().delete(ado);
    }

}
