package Logica;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.util.Date;
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
            System.err.println(e);
            throw new RuntimeException(e);
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
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
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }

    public void SolicitarAsesorias(JTextField Materia_Asesor, String alu_correo, String alu_telefono) {
        Connection con = null;
        Configuracion conf = new Configuracion();
        int Cod = conf.getCod();
        int bus = conf.getBusqueda();
        System.out.println(bus);
        Coneccion conx = new Coneccion();
        con = conx.conectar();
        String sql = "INSERT INTO solicitud(materia,alumno,telefono,correo,asesor) values (?,?,?,?,?)";
        PreparedStatement ps = null;
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1,Materia_Asesor.getText());
            ps.setInt(2,Cod);
            ps.setString(3,alu_telefono);
            ps.setString(4,alu_correo);
            ps.setInt(5,bus);
            int resultado = ps.executeUpdate();
            
            if(resultado == 1){
                Disenio.Menu_Alumno menu = new Disenio.Menu_Alumno();
                menu.setVisible(true);
                System.out.println("Solicitud enviada");
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }
    
    public void Solicitud_Aceptada(String Materia_Asesor,java.sql.Date fecha_sql,int boleta,
            JTextField Nombre_Alumno,String Nombre_Asesor,int Cod){
        Connection con = null;
        PreparedStatement ps = null;
        Coneccion conx = new Coneccion();
        con = conx.conectar();
        String sql = "INSERT INTO asesoria(materia,fecha,alumno,alu_nombre,as_nombre,asesor) values (?,?,?,?,?,?)";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, Materia_Asesor);
            ps.setDate(2, fecha_sql);
            ps.setInt(3, boleta);
            ps.setString(4,Nombre_Alumno.getText());
            ps.setString(5,Nombre_Asesor);
            ps.setInt(6,Cod);
            int resultado = ps.executeUpdate();
            
            if(resultado == 1){
                System.out.println("Se ha registrado la asesoría exitosamente");
                Actualiza ac = new Actualiza();
                ac.borrarSolicitud();
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
