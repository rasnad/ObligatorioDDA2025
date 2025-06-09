package obligatorio;

public class Insumo {
    String nombre;
    int cantidadMinima;
    int cantidadActual;

    public Insumo(String aceituna, int i, int i1) {
    }

    public boolean tieneStock(){
        return cantidadActual >= cantidadMinima; // Verificar el mayor o igual.
    }

    public void restarStock(int cantidad){
        cantidadActual -= cantidad;
    }
}
