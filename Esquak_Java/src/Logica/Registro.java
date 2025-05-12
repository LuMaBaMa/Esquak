package Logica;
import java.sql.*;
import javax.swing.JTextField;
public class Registro {
    public static void reg_alumno(JTextField Boleta_Alumno, JTextField Nombre_Alumno, JTextField Contrasenia_Alumno){
        String sql = "insert into alumnos(alu_boleta, alu_nombre, alu_contrasenia) values (?,?,?)";
        int resultado;
        Connection con = null;
        Coneccion conx = new Coneccion();
        con = conx.conectar();
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,Boleta_Alumno.getText());
            ps.setString(2,Nombre_Alumno.getText());
            ps.setString(3,Contrasenia_Alumno.getText());
            resultado = ps.executeUpdate();
            if(resultado == 1){
                Disenio.Menu_Alumno menual = new Disenio.Menu_Alumno();
                menual.setVisible(true);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
    
    public static void reg_asesor(JTextField Codigo_Asesor, JTextField Nombre_Asesor,
            JTextField Contrasenia_Asesor, JTextField Materia_Asesor,
            JTextField Telefono_Asesor, JTextField Correo_Asesor){
        String sql = "insert into asesores(id_asesor, as_nombre, as_contrasenia, as_materia, as_correo, as_telefono) "
                + "values (?,?,?,?,?,?)";
        Coneccion conx = new Coneccion();
        Connection con = null;
        con = conx.conectar();
        int resultado;
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,Codigo_Asesor.getText());
            ps.setString(2,Nombre_Asesor.getText());
            ps.setString(3,Contrasenia_Asesor.getText());
            ps.setString(4,Materia_Asesor.getText());
            ps.setString(5,Correo_Asesor.getText());
            ps.setString(6,Telefono_Asesor.getText());
            resultado = ps.executeUpdate();
            if(resultado == 1){
                Disenio.Menu_Asesor menuas = new Disenio.Menu_Asesor();
                menuas.setVisible(true);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
