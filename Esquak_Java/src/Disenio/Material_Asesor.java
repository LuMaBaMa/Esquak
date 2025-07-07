package Disenio;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
public class Material_Asesor extends javax.swing.JFrame {
    Logica.Configuracion conf = new Logica.Configuracion();
    int Cod = conf.getCod();
    
    public Material_Asesor() {
        initComponents();
        mostrarMaterial("material");
    }
    
    public void mostrarMaterial(String tabla){
        String sql = "SELECT num_material,nombre_archivo FROM material WHERE asesor = (?)";
        PreparedStatement ps = null;
        Connection con = null;
        Logica.Coneccion conx = new Logica.Coneccion();
        con = conx.conectar();
        
        Material.setDefaultRenderer(Object.class, new Render());
        JButton Mostrar = new JButton();
        Mostrar.setName("Mostrar");
        JButton Borrar = new JButton();
        Borrar.setName("Borrar");
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Numero");
        modelo.addColumn("Titulo");
        modelo.addColumn(" ");
        modelo.addColumn(" ");
        Material.setModel(modelo);
        
        Object[] datos = new Object[4];
        
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1,Cod);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = Mostrar;
                datos[3] = Borrar;
                modelo.addRow(datos);
            }
        } catch(SQLException e){
            System.err.println(e);
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Subir = new javax.swing.JButton();
        Regreso = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Material = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jPanel2.setBackground(new java.awt.Color(38, 45, 90));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Material del Asesor");

        Subir.setBackground(new java.awt.Color(153, 0, 102));
        Subir.setFont(new java.awt.Font("Gill Sans MT", 0, 20)); // NOI18N
        Subir.setForeground(new java.awt.Color(255, 255, 255));
        Subir.setText("Subir Material");

        Regreso.setBackground(new java.awt.Color(153, 0, 0));
        Regreso.setFont(new java.awt.Font("Gill Sans MT", 0, 20)); // NOI18N
        Regreso.setForeground(new java.awt.Color(255, 255, 255));
        Regreso.setText("Regresar");
        Regreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(Subir, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Regreso, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                    .addComponent(Subir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Regreso, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        Material.setBackground(new java.awt.Color(255, 255, 255));
        Material.setForeground(new java.awt.Color(0, 0, 0));
        Material.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero", "Titulo", "", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Material.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MaterialMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Material);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresoActionPerformed
        Menu_Asesor menu = new Menu_Asesor();
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_RegresoActionPerformed

    private void MaterialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MaterialMouseClicked
        int column = Material.getColumnModel().getColumnIndexAtX(evt.getX());
        int row  = evt.getY()/Material.getRowHeight();
        
        if(row < Material.getRowCount() && row >= 0 && column < Material.getColumnCount() && column >= 0){
            Material.setRowSelectionInterval(row,row);
            Object value = Material.getValueAt(row,column);
            if(value instanceof JButton){
                ((JButton)value).doClick();
                JButton boton = (JButton) value;
                
                if(boton.getName().equals("Mostrar")){
                    int f = Material.getSelectedRow();
                    if(Material.getRowCount() == 0){
                        System.out.println("No hay datos disponibles");
                    } else if(f != -1){
                        String Prueba = Material.getValueAt(f,2).toString();
                        int Codigo = Integer.parseInt(Prueba);
                        Logica.Configuracion conf = new Logica.Configuracion();
                        conf.setBusqueda(Codigo);
                        Logica.Material mat = new Logica.Material();
                        mat.mostrarArchivo();
                    } else {
                        System.out.println("No hay ninguna fila seleccionada");
                    }
                }else if(boton.getName().equals("Borrar")){
                    
                }
            }
        }
    }//GEN-LAST:event_MaterialMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Material_Asesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Material_Asesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Material_Asesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Material_Asesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Material_Asesor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Material;
    private javax.swing.JButton Regreso;
    private javax.swing.JButton Subir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
