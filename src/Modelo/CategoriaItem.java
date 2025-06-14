package Modelo;

import java.util.ArrayList;

public class CategoriaItem {
    String nombre;
    ArrayList<Item> items = new ArrayList<>();

    public void validar() {
 
    }

    public void agregarItem(Item item) {
        item.setCategoriaItem(this);
        this.items.add(item);
    }

    public CategoriaItem(String nombre) {
        this.nombre = nombre;
    }
}
