package Logica;
import java.sql.*;
public class Coneccion {
    static String url = "jdbc:mysql://localhost:3306/bd_esquak";
    static String user = "root";
    static String pass = "1234";
    
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
