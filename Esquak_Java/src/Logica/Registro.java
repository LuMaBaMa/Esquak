package Logica;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class Registro {
    public static void reg_alumno(JTextField Boleta_Alumno, JTextField Nombre_Alumno,
            JTextField Telefono_Alumno, JTextField Correo_Alumno, JTextField Contrasenia_Alumno){
        String sql = "insert into alumnos(alu_boleta, alu_nombre, alu_telefono, alu_correo, alu_contrasenia) values (?,?,?,?,?)";
        int resultado;
        Connection con = null;
        Coneccion conx = new Coneccion();
        con = conx.conectar();
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            int Cod = Integer.parseInt(Boleta_Alumno.getText());
            
            ps.setString(1,Boleta_Alumno.getText());
            ps.setString(2,Nombre_Alumno.getText());
            ps.setString(3,Telefono_Alumno.getText());
            ps.setString(4,Correo_Alumno.getText());
            ps.setString(5,Contrasenia_Alumno.getText());
            resultado = ps.executeUpdate();
            if(resultado == 1){
                Logica.Configuracion conf = new Logica.Configuracion();
                conf.setCod(Cod);
                Disenio.Menu_Alumno menual = new Disenio.Menu_Alumno();
                menual.setVisible(true);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Hubo un error");
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
    
    public static void reg_asesor(JTextField Codigo_Asesor, JTextField Nombre_Asesor, 
            JTextField Contrasenia_Asesor, JComboBox Materia_Asesor, JTextField Correo_Asesor, JTextField Telefono_Asesor){
        String sql = "insert into asesores(id_asesor, as_nombre, as_contrasenia, as_materia, as_correo, as_telefono) "
                + "values (?,?,?,?,?,?)";
        Coneccion conx = new Coneccion();
        Connection con = null;
        con = conx.conectar();
        int resultado;
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            int Cod = Integer.parseInt(Codigo_Asesor.getText());
            String materia = Materia_Asesor.getSelectedItem().toString();
            
            ps.setString(1,Codigo_Asesor.getText());
            ps.setString(2,Nombre_Asesor.getText());
            ps.setString(3,Contrasenia_Asesor.getText());
            ps.setString(4,materia);
            ps.setString(5,Correo_Asesor.getText());
            ps.setString(6,Telefono_Asesor.getText());
            resultado = ps.executeUpdate();
            if(resultado == 1){
                Logica.Configuracion conf = new Logica.Configuracion();
                conf.setCod(Cod);
                Disenio.Menu_Asesor menuas = new Disenio.Menu_Asesor();
                menuas.setVisible(true);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"No se han llenado todos los campos");
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
