package prueba_mysql;
import java.sql.*;
public class Ingresa_MySQL {
    public static void insertar(Connection con, String frase, int num){
        //Insert into tabla(frase,num) values (matanga, 2099);
        String sql = "insert into tabla(frase,num) values ('"+frase+"','"+num+"')";
        Statement stmt;
        int resultado;
        
        try{
            stmt = con.createStatement();
            resultado = stmt.executeUpdate(sql);
            if(resultado == 1){
                System.out.println("Los datos fueron ingresados exitosamente");
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
