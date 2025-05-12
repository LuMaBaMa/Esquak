package Logica;
import java.sql.*;
public class Coneccion {
    static String url = "jdbc:mysql://localhost:3306/bd_esquak";
    static String user = "root"; //Se modifica dependiendo tu equipo
    static String pass = "1234"; //Se modifica dependiendo tu equipo
    
    public static Connection conectar(){
        Connection con = null;
        try{
            con = DriverManager.getConnection(url,user,pass);
        } catch (SQLException e){
            e.printStackTrace();
        }
        
        return con;
    }
}
