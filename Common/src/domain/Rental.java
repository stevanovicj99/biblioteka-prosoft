/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Jelena
 */
public class Rental extends AbstractDomainObject implements Serializable {

    private Long id;
    private Administrator administrator;
    private Member member;
    private int rentalStatus;
    private Date dateOfRental;
    private Date dateOfReturn;
    private ArrayList<RentalItem> rentalItems;

    public Rental() {
    }

    public Rental(Long id, Administrator administrator, Member member, int rentalStatus, Date dateOfRental, Date dateOfReturn, ArrayList<RentalItem> rentalItems) {
        this.id = id;
        this.administrator = administrator;
        this.member = member;
        this.rentalStatus = rentalStatus;
        this.dateOfRental = dateOfRental;
        this.dateOfReturn = dateOfReturn;
        this.rentalItems = rentalItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public int getRentalStatus() {
        return rentalStatus;
    }

    public void setRentalStatus(int rentalStatus) {
        this.rentalStatus = rentalStatus;
    }

    public Date getDateOfRental() {
        return dateOfRental;
    }

    public void setDateOfRental(Date dateOfRental) {
        this.dateOfRental = dateOfRental;
    }

    public Date getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(Date dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }

    public ArrayList<RentalItem> getRentalItems() {
        return rentalItems;
    }

    public void setRentalItems(ArrayList<RentalItem> rentalItems) {
        this.rentalItems = rentalItems;
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
        final Rental other = (Rental) obj;
        if (this.rentalStatus != other.rentalStatus) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.administrator, other.administrator)) {
            return false;
        }
        if (!Objects.equals(this.member, other.member)) {
            return false;
        }
        if (!Objects.equals(this.dateOfRental, other.dateOfRental)) {
            return false;
        }
        if (!Objects.equals(this.dateOfReturn, other.dateOfReturn)) {
            return false;
        }
        return Objects.equals(this.rentalItems, other.rentalItems);
    }

    @Override
    public String toString() {
        return id + " " + administrator + " " + member + " " + rentalStatus + " " + dateOfRental + " " + dateOfReturn + " " + rentalItems;
    }

    @Override
    public String getTableName() {
        return " rental ";
    }

    @Override
    public String getAlias() {
        return " ren ";
    }

    @Override
    public String join() {
        return "join administrator adm on (adm.id = ren.administratorID) "
                + "join member m on (m.id = ren.memberID) "
                + "join member_type mt on (mt.id = m.memberTypeID) "
                + "join rental_item ri on (ren.id=ri.rentalID) "
                + "join book b on (ri.bookID=b.id) "
                + "join administrator admb on (b.administratorID=admb.id) "
                + "join author_book ab on (b.id=ab.bookID) "
                + "join author aut on (ab.authorID=aut.id) ";
    }

    @Override
    public ArrayList<AbstractDomainObject> getList(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> list = new ArrayList<>();
        ArrayList<Author> authors = new ArrayList<>();
        ArrayList<RentalItem> rentalItems = new ArrayList<>();
        Long currentBookID = 0L;
        Long currentRentalID = 0L;
        Book b = new Book();
        RentalItem ri = new RentalItem();
        Rental rental = new Rental();
        while (rs.next()) {
            Administrator admin = new Administrator(rs.getLong("adm.id"), rs.getString("adm.firstname"), rs.getString("adm.lastname"), rs.getString("adm.username"), rs.getString("adm.password"));
            MemberType mt = new MemberType(rs.getLong("mt.id"), rs.getString("mt.name"));
            Member mem = new Member(rs.getLong("m.id"), rs.getString("m.firstname"), rs.getString("m.lastname"), rs.getDate("m.birthdate"), mt);
            Author a = new Author(rs.getLong("aut.id"), rs.getString("aut.firstname"), rs.getString("aut.lastname"));

            if (currentBookID == rs.getLong("b.id") && currentRentalID == rs.getLong("ren.id")) {
                authors.add(a);
            } else if (currentRentalID == rs.getLong("ren.id")) {
                if (currentBookID > 0L) {
                    b.setAuthors(authors);
                    ri.setBook(b);
                    rentalItems.add(ri);
                }
                currentBookID = rs.getLong("b.id");
                authors = new ArrayList<>();
                authors.add(a);
                Administrator adminB = new Administrator(rs.getLong("admb.id"), rs.getString("admb.firstname"), rs.getString("admb.lastname"), rs.getString("admb.username"), rs.getString("admb.password"));
                b = new Book(currentBookID, rs.getString("b.title"), rs.getInt("b.quantity"), rs.getInt("b.publication"), adminB, authors);
                ri = new RentalItem();
                ri.setOrderNumber(rs.getInt("ri.orderNumber"));
            } else {
                if (currentBookID > 0L) {
                    b.setAuthors(authors);
                    ri.setBook(b);
                    rentalItems.add(ri);
                }
                if (currentRentalID > 0L) {
                    rental.setRentalItems(rentalItems);
                    list.add(rental);
                }

                currentRentalID = rs.getLong("ren.id");

                currentBookID = rs.getLong("b.id");
                rentalItems = new ArrayList<>();
                authors = new ArrayList<>();
                authors.add(a);
                Administrator adminB = new Administrator(rs.getLong("admb.id"), rs.getString("admb.firstname"), rs.getString("admb.lastname"), rs.getString("admb.username"), rs.getString("admb.password"));
                b = new Book(currentBookID, rs.getString("b.title"), rs.getInt("b.quantity"), rs.getInt("b.publication"), adminB, authors);
                rental = new Rental(currentRentalID, admin, mem, rs.getInt("ren.rentalStatus"), rs.getTimestamp("ren.dateOfRental"), rs.getTimestamp("ren.dateOfReturn"), rentalItems);
                ri = new RentalItem();
                ri.setOrderNumber(rs.getInt("ri.orderNumber"));
            }
        }

        if (currentBookID > 0L) {
            b.setAuthors(authors);
            ri.setBook(b);
            rentalItems.add(ri);
        }
        if (currentRentalID > 0L) {
            rental.setRentalItems(rentalItems);
            list.add(rental);
        }

        rs.close();
        return list;
    }

    @Override
    public String columnsForInsert() {
        return " (id, administratorID, memberID, rentalStatus, dateOfRental, dateOfReturn) ";
    }

    @Override
    public String valuesForPrimaryKey() {
        return "id = " + id;
    }

    @Override
    public String valuesForInsert() {
        return id + ", " + administrator.getId() + ", " + member.getId() + ", " + rentalStatus + ", '" + new java.sql.Date(dateOfRental.getTime()) + "', " + null + " ";
    }

    @Override
    public String valuesForUpdate() {
        return "id = " + id + ", administratorID = " + administrator.getId() + ", memberID = " + member.getId() + ", rentalStatus = " + rentalStatus + ", dateOfRental = '" + new java.sql.Date(dateOfRental.getTime()) + "', dateOfReturn = '" + new java.sql.Date(dateOfReturn.getTime()) + "' ";
    }

    @Override
    public String query() {
        if (member != null) {
            return " WHERE m.id = " + member.getId() + " ORDER BY ren.id ";
        }
        return " ORDER BY ren.id, b.id ";
    }
}
