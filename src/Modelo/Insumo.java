package Modelo;

public class Insumo {
    String nombre;
    int cantidadActual;

    public Insumo(String nombre, int cantidadActual) {
        this.nombre = nombre;
        this.cantidadActual = cantidadActual;
    }

    public boolean tieneStock(int cantidadQueIngredienteRequiere){
        return cantidadActual >= cantidadQueIngredienteRequiere; // Verificar el mayor o igual.
    }

    public void restarStock(int cantidad){
        cantidadActual -= cantidad;
    }
}
