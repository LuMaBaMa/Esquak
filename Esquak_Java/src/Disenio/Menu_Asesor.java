package Disenio;
import Logica.Configuracion;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
public class Menu_Asesor extends javax.swing.JFrame {
    Configuracion conf = new Configuracion();
    int Cod = conf.getCod();
    public Menu_Asesor() {
        initComponents();
        mostrarAsesorias("asesorias");
    }
    
    public void mostrarAsesorias(String tabla){
        String sql = "SELECT alumno, fecha, alu_nombre fecha FROM asesoria WHERE asesor = (?)";
        Connection con = null;
        Logica.Coneccion conx = new Logica.Coneccion();
        con = conx.conectar();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Boleta");
        modelo.addColumn("Fecha");
        modelo.addColumn("Alumno");
        Asesorias.setModel(modelo);
        String[] datos = new String[3];
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,Cod);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                modelo.addRow(datos);
            }
        }catch(SQLException e){
            System.out.println("Error: "+e.toString());
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
        panel1 = new java.awt.Panel();
        jLabel1 = new javax.swing.JLabel();
        panel2 = new java.awt.Panel();
        Cerrar_Sesion_Asesor = new javax.swing.JButton();
        Revisar_Asesorias = new javax.swing.JButton();
        Subir_Material = new javax.swing.JButton();
        Informacion_Personal = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Asesorias = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 0));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        panel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Bienvenido Asesor");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(448, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panel2.setBackground(new java.awt.Color(38, 45, 90));

        Cerrar_Sesion_Asesor.setBackground(new java.awt.Color(255, 0, 0));
        Cerrar_Sesion_Asesor.setForeground(new java.awt.Color(255, 255, 255));
        Cerrar_Sesion_Asesor.setText("Cerrar Sesión");
        Cerrar_Sesion_Asesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cerrar_Sesion_AsesorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(Cerrar_Sesion_Asesor)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Cerrar_Sesion_Asesor)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Revisar_Asesorias.setBackground(new java.awt.Color(51, 0, 255));
        Revisar_Asesorias.setFont(new java.awt.Font("Gill Sans MT", 0, 20)); // NOI18N
        Revisar_Asesorias.setForeground(new java.awt.Color(255, 255, 255));
        Revisar_Asesorias.setText("Revisar Asesorias");
        Revisar_Asesorias.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Revisar_Asesorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Revisar_AsesoriasActionPerformed(evt);
            }
        });

        Subir_Material.setBackground(new java.awt.Color(51, 204, 0));
        Subir_Material.setFont(new java.awt.Font("Gill Sans MT", 0, 20)); // NOI18N
        Subir_Material.setForeground(new java.awt.Color(255, 255, 255));
        Subir_Material.setText("Subir Material");
        Subir_Material.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        Informacion_Personal.setBackground(new java.awt.Color(0, 204, 204));
        Informacion_Personal.setFont(new java.awt.Font("Gill Sans MT", 0, 20)); // NOI18N
        Informacion_Personal.setForeground(new java.awt.Color(0, 0, 0));
        Informacion_Personal.setText("Información Personal");
        Informacion_Personal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Informacion_Personal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Informacion_PersonalActionPerformed(evt);
            }
        });

        Asesorias.setBackground(new java.awt.Color(255, 255, 255));
        Asesorias.setForeground(new java.awt.Color(0, 0, 0));
        Asesorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Boleta", "Fecha", "Alumno"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Asesorias.setEnabled(false);
        Asesorias.setRowHeight(30);
        jScrollPane1.setViewportView(Asesorias);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Subir_Material, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Revisar_Asesorias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Informacion_Personal, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(Revisar_Asesorias, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(Subir_Material, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addComponent(Informacion_Personal, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
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

    private void Informacion_PersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Informacion_PersonalActionPerformed
        Info_Asesor info = new Info_Asesor();
        info.setVisible(true);
        dispose();
    }//GEN-LAST:event_Informacion_PersonalActionPerformed

    private void Cerrar_Sesion_AsesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cerrar_Sesion_AsesorActionPerformed
        Principal menu = new Principal();
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_Cerrar_Sesion_AsesorActionPerformed

    private void Revisar_AsesoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Revisar_AsesoriasActionPerformed
        Asesorias_Solicitadas asesor = new Asesorias_Solicitadas();
        asesor.setVisible(true);
        dispose();
    }//GEN-LAST:event_Revisar_AsesoriasActionPerformed

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
            java.util.logging.Logger.getLogger(Menu_Asesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_Asesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_Asesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_Asesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_Asesor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Asesorias;
    private javax.swing.JButton Cerrar_Sesion_Asesor;
    private javax.swing.JButton Informacion_Personal;
    private javax.swing.JButton Revisar_Asesorias;
    private javax.swing.JButton Subir_Material;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Panel panel1;
    private java.awt.Panel panel2;
    // End of variables declaration//GEN-END:variables
}
