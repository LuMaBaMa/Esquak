package Logica;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import Logica.Configuracion;
public class Actualiza {
    public static void Actualizar_Asesor(JComboBox Materia_Asesor,JTextField Contrasenia_Asesor, 
            JTextField Correo_Asesor, JTextField Telefono_Asesor){
        Configuracion conf = new Configuracion();
        String sql = "UPDATE asesores SET as_contrasenia = (?), as_materia = (?), as_correo = (?), as_telefono = (?) WHERE id_asesor = (?)";
        int resultado, Cod = conf.getCod();
        Connection con = null;
        Coneccion conx = new Coneccion();
        con = conx.conectar();
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            String materia = Materia_Asesor.getSelectedItem().toString();
            
            ps.setString(1,Contrasenia_Asesor.getText());
            ps.setString(2,materia);
            ps.setString(3,Correo_Asesor.getText());
            ps.setString(4,Telefono_Asesor.getText());
            ps.setInt(5,Cod);
            resultado = ps.executeUpdate();
            
            if(resultado == 1){
                JOptionPane.showMessageDialog(null, "Los datos han sido actualizados");
                Disenio.Menu_Asesor menu = new Disenio.Menu_Asesor();
                menu.setVisible(true);
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
    }
    
    public static void Actualizar_Alumno(JTextField Telefono_Alumno, JTextField Correo_Alumno, JTextField Contrasenia_Alumno){
        Configuracion conf = new Configuracion();
        String sql = "UPDATE alumnos SET alu_telefono = (?), alu_correo = (?), alu_contrasenia = (?) WHERE alu_boleta = (?)";
        int resultado, Cod = conf.getCod();
        Connection con = null;
        Coneccion conx = new Coneccion();
        con = conx.conectar();
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1,Telefono_Alumno.getText());
            ps.setString(2,Correo_Alumno.getText());
            ps.setString(3,Contrasenia_Alumno.getText());
            ps.setInt(4,Cod);
            resultado = ps.executeUpdate();
            
            if(resultado == 1){
                JOptionPane.showMessageDialog(null, "Los datos han sido actualizados");
                Disenio.Menu_Alumno menu = new Disenio.Menu_Alumno();
                menu.setVisible(true);
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
    }
    
    public void borrarSolicitud(){
        Configuracion conf = new Configuracion();
        int Cod = conf.getCod();
        int bus = conf.getBusqueda();
        String sql = "DELETE FROM solicitud WHERE asesor = (?) and alumno = (?)";
        Connection con = null;
        Coneccion conx = new Coneccion();
        con = conx.conectar();
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1,Cod);
            ps.setInt(2,bus);
            int resultado = ps.executeUpdate();
            
            if(resultado == 1){
                JOptionPane.showMessageDialog(null, "La asesoria se ha aceptado");
                Disenio.Asesorias_Solicitadas asesor = new Disenio.Asesorias_Solicitadas();
                asesor.setVisible(true);
            }
        }catch(SQLException e){
            System.err.println(e);
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }
}
