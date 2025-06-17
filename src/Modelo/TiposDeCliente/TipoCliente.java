package Modelo.TiposDeCliente;

import Modelo.Item;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class TipoCliente {

    ArrayList<Item> itemsConDescuento = new ArrayList<>();

    public float aplicarBeneficioServicio(float subtotal){
        return subtotal;
    }

    public void agregarItemConDescuento(Item item){
        itemsConDescuento.add(item);
    }

    public void removerItemConDescuento(Item item){
        itemsConDescuento.remove(item);
    }

    public ArrayList<Item> getItemsConDescuento() {
        return itemsConDescuento;
    }
}
