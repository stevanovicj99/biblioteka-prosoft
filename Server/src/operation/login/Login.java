/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.login;

import domain.AbstractDomainObject;
import domain.Administrator;
import java.util.ArrayList;
import operation.AbstractGenericOperation;
import repository.database.DBConnectionFactory;
import repository.database.DBRepository;

/**
 *
 * @author Jelena
 */
public class Login extends AbstractGenericOperation {

    Administrator admin;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Administrator)) {
            throw new Exception("The last object is not an instance of the Administrator class!");
        }
    }

    @Override
    protected void executeOperation(AbstractDomainObject ado) throws Exception {
        Administrator a = (Administrator) ado;

        ArrayList<Administrator> administrators
                = (ArrayList<Administrator>) (ArrayList<?>) DBRepository.getInstance().select(ado);

        for (Administrator admin : administrators) {
            if (admin.getUsername().equals(a.getUsername())
                    && admin.getPassword().equals(a.getPassword())) {
                this.admin = admin;
                return;
            }
        }

        throw new Exception("There is no administrator with those credentials.");
    }

    public Administrator getAdministrator() {
        return admin;
    }
}
