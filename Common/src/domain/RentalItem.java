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
public class RentalItem extends AbstractDomainObject implements Serializable {
    
    private Rental rental;
    private int orderNumber;
    private Book book;
    
    public RentalItem() {
    }
    
    public RentalItem(Rental rental, int orderNumber, Book book) {
        this.rental = rental;
        this.orderNumber = orderNumber;
        this.book = book;
    }
    
    public int getOrderNumber() {
        return orderNumber;
    }
    
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }
    
    public Rental getRental() {
        return rental;
    }
    
    public void setRental(Rental rental) {
        this.rental = rental;
    }
    
    public Book getBook() {
        return book;
    }
    
    public void setBook(Book book) {
        this.book = book;
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
        final RentalItem other = (RentalItem) obj;
        if (this.orderNumber != other.orderNumber) {
            return false;
        }
        if (!Objects.equals(this.rental, other.rental)) {
            return false;
        }
        return Objects.equals(this.book, other.book);
    }
    
    @Override
    public String toString() {
        return "RentalItem{" + "rental=" + rental + ", orderNumber=" + orderNumber + ", book=" + book + '}';
    }
    
    @Override
    public String getTableName() {
        return " rental_item ";
    }
    
    @Override
    public String getAlias() {
        return " ri ";
    }
    
    @Override
    public String join() {
        return "JOIN book b ON (ri.bookID = b.id) "
                + "JOIN rental ren ON (ri.rentalID = ren.id) "
                + "JOIN administrator adm ON (adm.id = ren.administratorID) "
                + "JOIN member m ON (ren.memberID = m.id)"
                + "JOIN member_type mt ON (mt.id = m.memberTypeID)";
    }
    
    @Override
    public ArrayList<AbstractDomainObject> getList(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> list = new ArrayList<>();
        
        while (rs.next()) {
            Administrator admin = new Administrator(rs.getLong("administratorID"), rs.getString("firstname"), rs.getString("lastname"), rs.getString("username"), rs.getString("password"));
            MemberType mt = new MemberType(rs.getLong("memberTypeID"), rs.getString("name"));
            Member mem = new Member(rs.getLong("id"), rs.getString("firstname"), rs.getString("lastname"), rs.getTimestamp("birthdate"), mt);
            Rental r = new Rental(rs.getLong("id"), admin, mem, rs.getInt("rentalStatus"), rs.getTimestamp("dateOfRental"), rs.getTimestamp("dateOfReturn"), null);
            Administrator adminB = new Administrator(rs.getLong("admb.id"), rs.getString("admb.firstname"), rs.getString("admb.lastname"), rs.getString("admb.username"), rs.getString("admb.password"));
            Book b = new Book(rs.getLong("b.id"), rs.getString("b.title"), rs.getInt("b.quantity"), rs.getInt("b.publication"), adminB, null);
            RentalItem ri = new RentalItem(r, rs.getInt("orderNumber"), b);
            list.add(ri);
        }
        rs.close();
        return list;
    }
    
    @Override
    public String columnsForInsert() {
        return "(rentalID, orderNumber , bookID)";
    }
    
    @Override
    public String valuesForPrimaryKey() {
        return " rentalID = " + rental.getId();
    }
    
    @Override
    public String valuesForInsert() {
        return rental.getId() + ", " + orderNumber + ", " + book.getId();
    }
    
    @Override
    public String valuesForUpdate() {
        return "";
    }
    
    @Override
    public String query() {
        return "where ren.id = " + rental.getId();
    }
    
}
