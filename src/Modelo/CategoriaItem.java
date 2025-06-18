package Modelo;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class CategoriaItem {
    private String nombre;
    private ArrayList<Item> items = new ArrayList<>();

    public String getNombre() {
        return this.nombre;
    }

    public void agregarItem(Item item) {
        if (!items.contains(item)){
            this.items.add(item);
        }
    }

    public void removerItem(Item item){
        this.items.remove(item);
    }

    public CategoriaItem(String nombre) {
        this.nombre = nombre;
    }
    
    public ArrayList<Item> getItems(){
        return this.items;
    }

    public ArrayList<Item> getItemsConStock(){
        return items.stream().filter(item -> item.tieneStock()).collect(Collectors.toCollection(ArrayList::new));
    }
    
    @Override
    public String toString(){
        return this.nombre;
    }
}
