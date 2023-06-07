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
public class MemberType extends AbstractDomainObject implements Serializable {

    private Long id;
    private String name;

    public MemberType() {
    }

    public MemberType(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        final MemberType other = (MemberType) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public String getTableName() {
        return " member_type ";
    }

    @Override
    public String getAlias() {
        return " mt ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> getList(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> list = new ArrayList<>();

        while (rs.next()) {
            MemberType tc = new MemberType(rs.getLong("id"), rs.getString("name"));
            list.add(tc);
        }
        rs.close();
        return list;
    }

    @Override
    public String columnsForInsert() {
        return " (name) ";
    }

    @Override
    public String valuesForPrimaryKey() {
        return " id = " + id;
    }

    @Override
    public String valuesForInsert() {
        return " '" + name + "' ";
    }

    @Override
    public String valuesForUpdate() {
        return " name = '" + name + "' ";
    }

    @Override
    public String query() {
        return "";
    }
}
