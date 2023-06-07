/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componentTable;

import communication.Communication;
import domain.Member;
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
public class TableModelMember extends AbstractTableModel {//implements Runnable {

    private List<Member> members;
    private final String[] columnNames = new String[]{"ID", "Firstname", "Lastname", "Birthdate", "Member type"};
    private String parameter = "";
    SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy.");

    public TableModelMember() throws Exception {
        members = Communication.getInstance().getAllMembers();
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
        if (members == null) {
            return 0;
        }
        return members.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Member member = members.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return member.getId();
            case 1:
                return member.getFirstname();
            case 2:
                return member.getLastname();
            case 3:
                return format.format(member.getBirthdate());
            case 4:
                return member.getMemberType().getName();
            default:
                return "n/a";
        }
    }

    public Member getMemberAt(int row) {
        return members.get(row);
    }

    public void addMember(Member m) {
        members.add(m);
        fireTableRowsInserted(members.size() - 1, members.size() - 1);
    }

    public void deleteMember(int row) {
        members.remove(row);
        fireTableDataChanged();
    }

    public void setParameter(String parameter) throws Exception {
        this.parameter = parameter;
        search();
    }

    private void search() throws Exception {
        members = Communication.getInstance().getAllMembers();
        if (!parameter.equals("")) {
            ArrayList<Member> newList = new ArrayList<>();
            for (Member m : members) {
                if (m.toString().toLowerCase().contains(parameter.toLowerCase())) {
                    newList.add(m);
                }
            }
            members = newList;
        }
        fireTableDataChanged();
    }

    public void refreshTable() {
        try {
            members = Communication.getInstance().getAllMembers();
            fireTableDataChanged();
        } catch (Exception ex) {
            Logger.getLogger(TableModelMember.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
