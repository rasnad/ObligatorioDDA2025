package obligatorio;

public class Ingrediente {
    int cantidad;
    Insumo insumo;

    public void restarStockDeInsumo(){
        insumo.restarStock(cantidad);
    }

    public Ingrediente(int cantidad, Insumo insumo) {
        this.cantidad = cantidad;
        this.insumo = insumo;
    }
}
