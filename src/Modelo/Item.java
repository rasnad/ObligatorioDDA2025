package Modelo;

import java.util.ArrayList;

public class Item {
    ArrayList<Ingrediente> ingredientes = new ArrayList<>();
    UnidadProcesadora unidadProcesadora;
    CategoriaItem categoriaItem;
    String nombre;
    float precioUnitario;

    public float getPrecioUnitario() {
        return precioUnitario;
    }
    
    public UnidadProcesadora getUnidadProcesadora() {
        return unidadProcesadora;
    }
    
    public CategoriaItem getCategoriaItem(){
        return categoriaItem;
    }
    
    public final void setCategoriaItem(CategoriaItem categoriaNueva){
        if (this.categoriaItem != null){
            this.categoriaItem.removerItem(this);
        }
        
        categoriaNueva.agregarItem(this);
        categoriaItem = categoriaNueva;
    }

    public boolean tieneStock(){
        return false;
    }

    public void restarStockDeInsumos(){
        for(Ingrediente ingrediente : ingredientes){
            ingrediente.restarStockDeInsumo();
        }
    }
    
    public void agregarIngrediente(Ingrediente ingrediente){
       ingredientes.add(ingrediente);
    }
    
    public void removerIngrediente(Ingrediente ingrediente){
       ingredientes.remove(ingrediente);
    }

    public Item(ArrayList<Ingrediente> ingredientes, UnidadProcesadora unidadProcesadora, CategoriaItem categoriaItem, String nombre, float precioUnitario) {
        this.ingredientes = ingredientes;
        this.unidadProcesadora = unidadProcesadora;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.setCategoriaItem(categoriaItem);
    }
}
