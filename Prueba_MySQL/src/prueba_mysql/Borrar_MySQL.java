package prueba_mysql;
import java.sql.*;
public class Borrar_MySQL {
    public static void Borrar(Connection con, int num){
        //Delete from tabla where num = '1234';
        String sql = "delete from tabla where num = '"+num+"'";
        Statement stmt;
        int resultado;
        
        try{
            stmt = con.createStatement();
            resultado = stmt.executeUpdate(sql);
            if(resultado == 1){
                System.out.println("Se ha borrado el registro");
            } else{
                System.out.println("No existe el registro que se esta buscando");
            }
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
