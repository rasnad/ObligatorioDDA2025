package Modelo;

public class Ingrediente {
    private int cantidad;
    private Insumo insumo;

    public void restarStockDeInsumo(){
        insumo.restarStock(cantidad);
    }
    
    public void devolverStockDeInsumo(){
        insumo.agregarStock(cantidad);
    }

    public Ingrediente(int cantidad, Insumo insumo) {
        this.cantidad = cantidad;
        this.insumo = insumo;
    }
    
    public boolean tieneStock(){
        /*Sólo importa si el insumo tiene stock, creo que no importa si "hay suficiente" stock - ej si el ingrediente tiene cantidad 10 y el mínimo del insumo son 5*/
        return insumo.tieneStock();
    }

    public int getCantidad() {
        return cantidad;
    }
}
