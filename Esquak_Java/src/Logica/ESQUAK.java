package Logica;
public class ESQUAK {
    public static void main(String[] args) {
        Coneccion con =  new Coneccion();
        con.conectar();
        Disenio.Principal menu = new Disenio.Principal();
        menu.setVisible(true);
    }
}