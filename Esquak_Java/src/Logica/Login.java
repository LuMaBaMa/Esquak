package Logica;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class Login {
    public void ValidaAlumno(JTextField Codigo, JPasswordField Contrasenia){
        String contra = new String(Contrasenia.getPassword()), codg = Codigo.getText();
        int Cod = Integer.parseInt(Codigo.getText());
        try{
            ResultSet rs = null;
            PreparedStatement ps = null;
            Connection con = null;
            Coneccion conx = new Coneccion();
            con = conx.conectar();
            String consulta = "select * from alumnos where alumnos.alu_boleta = (?) and alumnos.alu_contrasenia = (?)";
            ps = con.prepareStatement(consulta);
            
            ps.setString(1,Codigo.getText());
            ps.setString(2,contra);
        
            rs = ps.executeQuery();
            if(rs.next()){
                Logica.Configuracion conf = new Logica.Configuracion();
                conf.setCod(Cod);
                JOptionPane.showMessageDialog(null,"Bienvenido");
                Disenio.Menu_Alumno Menu = new Disenio.Menu_Alumno();
                Menu.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null,"El usuario es incorrecto");
                return;
            }
            
        }catch(Exception e){
            System.out.println("No se puede ingresar");
            JOptionPane.showMessageDialog(null,"ERROR: "+e.toString());
            return;
        }
    }
    
    public void ValidaAsesor(JTextField Codigo, JPasswordField Contrasenia){
        try{
            ResultSet rs = null;
            PreparedStatement ps = null;
            Connection con = null;
            Coneccion conx = new Coneccion();
            con = conx.conectar();
            String consulta = "select * from asesores where asesores.id_asesor = (?) and asesores.as_contrasenia = (?)";
            ps = con.prepareStatement(consulta);
            int Cod = Integer.parseInt(Codigo.getText());
            
            String contra = new String(Contrasenia.getPassword());
            ps.setString(1,Codigo.getText());
            ps.setString(2,contra);
            
            rs = ps.executeQuery();    
            if(rs.next()){
                Logica.Configuracion conf = new Logica.Configuracion();
                conf.setCod(Cod);
                JOptionPane.showMessageDialog(null,"Bienvenido");
                Disenio.Menu_Asesor Menu = new Disenio.Menu_Asesor();
                Menu.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null,"El usuario es incorrecto");
            }            
        }catch(Exception e){
            System.out.println("No se puede ingresar");
            System.out.println("Error: "+e.toString());
        }
    }
    
    public void ValidaAdmin(JTextField Codigo, JPasswordField Contrasenia){
        try{
            ResultSet rs = null;
            PreparedStatement ps = null;
            Connection con = null;
            Coneccion conx = new Coneccion();
            con = conx.conectar();
            String consulta = "select * from administrador where administrador.id_admin = (?) and administrador.ad_contrasenia = (?)";
            ps = con.prepareStatement(consulta);
            
            String contra = new String(Contrasenia.getPassword());
            ps.setString(1,Codigo.getText());
            ps.setString(2,contra);
            rs = ps.executeQuery();
            
            if(rs.next()){
                JOptionPane.showMessageDialog(null,"Bienvenido");
                Disenio.Menu_Admin Menu = new Disenio.Menu_Admin();
                Menu.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null,"El usuario es incorrecto");
            }
            
        }catch(Exception e){
            System.out.println("No se puede ingresar");
            JOptionPane.showMessageDialog(null,"ERROR: "+e.toString());
        }
    }
}
