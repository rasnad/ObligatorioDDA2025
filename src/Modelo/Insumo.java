package Modelo;

public class Insumo {
    String nombre;
    int cantidadMinima;
    int cantidadActual;

    public Insumo(String nombre, int cantidadMinima, int cantidadActual) {
        this.nombre = nombre;
        this.cantidadMinima = cantidadMinima;
        this.cantidadActual = cantidadActual;
    }

    public boolean tieneStock(){
        return cantidadActual >= cantidadMinima;
    }

    public void restarStock(int cantidad){
        cantidadActual -= cantidad;
    }
}
