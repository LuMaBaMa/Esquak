package Logica;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import Logica.Configuracion;
public class Actualiza {
    public static void Actualizar(JComboBox Materia_Asesor,JTextField Contrasenia_Asesor, 
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
            } else {
                JOptionPane.showMessageDialog(null, "Los datos han sid");
            }
        } catch(SQLException e){
            System.out.println("Error: "+e.toString());
        }
    }
}
