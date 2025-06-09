package obligatorio;

import java.util.ArrayList;

public class Item {
    ArrayList<Ingrediente> ingredientes;
    UnidadProcesadora unidadProcesadora;
    CategoriaItem categoriaItem;
    String nombre;
    float precioUnitario;

    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public boolean tieneStock(){
        return false;
    }

    public void restarStockDeInsumos(){
        for(Ingrediente ingrediente : ingredientes){
            ingrediente.restarStockDeInsumo();
        }
    }

}
