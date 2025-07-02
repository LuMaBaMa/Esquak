package Logica;
public class Configuracion {
    private static int Cod;
    private static int Busqueda;

    public int getCod() {
        return Cod;
    }

    public void setCod(int Cod) {
        this.Cod = Cod;
    }

    public static int getBusqueda() {
        return Busqueda;
    }

    public static void setBusqueda(int Busqueda) {
        Configuracion.Busqueda = Busqueda;
    }

}
