/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package co.com.hyunseda.market.presentation;

import co.com.hyunseda.market.service.Category;
import co.com.hyunseda.market.service.CategoryService;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author camil
 */
public class GUICategoriesFind extends javax.swing.JDialog {
        private CategoryService categoryService;
    /**
     * Creates new form GUICategoriesFind
     */
    public GUICategoriesFind(java.awt.Frame parent, boolean modal,CategoryService categoryService) {
        super(parent, modal);
        initComponents();
        initializeTable();
        this.categoryService = categoryService;
         setLocationRelativeTo(null); 
        
    }
    private void initializeTable() {
        tblCategories.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Id", "Name"
                }
        ));
    }
    
        private void fillTable(List<Category> listCategories) {
        initializeTable();
        DefaultTableModel model = (DefaultTableModel) tblCategories.getModel();

        Object rowData[] = new Object[3];//No columnas
        for (int i = 0; i < listCategories.size(); i++) {
            rowData[0] = listCategories.get(i).getCategoryId();
            rowData[1] = listCategories.get(i).getName();
            
            model.addRow(rowData);
        }     
    }
     private void fillTableUnique(Category category) {
    initializeTable();
    DefaultTableModel model = (DefaultTableModel) tblCategories.getModel();

    Object rowData[] = new Object[2];//No columnas
    
    // Agregamos directamente las propiedades del producto al modelo de la tabla
    rowData[0] = category.getCategoryId();
    rowData[1] = category.getName();

    model.addRow(rowData);
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rdoId = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        btnSearchAll = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCategories = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        rdoId.setText("id");

        jLabel1.setText("Buscar por:");

        btnSearch.setText("Buscar");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnSearchAll.setText("BuscarTodos");
        btnSearchAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchAllActionPerformed(evt);
            }
        });

        tblCategories.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblCategories);

        btnClose.setText("Cerrar");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdoId, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addComponent(btnSearch)
                .addGap(46, 46, 46)
                .addComponent(btnSearchAll)
                .addGap(113, 113, 113))
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(327, 327, 327)
                .addComponent(btnClose)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoId)
                    .addComponent(jLabel1)
                    .addComponent(btnSearch)
                    .addComponent(btnSearchAll)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnClose)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
         this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnSearchAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchAllActionPerformed
       fillTable(categoryService.findAllCategories());
    }//GEN-LAST:event_btnSearchAllActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
         if(rdoId.isSelected()){
        fillTableUnique(categoryService.findCategoryById(Long.parseLong(txtSearch.getText())));
         }else{
             fillTableUnique(categoryService.findCategoryByName(txtSearch.getText()));
         }
    }//GEN-LAST:event_btnSearchActionPerformed

    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSearchAll;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoId;
    private javax.swing.JTable tblCategories;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}