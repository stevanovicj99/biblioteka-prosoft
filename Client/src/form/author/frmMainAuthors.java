/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package form.author;

import domain.Author;
import communication.Communication;
import communication.Response;
import communication.ResponseStatus;
/**
 *
 * @author Jelena
 */
import componentTable.TableModelAuthor;
import domain.Administrator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import mode.FormMode;

public class frmMainAuthors extends javax.swing.JDialog {

    /**
     * Creates new form frmAutoriPrikaz
     */
    TableModelAuthor tma;
    Administrator administrator;

    public frmMainAuthors(java.awt.Frame parent, boolean modal, Administrator administrator) {
        super(parent, modal);
        initComponents();
        this.administrator=administrator;
        prepareView();
        setTitle("Authors");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtSearchAuthors = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAuthors = new javax.swing.JTable();
        btnDetail = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnNewAuthor = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Authors");

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search (1).png"))); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        tblAuthors.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblAuthors);

        btnDetail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnDetail.setText("Detail");
        btnDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnNewAuthor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnNewAuthor.setText("New author");
        btnNewAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewAuthorActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(269, 269, 269)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtSearchAuthors, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 225, Short.MAX_VALUE)
                        .addComponent(btnNewAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSearchAuthors, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnNewAuthor, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDelete)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDetail)
                        .addComponent(btnUpdate)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailActionPerformed
        int row = tblAuthors.getSelectedRow();
        if (row < 0) {
            JOptionPane.showConfirmDialog(this, "No row selected!");
            return;
        }
        if (row >= 0) {
            TableModelAuthor tma = (TableModelAuthor) tblAuthors.getModel();
            Author author = tma.getAuthorAt(row);
            new frmAuthor(null, rootPaneCheckingEnabled, FormMode.FORM_VIEW, author, null, administrator).setVisible(true);
        }
    }//GEN-LAST:event_btnDetailActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try {
            String param = txtSearchAuthors.getText().trim();
            ((TableModelAuthor) tblAuthors.getModel()).setParameter(param);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Unable to search the table!");
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int row = tblAuthors.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "No row selected!");
        } else {
            try {
                TableModelAuthor tma = (TableModelAuthor) tblAuthors.getModel();
                Author author = tma.getAuthorAt(row);
                Response response = Communication.getInstance().deleteAutor(author);
                if (response.getResponseStatus().equals(ResponseStatus.Error)) {
                    JOptionPane.showMessageDialog(this, "It is not possible to delete the author");
                } else {
                    tma.deleteAuthor(row);
                    JOptionPane.showMessageDialog(this, "Author has been deleted.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "It is not possible to delete the author");
            }

        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int row = tblAuthors.getSelectedRow();
        if (row < 0) {
            JOptionPane.showConfirmDialog(this, "No row selected!");
            return;
        }
        if (row >= 0) {
            TableModelAuthor tma = (TableModelAuthor) tblAuthors.getModel();
            Author author = tma.getAuthorAt(row);
            new frmAuthor(null, rootPaneCheckingEnabled, FormMode.FORM_EDIT, author, tma, administrator).setVisible(true);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnNewAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewAuthorActionPerformed
        new frmAuthor(null, rootPaneCheckingEnabled, FormMode.FORM_ADD, null, tma, administrator).setVisible(true);
    }//GEN-LAST:event_btnNewAuthorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDetail;
    private javax.swing.JButton btnNewAuthor;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAuthors;
    private javax.swing.JTextField txtSearchAuthors;
    // End of variables declaration//GEN-END:variables

    private void prepareView() {
        try {
            tma = new TableModelAuthor();
            tblAuthors.setModel(tma);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Unable to show authors!");
        }
    }
}
