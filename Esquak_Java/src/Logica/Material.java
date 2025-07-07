package Logica;
import java.io.*;
import java.sql.*;
public class Material {
    byte[] archivo;
    Configuracion conf = new Configuracion();
    int bus = conf.getBusqueda();
    int Cod = conf.getCod();
    
    public byte[] getArchivo() {
        return archivo;
    }

    public void setArchivo(byte[] archivo) {
        this.archivo = archivo;
    }
    
    public void mostrarArchivo(){
        Coneccion conx = new Coneccion();
        PreparedStatement ps = null;
        Connection con = conx.conectar();
        ResultSet rs = null;
        byte[] b = null;
        String sql = "SELECT contenido FROM material WHERE num_material = ?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, bus);
            rs = ps.executeQuery();
            while(rs.next()){
                b = rs.getBytes(1);
            }
            InputStream bos = new ByteArrayInputStream(b);
            
            int tamanoInput = bos.available();
            byte[] datosPDF = new byte[tamanoInput];
            bos.read(datosPDF,0,tamanoInput);
            
            OutputStream out = new FileOutputStream("new.pdf");
            out.write(datosPDF);
            
            out.close();
            bos.close();
            ps.close();
            rs.close();
        }catch(SQLException | IOException | NumberFormatException e){
            System.err.println(e);
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }
    
    public void subirArchivo(String Materia,String Nombre,byte archivo){
        Connection con = null;
        Coneccion conx = new Coneccion();
        PreparedStatement ps = null;
        con = conx.conectar();
        String sql = "INSERT INTO material(asesor,materia,nombre_archivo,contenido) VALUES (?,?,?,?)";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1,Cod);
            ps.setString(2, Materia);
            ps.setString(3,Nombre);
            ps.setByte(4, archivo);
            int resultado = ps.executeUpdate();
            if(resultado == 1){
                Disenio.Material_Asesor mat = new Disenio.Material_Asesor();
                mat.setVisible(true);
            }
        }catch(SQLException e){
        }
    }
}
