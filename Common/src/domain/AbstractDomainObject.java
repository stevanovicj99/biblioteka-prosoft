/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Jelena
 */
public abstract class AbstractDomainObject implements Serializable {

    public abstract String getTableName();

    public abstract String getAlias();

    public abstract String join();

    public abstract ArrayList<AbstractDomainObject> getList(ResultSet rs) throws SQLException;

    public abstract String columnsForInsert();

    public abstract String valuesForPrimaryKey();

    public abstract String valuesForInsert();

    public abstract String valuesForUpdate();

    public abstract String query();
}
