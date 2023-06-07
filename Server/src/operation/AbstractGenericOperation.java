/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation;

import domain.AbstractDomainObject;
import repository.database.DBConnectionFactory;
import java.sql.SQLException;
/**
 *
 * @author Jelena
 */
public abstract class AbstractGenericOperation {

    protected abstract void validate(AbstractDomainObject ado) throws Exception;

    protected abstract void executeOperation(AbstractDomainObject ado) throws Exception;

    public void execute(AbstractDomainObject ado) throws Exception {
        try {
            validate(ado);
            startTransaction();
            executeOperation(ado);
            commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            rollbackTransaction();
            throw e;
        } finally {
            disconnect();
        }
    }

    public void commitTransaction() throws SQLException, Exception {
        DBConnectionFactory.getInstance().getConnection().commit();
    }

    public void rollbackTransaction() throws SQLException, Exception {
        DBConnectionFactory.getInstance().getConnection().rollback();
    }

    private void disconnect() throws Exception {
        DBConnectionFactory.getInstance().getConnection().close();
    }

    private void startTransaction() throws Exception {
        DBConnectionFactory.getInstance().getConnection();
    }
}
