package obligatorio;

import java.util.ArrayList;

public abstract class TipoCliente {

    // String nombreDelTipo;
    ArrayList<Item> itemsConDescuento = new ArrayList<>();

    // public abstract String getNombreDelTipo();

    public float aplicarBeneficioItem(Item item){
        if(itemsConDescuento.contains(item)){
            return 0;
        }
        return item.getPrecioUnitario();
    }

    public float servicioBeneficio(float subtotal){
        return subtotal;
    }
    
    public void agregarItemConDescuento(Item item){
        itemsConDescuento.add(item);
    }
    
    public void removerItemConDescuento(Item item){
        itemsConDescuento.remove(item);
    }
}
