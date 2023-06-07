/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.database;

import domain.AbstractDomainObject;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author Jelena
 */
public class DBRepository {

    private static DBRepository instance;

    private DBRepository() {
    }

    public static DBRepository getInstance() {
        if (instance == null) {
            instance = new DBRepository();
        }
        return instance;
    }

    public ArrayList<AbstractDomainObject> select(AbstractDomainObject ado) throws SQLException, Exception {
        String query = "SELECT * FROM " + ado.getTableName() + " " + ado.getAlias()
                + " " + ado.join() + " " + ado.query();
        System.out.println(query);
        Statement s = DBConnectionFactory.getInstance().getConnection().createStatement();
        ResultSet rs = s.executeQuery(query);
        return ado.getList(rs);
    }
    
    public PreparedStatement insert(AbstractDomainObject ado) throws SQLException, Exception {
        String query = "INSERT INTO " + ado.getTableName() + " "
                + ado.columnsForInsert() + " VALUES(" + ado.valuesForInsert() + ")";
        System.out.println(query);
        PreparedStatement ps = DBConnectionFactory.getInstance().getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ps.executeUpdate();
        return ps;
    }

    public void update(AbstractDomainObject ado) throws SQLException, Exception {
        String query = "UPDATE " + ado.getTableName() + " SET "
                + ado.valuesForUpdate() + " WHERE " + ado.valuesForPrimaryKey();
        System.out.println(query);
        Statement s = DBConnectionFactory.getInstance().getConnection().createStatement();
        s.executeUpdate(query);
    }

    public void delete(AbstractDomainObject ado) throws SQLException, Exception {
        String query = "DELETE FROM " + ado.getTableName() + " WHERE " + ado.valuesForPrimaryKey();
        System.out.println(query);
        Statement s = DBConnectionFactory.getInstance().getConnection().createStatement();
        s.executeUpdate(query);
    }
}
