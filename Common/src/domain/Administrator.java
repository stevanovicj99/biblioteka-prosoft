/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Jelena
 */
public class Administrator extends AbstractDomainObject implements Serializable {

    private Long id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;

    public Administrator() {
    }

    public Administrator(Long id, String firstname, String lastname, String username, String password) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Administrator other = (Administrator) obj;
        if (!Objects.equals(this.firstname, other.firstname)) {
            return false;
        }
        if (!Objects.equals(this.lastname, other.lastname)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return firstname + " " + lastname;
    }

        
    @Override
    public String getTableName() {
        return " administrator ";
    }

    @Override
    public String getAlias() {
        return " adm ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> getList(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> list = new ArrayList<>();

        while (rs.next()) {
            Administrator a = new Administrator(rs.getLong("id"), rs.getString("firstname"), rs.getString("lastname"), rs.getString("username"), rs.getString("password"));
            list.add(a);
        }
        rs.close();
        return list;
    }

    @Override
    public String columnsForInsert() {
        return "";
    }

    @Override
    public String valuesForPrimaryKey() {
        return "id = " + id;
    }

    @Override
    public String valuesForInsert() {
        return "";
    }

    @Override
    public String valuesForUpdate() {
        return "";
    }

    @Override
    public String query() {
        return "";
    }

}
