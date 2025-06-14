/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;

public class Menu {
    String nombreMenu;
    ArrayList<CategoriaItem> categoriaItems = new ArrayList<>();

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

    public Menu(String nombreMenu){
        this.nombreMenu = nombreMenu;
    }
    
}
