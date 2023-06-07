/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jelena
 */
public class Member extends AbstractDomainObject implements Serializable {

    private Long id;
    private String firstname;
    private String lastname;
    private Date birthdate;
    private MemberType memberType;

    public Member() {
    }

    public Member(Long id, String firstname, String lastname, Date birthdate, MemberType memberType) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.memberType = memberType;
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

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public MemberType getMemberType() {
        return memberType;
    }

    public void setMemberType(MemberType memberType) {
        this.memberType = memberType;
    }

    @Override
    public String toString() {
        return  firstname + " " + lastname;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Member other = (Member) obj;
        if (!Objects.equals(this.firstname, other.firstname)) {
            return false;
        }
        if (!Objects.equals(this.lastname, other.lastname)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.birthdate, other.birthdate)) {
            return false;
        }
        return Objects.equals(this.memberType, other.memberType);
    }

    @Override
    public String getTableName() {
        return " member ";
    }

    @Override
    public String getAlias() {
        return " m ";
    }

    @Override
    public String join() {
        return " join member_type mt on (mt.id = m.memberTypeID)";
    }

    @Override
    public ArrayList<AbstractDomainObject> getList(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> list = new ArrayList<>();

        while (rs.next()) {
            MemberType mt = new MemberType(rs.getLong("memberTypeID"), rs.getString("name"));

            Member m = new Member(rs.getLong("id"), rs.getString("firstname"), rs.getString("lastname"), rs.getDate("birthdate"), mt);
            list.add(m);
        }
        rs.close();
        return list;
    }

    @Override
    public String columnsForInsert() {
        return " (id, firstname, lastname, birthdate, memberTypeID) ";
    }

    @Override
    public String valuesForPrimaryKey() {
        return " id = " + id;
    }

    @Override
    public String valuesForInsert() {
        return id + ", '" + firstname + "', '" + lastname + "', '" + new java.sql.Date(birthdate.getTime()) + "', " + memberType.getId() + " ";
    }

    @Override
    public String valuesForUpdate() {
        return "firstname = '" + firstname + "', lastname = '" + lastname + "', birthdate = '" + new java.sql.Date(birthdate.getTime()) + "', memberTypeID = "  + memberType.getId() + " ";
    }

    @Override
    public String query() {
        if (memberType == null) {
            return "";
        }
        return " where mt.id = " + memberType.getId();
    }

}
