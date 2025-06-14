package Modelo;

import java.util.ArrayList;

public class CategoriaItem {
    String nombre;
    ArrayList<Item> items = new ArrayList<>();

    public void validar() {
 
    }

    public void agregarItem(Item item) {
        this.items.add(item);
    }

    public void removerItem(Item item){
        this.items.remove(item);
    }

    public CategoriaItem(String nombre) {
        this.nombre = nombre;
    }
}
