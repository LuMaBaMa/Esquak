package Disenio;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
public class Asesorias_Solicitadas extends javax.swing.JFrame {
    Logica.Configuracion conf = new Logica.Configuracion();
    int Cod = conf.getCod();
    
    public Asesorias_Solicitadas() {
        initComponents();
        mostrarSolicitudes("solicitud");
    }
    
    public void mostrarSolicitudes(String tabla){
        Connection con = null;
        PreparedStatement ps = null;
        Logica.Coneccion conx = new Logica.Coneccion();
        con = conx.conectar();
        String sql = "SELECT alumno,telefono,correo FROM solicitud WHERE asesor = (?)";
        
        Solicitudes.setDefaultRenderer(Object.class, new Render());
        JButton Mostrar = new JButton("Mostrar");
        Mostrar.setName("Mostrar");
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Alumno");
        modelo.addColumn("Telefono");
        modelo.addColumn("Correo");
        modelo.addColumn(" ");
        Solicitudes.setModel(modelo);
        
        Object[] datos = new Object[4];
        
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1,Cod);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = Mostrar;
                modelo.addRow(datos);
            }
        } catch(SQLException e){
            System.out.println("Error: "+e.toString());
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
        
        if(modelo.getRowCount()>0){
            Solicitudes.addRowSelectionInterval(0, 0);
        }
        
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Regreso = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Solicitudes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jPanel2.setBackground(new java.awt.Color(38, 45, 90));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Solicitudes");

        Regreso.setBackground(new java.awt.Color(204, 0, 0));
        Regreso.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
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
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Regreso, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(Regreso, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 19, Short.MAX_VALUE)))
                .addContainerGap())
        );

        Solicitudes.setBackground(new java.awt.Color(255, 255, 255));
        Solicitudes.setForeground(new java.awt.Color(0, 0, 0));
        Solicitudes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Alumno", "Telefono", "Correo", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
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
        Solicitudes.setCellSelectionEnabled(true);
        Solicitudes.setEnabled(false);
        Solicitudes.setGridColor(new java.awt.Color(0, 0, 0));
        Solicitudes.setRowHeight(30);
        Solicitudes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SolicitudesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Solicitudes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE))
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

    private void SolicitudesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SolicitudesMouseClicked
        int column = Solicitudes.getColumnModel().getColumnIndexAtX(evt.getX());
        int row  = evt.getY()/Solicitudes.getRowHeight();
        
        if(row < Solicitudes.getRowCount() && row >= 0 && column < Solicitudes.getColumnCount() && column >= 0){
            Solicitudes.setRowSelectionInterval(row,row);
            Object value = Solicitudes.getValueAt(row,column);
            if(value instanceof JButton){
                ((JButton)value).doClick();
                JButton boton = (JButton) value;
                
                int f = Solicitudes.getSelectedRow();
                if(Solicitudes.getRowCount() == 0){
                    System.out.println("No hay datos disponibles");
                } else if(f != -1){
                    String Prueba = Solicitudes.getValueAt(f,0).toString();
                    int Busqueda = Integer.parseInt(Prueba);
                    Logica.Configuracion conf = new Logica.Configuracion();
                    conf.setBusqueda(Busqueda);
                    Solicitudes solicitud = new Solicitudes();
                    solicitud.setVisible(true);
                    dispose();
                } else {
                    System.out.println("No hay ninguna fila seleccionada");
                }    
            }
        }
    }//GEN-LAST:event_SolicitudesMouseClicked

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
            java.util.logging.Logger.getLogger(Asesorias_Solicitadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Asesorias_Solicitadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Asesorias_Solicitadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Asesorias_Solicitadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Asesorias_Solicitadas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Regreso;
    private javax.swing.JTable Solicitudes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
