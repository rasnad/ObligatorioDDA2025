package Modelo.TiposDeCliente;

import Modelo.Ingrediente;
import Modelo.Insumo;
import Modelo.Item;
import Modelo.Menu;
import Modelo.Sistema.Fachada;
import Modelo.UnidadProcesadora;
import java.util.ArrayList;
import java.util.List;

public class Frecuente extends TipoCliente{
    public Frecuente(){
        
        Menu menu = Fachada.getInstancia().devolverMenuPorNombre("Menu1");
        UnidadProcesadora bar = Fachada.getInstancia().devolverUnidadProcesadoraPorNombre("Bar");
        Insumo granosDeCafeInsumo = new Insumo("Granos de Café", 100, 1500);
        Ingrediente granosDeCafeIngrediente = new Ingrediente(100, granosDeCafeInsumo);
        Item cafe = new Item(new ArrayList<>(List.of(granosDeCafeIngrediente)), bar, menu.devolverCategoriaPorNombre("Bebida"), "Café", 120);
        
        this.agregarItemConDescuento( cafe );
        
    }
    
    @Override
    public String toString(){
        return "Cliente Frecuente";
    }
}
