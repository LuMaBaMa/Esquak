package Disenio;
import java.sql.*;
import java.util.Date;
public class Solicitudes extends javax.swing.JFrame {
    public String alu_nombre,alu_correo,alu_telefono;
    Logica.Configuracion conf = new Logica.Configuracion();
    public int Cod = conf.getCod();
    public int bus = conf.getBusqueda();
    public int alu_boleta;

    public Solicitudes() {
        initComponents();
        despliegueInfo();
    }
    
    public void despliegueInfo(){
        Logica.Coneccion conx = new Logica.Coneccion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;
        con = conx.conectar();
        String sql = "SELECT alu_boleta,alu_nombre,alu_telefono,alu_correo FROM alumnos WHERE alu_boleta = (?)";
            
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1,bus);
            rs = ps.executeQuery();
            
            while(rs.next()){
                alu_boleta = rs.getInt("alu_boleta");
                alu_nombre = rs.getString("alu_nombre");
                alu_telefono = rs.getString("alu_telefono");
                alu_correo = rs.getString("alu_correo");
            }
            
            Nombre_Alumno.setText(alu_nombre);
            Telefono_Alumno.setText(alu_telefono);
            Correo_Alumno.setText(alu_correo);
            String Boleta = Integer.toString(alu_boleta);
            Boleta_Alumno.setText(Boleta);
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
        jLabel2 = new javax.swing.JLabel();
        Nombre_Alumno = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Telefono_Alumno = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Correo_Alumno = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Boleta_Alumno = new javax.swing.JTextField();
        Aceptar_Asesoria = new javax.swing.JButton();
        Regreso = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        Fecha_Asesoria = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jPanel2.setBackground(new java.awt.Color(38, 45, 90));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Aceptar Solicitud");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombre del Alumno:");

        Nombre_Alumno.setEditable(false);
        Nombre_Alumno.setBackground(new java.awt.Color(255, 255, 255));
        Nombre_Alumno.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        Nombre_Alumno.setForeground(new java.awt.Color(0, 0, 0));

        jLabel3.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Telefono del Alumno:");

        Telefono_Alumno.setEditable(false);
        Telefono_Alumno.setBackground(new java.awt.Color(255, 255, 255));
        Telefono_Alumno.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        Telefono_Alumno.setForeground(new java.awt.Color(0, 0, 0));

        jLabel4.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Correo del Alumno:");

        Correo_Alumno.setEditable(false);
        Correo_Alumno.setBackground(new java.awt.Color(255, 255, 255));
        Correo_Alumno.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        Correo_Alumno.setForeground(new java.awt.Color(0, 0, 0));

        jLabel5.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Credencial del Alumno:");

        Boleta_Alumno.setEditable(false);
        Boleta_Alumno.setBackground(new java.awt.Color(255, 255, 255));
        Boleta_Alumno.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        Boleta_Alumno.setForeground(new java.awt.Color(0, 0, 0));

        Aceptar_Asesoria.setBackground(new java.awt.Color(0, 204, 0));
        Aceptar_Asesoria.setFont(new java.awt.Font("Gill Sans MT", 0, 20)); // NOI18N
        Aceptar_Asesoria.setForeground(new java.awt.Color(0, 0, 0));
        Aceptar_Asesoria.setText("Aceptar");
        Aceptar_Asesoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Aceptar_AsesoriaActionPerformed(evt);
            }
        });

        Regreso.setBackground(new java.awt.Color(204, 0, 0));
        Regreso.setForeground(new java.awt.Color(255, 255, 255));
        Regreso.setText("Regresar");
        Regreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresoActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Fecha de la Asesoría:");

        Fecha_Asesoria.setBackground(new java.awt.Color(255, 255, 255));
        Fecha_Asesoria.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(25, 25, 25))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(25, 25, 25))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Nombre_Alumno)
                    .addComponent(Telefono_Alumno)
                    .addComponent(Correo_Alumno)
                    .addComponent(Boleta_Alumno, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                    .addComponent(Fecha_Asesoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Aceptar_Asesoria, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Regreso, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Nombre_Alumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(Telefono_Alumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Correo_Alumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Boleta_Alumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(Regreso))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(Fecha_Asesoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(Aceptar_Asesoria, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 27, Short.MAX_VALUE))
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
        Asesorias_Solicitadas asesor = new Asesorias_Solicitadas();
        asesor.setVisible(true);
        dispose();
    }//GEN-LAST:event_RegresoActionPerformed

    private void Aceptar_AsesoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Aceptar_AsesoriaActionPerformed
        Logica.Registro registro = new Logica.Registro();
        Date mFecha = Fecha_Asesoria.getDate();
        long fecha = mFecha.getTime();
        java.sql.Date fecha_sql = new java.sql.Date(fecha);
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT as_nombre,as_materia FROM asesores WHERE id_asesor = (?)";
        Logica.Coneccion conx = new Logica.Coneccion();
        con = conx.conectar();
        String Nombre_Asesor,Materia_Asesor;
        
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1,Cod);
            rs = ps.executeQuery();
            
            if(rs.next()){
                Nombre_Asesor = rs.getString("as_nombre");
                Materia_Asesor = rs.getString("as_materia");
                int boleta = bus;
                
                registro.Solicitud_Aceptada(Materia_Asesor,fecha_sql,boleta,Nombre_Alumno,Nombre_Asesor,Cod);
                dispose();
            }
        }catch(SQLException e){
            System.err.println(e);
        }
    }//GEN-LAST:event_Aceptar_AsesoriaActionPerformed

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
            java.util.logging.Logger.getLogger(Solicitudes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Solicitudes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Solicitudes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Solicitudes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Solicitudes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aceptar_Asesoria;
    private javax.swing.JTextField Boleta_Alumno;
    private javax.swing.JTextField Correo_Alumno;
    private com.toedter.calendar.JDateChooser Fecha_Asesoria;
    private javax.swing.JTextField Nombre_Alumno;
    private javax.swing.JButton Regreso;
    private javax.swing.JTextField Telefono_Alumno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
