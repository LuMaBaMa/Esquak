package prueba_mysql;
import java.sql.*;
public class Actualizar_MySQL {
    public static void Actualiza(Connection con, int num, String frase){
        String sql = "update tabla set frase = '"+frase+"' where num = '"+num+"'";
        Statement stmt;
        int resultado;
        try{
            stmt = con.createStatement();
            resultado = stmt.executeUpdate(sql);
            
            if(resultado == 1){
                System.out.println("El registro se ha modificado exitosamente");
            } else{
                System.out.println("El registro con el numero "+num+" no se logro encontrar");
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
