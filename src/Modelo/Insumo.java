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
    
    /*
    CREO que esto NO es necesario según la letra, pero lo dejo por acá por las dudas
    public boolean tieneStockPara(Ingrediente ingrediente){
        int stockRestante = cantidadActual - ingrediente.cantidad;
        return stockRestante >= cantidadMinima;
    }
    */

    public void restarStock(int cantidad){
        cantidadActual -= cantidad;
    }
    
    public void agregarStock(int cantidad){
        cantidadActual += cantidad;
    }
}
