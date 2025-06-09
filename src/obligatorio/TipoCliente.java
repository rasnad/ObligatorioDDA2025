package obligatorio;

import java.util.ArrayList;

public abstract class TipoCliente {

    // String nombreDelTipo;
    ArrayList<Item> itemsConDescuento;

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
}
