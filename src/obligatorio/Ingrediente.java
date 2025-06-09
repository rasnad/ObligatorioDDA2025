package obligatorio;

public class Ingrediente {
    int cantidad;
    Insumo insumo;

    public void restarStockDeInsumo(){
        insumo.restarStock(cantidad);
    }
}
