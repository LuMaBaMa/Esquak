package prueba_mysql;
import java.sql.*;
public class Despliegue_MySQL {
    public static void Consulta(Connection con){
        String sql = "SELECT * FROM tabla";
        Statement stmt;
        ResultSet rs;
        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            String frase;
            int num;
            
            while(rs.next()){
                num = rs.getInt("num");
                frase = rs.getString("frase");
                
                System.out.println("num: "+num+"\n"+"frase: "+frase);
                System.out.println(" ");
            }
        }
        catch(SQLException e){
            e.getMessage();
            throw new RuntimeException();
        }
    }
}
