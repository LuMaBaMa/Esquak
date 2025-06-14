package Logica;
public class ESQUAK {
    public static void main(String[] args) {
        Coneccion conx = new Coneccion();
        conx.conectar();
        Disenio.Principal menu = new Disenio.Principal();
        menu.setVisible(true);
    }
}