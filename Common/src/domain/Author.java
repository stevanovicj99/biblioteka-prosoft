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
public class Author extends AbstractDomainObject implements Serializable{
    
    private Long id;
    private String firstname;
    private String lastname;

    public Author() {
    }

    public Author(Long id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
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

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Author other = (Author) obj;
        if (!Objects.equals(this.firstname, other.firstname)) {
            return false;
        }
        if (!Objects.equals(this.lastname, other.lastname)) {
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
        return " author ";
    }

    @Override
    public String getAlias() {
        return " aut ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> getList(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Author a = new Author(rs.getLong("id"), rs.getString("firstname"), rs.getString("lastname"));
            lista.add(a);
        }
        rs.close();
        return lista;
    }

    @Override
    public String columnsForInsert() {
        return "(firstname, lastname)";
    }

    @Override
    public String valuesForPrimaryKey() {
        return "id = " + id;
    }

    @Override
    public String valuesForInsert() {
        return "'" + firstname + "', '" + lastname + "'";
    }

    @Override
    public String valuesForUpdate() {
        return "firstname = '" + firstname + "', lastname = '" + lastname + "' ";
    }

    @Override
    public String query() {
        return "";
    }
    
}
