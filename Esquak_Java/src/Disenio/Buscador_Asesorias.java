package Disenio;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
public class Buscador_Asesorias extends javax.swing.JFrame {

    public Buscador_Asesorias() {
        initComponents();
    }
    
    public void mostrarAsesorias(String tabla){
        String materia = Materia.getSelectedItem().toString();
        String sql = "SELECT * FROM asesores WHERE as_materia = (?)";
        PreparedStatement ps = null;
        Connection con = null;
        Logica.Coneccion conx = new Logica.Coneccion();
        con = conx.conectar();
        
        Asesorias.setDefaultRenderer(Object.class, new Render());
        JButton Mostrar = new JButton("Mostrar");
        Mostrar.setName("Mostrar");
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Matería");
        modelo.addColumn("Nombre");
        modelo.addColumn("Codigo");
        modelo.addColumn(" ");
        Asesorias.setModel(modelo);
        
        Object[] datos = new Object[4];
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1,materia);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                datos[0] = rs.getString(4);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(1);
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
            Asesorias.addRowSelectionInterval(0, 0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Regreso = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        Materia = new javax.swing.JComboBox<>();
        Buscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Asesorias = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Buscador de Asesorías");

        Regreso.setBackground(new java.awt.Color(204, 0, 0));
        Regreso.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
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
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Regreso, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Regreso, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                        .addGap(5, 5, 5))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(38, 45, 90));

        Materia.setBackground(new java.awt.Color(255, 255, 255));
        Materia.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        Materia.setForeground(new java.awt.Color(0, 0, 0));
        Materia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Algebra", "Geometría y Trigonometría", "Geometría Analítica", "Calculo Diferencial", "Calculo Integral", "Probabilidad y Estadística", "Física I", "Física II", "Física III", "Física IV", "Química I", "Química II", "Química III", "Química IV" }));

        Buscar.setBackground(new java.awt.Color(204, 0, 204));
        Buscar.setFont(new java.awt.Font("Gill Sans MT", 0, 20)); // NOI18N
        Buscar.setForeground(new java.awt.Color(255, 255, 255));
        Buscar.setText("Buscar");
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(Materia, 0, 421, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Buscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Materia, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        Asesorias.setBackground(new java.awt.Color(255, 255, 255));
        Asesorias.setForeground(new java.awt.Color(0, 0, 0));
        Asesorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matería", "Nombre", "Código", ""
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
        Asesorias.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        Asesorias.setCellSelectionEnabled(true);
        Asesorias.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Asesorias.setEnabled(false);
        Asesorias.setGridColor(new java.awt.Color(0, 0, 0));
        Asesorias.setRowHeight(30);
        Asesorias.getTableHeader().setResizingAllowed(false);
        Asesorias.getTableHeader().setReorderingAllowed(false);
        Asesorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AsesoriasMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AsesoriasMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(Asesorias);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE))
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
        Menu_Alumno menu = new Menu_Alumno();
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_RegresoActionPerformed

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        mostrarAsesorias("asesoria");
    }//GEN-LAST:event_BuscarActionPerformed

    private void AsesoriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AsesoriasMouseClicked
        int column = Asesorias.getColumnModel().getColumnIndexAtX(evt.getX());
        int row  = evt.getY()/Asesorias.getRowHeight();
        
        if(row < Asesorias.getRowCount() && row >= 0 && column < Asesorias.getColumnCount() && column >= 0){
            Asesorias.setRowSelectionInterval(row,row);
            Object value = Asesorias.getValueAt(row,column);
            if(value instanceof JButton){
                ((JButton)value).doClick();
                JButton boton = (JButton) value;
                
                //Eventos del código
                int f = Asesorias.getSelectedRow();
                if(Asesorias.getRowCount() == 0){
                    System.out.println("No hay datos disponibles");
                } else if(f != -1){
                    String Prueba = Asesorias.getValueAt(f,2).toString();
                    int Codigo = Integer.parseInt(Prueba);
                    Logica.Configuracion conf = new Logica.Configuracion();
                    conf.setBusqueda(Codigo);
                    Solicitud sol = new Solicitud();
                    sol.setVisible(true);
                    dispose();
                } else {
                    System.out.println("No hay ninguna fila seleccionada");
                }    
            }
        }
    }//GEN-LAST:event_AsesoriasMouseClicked

    private void AsesoriasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AsesoriasMousePressed

    }//GEN-LAST:event_AsesoriasMousePressed

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
            java.util.logging.Logger.getLogger(Buscador_Asesorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Buscador_Asesorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Buscador_Asesorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Buscador_Asesorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Buscador_Asesorias().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Asesorias;
    private javax.swing.JButton Buscar;
    private javax.swing.JComboBox<String> Materia;
    private javax.swing.JButton Regreso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
