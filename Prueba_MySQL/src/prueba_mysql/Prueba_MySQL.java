package prueba_mysql;
public class Prueba_MySQL {
    public static void main(String[] args) {
        Coneccion_DB conx = new Coneccion_DB();
        Despliegue_MySQL des = new Despliegue_MySQL();
        Ingresa_MySQL ing = new Ingresa_MySQL();
        Borrar_MySQL br = new Borrar_MySQL();
        Actualizar_MySQL act = new Actualizar_MySQL();
        
        ing.insertar(conx.conectar(),"matanga",2099);
        des.Consulta(conx.conectar());
        br.Borrar(conx.conectar(),2099);
        act.Actualiza(conx.conectar(),1234,"Ejemplo");
        des.Consulta(conx.conectar());
    }
    
}
