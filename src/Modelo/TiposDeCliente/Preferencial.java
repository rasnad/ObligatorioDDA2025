package Modelo.TiposDeCliente;

import Modelo.Item;
import Modelo.Menu;
import Modelo.Sistema.Fachada;
import Modelo.UnidadProcesadora;
import java.util.ArrayList;

public class Preferencial extends TipoCliente {

    public Preferencial(){
        
        Menu menu = Fachada.getInstancia().devolverMenuPorNombre("Menu1");
        UnidadProcesadora bar = Fachada.getInstancia().devolverUnidadProcesadoraPorNombre("Bar");
        Item agua = new Item(new ArrayList<>(), bar, menu.devolverCategoriaPorNombre("Bebida"), "Agua mineral", 100);
        //No hay insumo ni ingrediente para el agua porque el agua es infinita desde la canilla...
        this.agregarItemConDescuento( agua );
        
    }
    
    @Override
    public float aplicarBeneficioServicio(float subtotal) {
        return subtotal > 2000 ? subtotal*0.95F : subtotal;
    }

    @Override
    public String toString(){
        return "Cliente Preferencial";
    }
}