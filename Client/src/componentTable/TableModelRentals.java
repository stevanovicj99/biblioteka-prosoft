/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componentTable;

import communication.Communication;
import domain.Rental;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jelena
 */
public class TableModelRentals extends AbstractTableModel {

    private List<Rental> rentals;
    private final String[] columnNames = new String[]{"ID", "Administrator", "Member", "Rental status", "Date of rental", "Date of return"};
    private String parameter = "";
    SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

    public TableModelRentals() throws Exception {
        rentals = Communication.getInstance().getAllRentals();
    }

    public TableModelRentals(int rentalStatus) throws Exception {
        ArrayList<Rental> activeRentals = getActive();
        ArrayList<Rental> passiveRentals = getPassive();

        if (rentalStatus == 0) {
            rentals = activeRentals;
        } else if (rentalStatus == 1) {
            rentals = passiveRentals;
        }
    }

    @Override
    public String getColumnName(int column) {
        if (column > columnNames.length) {
            return "n/a";
        }
        return columnNames[column];
    }

    @Override
    public int getRowCount() {
        if (rentals == null) {
            return 0;
        }
        return rentals.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Rental rental = rentals.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return rental.getId();
            case 1:
                return rental.getAdministrator().toString();
            case 2:
                return rental.getMember().toString();
            case 3:
                if (rental.getRentalStatus() == 0) {
                    return "Active";
                } else if (rental.getRentalStatus() == 1) {
                    return "Passive";
                }
            case 4:
                return format.format(rental.getDateOfRental());
            case 5:
                if (rental.getDateOfReturn() == null) {
                    return "";
                } else {
                    return format.format(rental.getDateOfReturn());
                }
            default:
                return "n/a";
        }
    }

    public Rental getRentalAt(int row) {
        return rentals.get(row);
    }

    public void addRental(Rental r) {
        rentals.add(r);
        fireTableRowsInserted(rentals.size() - 1, rentals.size() - 1);
    }

    public void deleteMember(int row) {
        rentals.remove(row);
        fireTableDataChanged();
    }

    public void setParameter(String parameter) throws Exception {
        this.parameter = parameter;
        search();
    }

    private void search() throws Exception {
        rentals = Communication.getInstance().getAllRentals();
        if (!parameter.equals("")) {
            ArrayList<Rental> newList = new ArrayList<>();
            for (Rental r : rentals) {
                if (r.toString().toLowerCase().contains(parameter.toLowerCase())) {
                    newList.add(r);
                }
            }
            rentals = newList;
        }
        fireTableDataChanged();
    }

    public void refreshTable() throws Exception {
        rentals = Communication.getInstance().getAllRentals();
        fireTableDataChanged();
    }

    public ArrayList<Rental> getActive() throws Exception {
        ArrayList<Rental> activeRentals = new ArrayList<>();
        rentals = Communication.getInstance().getAllRentals();
        for (Rental rental : rentals) {
            if (rental.getRentalStatus() == 0) {
                activeRentals.add(rental);
            }
        }
        return activeRentals;
    }

    public ArrayList<Rental> getPassive() throws Exception {
        ArrayList<Rental> passiveRentals = new ArrayList<>();
        rentals = Communication.getInstance().getAllRentals();
        for (Rental rental : rentals) {
            if (rental.getRentalStatus() == 1) {
                passiveRentals.add(rental);
            }
        }
        return passiveRentals;
    }
}
