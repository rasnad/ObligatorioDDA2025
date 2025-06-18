package Modelo;

import java.util.ArrayList;

public class Menu {
    
    private String nombreMenu;
    private ArrayList<CategoriaItem> categoriaItems = new ArrayList<>();
    
    public Menu(String nombreMenu){
        this.nombreMenu = nombreMenu;
    }

    public ArrayList<CategoriaItem> getCategorias() {
        return categoriaItems;
    }

    public void setNombreMenu(String nombreMenu) {
        this.nombreMenu = nombreMenu;
    }

    public void setCategoriaItems(ArrayList<CategoriaItem> categoriaItems) {
        this.categoriaItems = categoriaItems;
    }
    
    public String getNombre(){
        return this.nombreMenu;
    }

    public void agregarCategoria(CategoriaItem categoriaItem){
        this.categoriaItems.add(categoriaItem);
    }
    
    public CategoriaItem devolverCategoriaPorNombre(String nombre){
        for (CategoriaItem c : categoriaItems){
            if (nombre.equals(c.getNombre())){
                return c;
            }
        }
        return null;
    }

}
