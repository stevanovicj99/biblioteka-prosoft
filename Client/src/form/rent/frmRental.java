/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package form.rent;

import com.sun.jdi.connect.spi.Connection;
import communication.Communication;
import componentTable.TableModelBook;
import componentTable.TableModelRentalItems;
import componentTable.TableModelRentals;
import domain.Administrator;
import domain.Book;
import domain.Member;
import domain.Rental;
import domain.RentalItem;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import mode.FormMode;

/**
 *
 * @author Jelena
 */
public class frmRental extends javax.swing.JDialog {

    /**
     * Creates new form frmRent
     */
    FormMode formMode;
    Member member;
    TableModelRentals tmr;
    Rental rental;
    Administrator administrator;
    SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy.");
    TableModelBook tmb;
    TableModelRentalItems tmri;

    public frmRental(java.awt.Frame parent, boolean modal, FormMode formMode, Member member, Administrator administrator, Rental rental, TableModelRentals tmr) {
        super(parent, modal);
        initComponents();
        this.formMode = formMode;
        this.member = member;
        this.administrator = administrator;
        this.tmr = tmr;
        this.rental = rental;
        setupComponents();
        prepareView();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMember = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtAdministrator = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBooks = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblRentedBooks = new javax.swing.JTable();
        btnMoveRight = new javax.swing.JButton();
        txtSearchBook = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnMoveLeft = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDateOfRental = new javax.swing.JTextField();
        txtDateOfReturn = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();
        btnReturn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Rental", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Member:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Administrator:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Status:");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Rental items"), "Rental items", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        tblBooks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblBooks);

        tblRentedBooks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblRentedBooks);

        btnMoveRight.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnMoveRight.setText(">");
        btnMoveRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoveRightActionPerformed(evt);
            }
        });

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search (1).png"))); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnMoveLeft.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnMoveLeft.setText("<");
        btnMoveLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoveLeftActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnMoveRight, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                            .addComponent(btnMoveLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtSearchBook, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSearchBook, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(btnMoveRight)
                        .addGap(18, 18, 18)
                        .addComponent(btnMoveLeft)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Date of rental:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Date of return:");

        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        lblStatus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnReturn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnReturn.setText("Return");
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtMember, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                                    .addComponent(txtAdministrator))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(3, 3, 3)
                                        .addComponent(txtDateOfReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDateOfRental, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(27, 27, 27))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMember, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtDateOfRental, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtAdministrator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtDateOfReturn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnReturn))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMoveRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoveRightActionPerformed
        int row = tblBooks.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "No row selected!");
            return;
        }
        if (row >= 0) {
            try {
                tmb = (TableModelBook) tblBooks.getModel();

                RentalItem ri = new RentalItem();

                for (RentalItem rentalItem : tmri.getList()) {
                    if (rentalItem.getBook().equals(tmb.getBookAt(row))) {
                        JOptionPane.showMessageDialog(this, "You have already chosen that book!");
                        return;
                    }
                }
                if (tmri.getList().size() >= 5) {
                    JOptionPane.showMessageDialog(this, "You cannot rent more than 5 books!");
                    return;
                } else {
                    if (tmb.getBookAt(row).getQuantity() == 0) {
                        JOptionPane.showMessageDialog(this, "That book is no longer available!");
                        return;
                    } else {
                        Book book = tmb.rentBook(row);
                        ri.setBook(book);
                        ri.setRental(null);
                        tmri.addRentalItem(ri);
                    }
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error!");
            }
        }
    }//GEN-LAST:event_btnMoveRightActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try {
            String param = txtSearchBook.getText().trim();
            ((TableModelBook) tblBooks.getModel()).setParameter(param);
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnMoveLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoveLeftActionPerformed
        int row = tblRentedBooks.getSelectedRow();

        if (row < 0) {
            JOptionPane.showMessageDialog(this, "No row selected!");
            return;
        }
        if (row >= 0) {
            tmri = (TableModelRentalItems) tblRentedBooks.getModel();
            Book book = tmri.returnRentalItem(row);
            tmb = (TableModelBook) tblBooks.getModel();
            tmb.returnBook(book);
        }
    }//GEN-LAST:event_btnMoveLeftActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            tmri = (TableModelRentalItems) tblRentedBooks.getModel();

            Rental newRental = new Rental();
            newRental.setAdministrator(administrator);
            newRental.setMember(member);
            newRental.setRentalStatus(0);
            newRental.setDateOfRental(new Date());
            newRental.setRentalItems(tmri.getList());

//            tmb = (TableModelBook) tblBooks.getModel();
//            tmb.rentAllBooks(tmri.getAllBooks());

            Communication.getInstance().addRental(newRental);
            JOptionPane.showMessageDialog(this, "Successfully saved rental");
            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Unable to save rental!");
        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        try {
            Rental editedRental = new Rental();
            editedRental.setAdministrator(rental.getAdministrator());
            editedRental.setDateOfRental(rental.getDateOfRental());
            editedRental.setMember(rental.getMember());
            editedRental.setRentalItems(rental.getRentalItems());
            editedRental.setRentalStatus(1);
            editedRental.setDateOfReturn(new Date());
            editedRental.setId(rental.getId());

//            tmri = (TableModelRentalItems) tblRentedBooks.getModel();
//            tmb = (TableModelBook) tblBooks.getModel();
//            tmb.returnAllBooks(tmri.getAllBooks());

            Communication.getInstance().editRental(editedRental);
            tmr.refreshTable();
            JOptionPane.showMessageDialog(this, "Rental saved successfully!");
            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Unable to save rental!");
        }
    }//GEN-LAST:event_btnReturnActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
    }//GEN-LAST:event_formWindowClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMoveLeft;
    private javax.swing.JButton btnMoveRight;
    private javax.swing.JButton btnReturn;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JTable tblBooks;
    private javax.swing.JTable tblRentedBooks;
    private javax.swing.JTextField txtAdministrator;
    private javax.swing.JTextField txtDateOfRental;
    private javax.swing.JTextField txtDateOfReturn;
    private javax.swing.JTextField txtMember;
    private javax.swing.JTextField txtSearchBook;
    // End of variables declaration//GEN-END:variables

    private void prepareView() {
        try {
            tmb = new TableModelBook();
            tblBooks.setModel(tmb);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Unable to show books!");
        }

    }

    private void setupComponents() {
        try {
            Date date = new Date();
            switch (formMode) {
                case FORM_ADD:
                    rental = new Rental();
                    rental.setAdministrator(administrator);
                    rental.setMember(member);
                    rental.setDateOfRental(date);
                    rental.setDateOfReturn(null);
                    rental.setRentalStatus(0);

                    tmri = new TableModelRentalItems();
                    tblRentedBooks.setModel(tmri);
                    txtMember.setText(member.toString());
                    txtMember.setEditable(false);
                    txtAdministrator.setText(administrator.toString());
                    txtAdministrator.setEditable(false);
                    txtDateOfRental.setText(format.format(new Date()));
                    txtDateOfRental.setEditable(false);
                    txtDateOfReturn.setText(null);
                    txtDateOfReturn.setEditable(false);
                    lblStatus.setText("Active");
                    btnReturn.setEnabled(false);
                    break;
                case FORM_VIEW:
                    txtMember.setText(rental.getMember().toString());
                    txtMember.setEditable(false);
                    txtAdministrator.setText(rental.getAdministrator().toString());
                    txtAdministrator.setEditable(false);
                    txtDateOfRental.setText(format.format(rental.getDateOfRental()));
                    txtDateOfRental.setEditable(false);
                    txtDateOfReturn.setEditable(false);
                    tmri = new TableModelRentalItems(rental);
                    tmri.sort(tmri.getList());
                    tblRentedBooks.setModel(tmri);
                    txtSearchBook.setEditable(false);
                    btnSearch.setEnabled(false);
                    if (rental.getRentalStatus() == 0) {
                        lblStatus.setText("Active");
                        txtDateOfReturn.setText(null);
                        btnReturn.setEnabled(true);
                        btnMoveLeft.setEnabled(false);
                        btnMoveRight.setEnabled(false);
                        btnSave.setEnabled(false);
                    } else if (rental.getRentalStatus() == 1) {
                        lblStatus.setText("Passive");
                        txtDateOfReturn.setText(format.format(rental.getDateOfReturn()));
                        btnMoveLeft.setEnabled(false);
                        btnMoveRight.setEnabled(false);
                        btnSave.setEnabled(false);
                        btnReturn.setEnabled(false);
                    }
                    break;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error!");
        }
    }

    private void resetForm() {
        try {
            tmb.refreshTable();
            tblRentedBooks.setModel(new TableModelRentalItems());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Unable to show books!");
        }
    }

}
