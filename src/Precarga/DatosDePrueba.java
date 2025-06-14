package Precarga;

import Modelo.*;
import Modelo.TiposDeCliente.Frecuente;
import Modelo.TiposDeCliente.DeLaCasa;
import Modelo.Sistema.Fachada;
import Modelo.Exception.PolloException;

import java.util.*;

public class DatosDePrueba {

    public Menu obtenerMenuPorNombre(String nombre) {

        Menu menu = new Menu();

        CategoriaItem entrada = new CategoriaItem("Entrada");
        CategoriaItem platoPrincipal = new CategoriaItem("Plato Principal");
        CategoriaItem bebida = new CategoriaItem("Bebida");
        CategoriaItem sushi = new CategoriaItem("Sushi");

        menu.setCategoriaItems(new ArrayList<>(List.of(entrada, platoPrincipal, bebida, sushi)));
        menu.setNombreMenu("Menu de invierno");
        if(menu.getNombre().equals(nombre)) {
            return menu;
        }
        return null;
    }

    public static void cargarDatos() throws PolloException {
        
        Fachada fachada = Fachada.getInstancia();
        Menu menu = new Menu();

        // Clientes
        Cliente cliente1 = new Cliente(1, new Frecuente(), "1234", "Juan");
        Cliente cliente2 = new Cliente(2, new DeLaCasa(), "1234", "Maria");
        fachada.nuevoCliente(cliente1);
        fachada.nuevoCliente(cliente2);

        // Dispositivos
        Dispositivo dispositivo1 = new Dispositivo();
        Dispositivo dispositivo2 = new Dispositivo();
        fachada.nuevoDispositivo(dispositivo2);
        fachada.nuevoDispositivo(dispositivo1);



        // Unidades procesadoras
        UnidadProcesadora cocina = new UnidadProcesadora();
        //UnidadProcesadora bar = new UnidadProcesadora("Bar");
        //UnidadProcesadora barraDeSushi = new UnidadProcesadora("BarraDeSushi");

        // Gestores
        Gestor gestorCocina1 = new Gestor("Pedro López", "gestor1", "12345", cocina);
        fachada.nuevoGestor(gestorCocina1);
        fachada.nuevoCliente(cliente1);
        fachada.nuevoCliente(cliente2);
        
        try {
            fachada.loginGestor("test", "test");
            System.out.println("Gestor logueado");
        } catch(PolloException p) {
            System.out.println(p);
        }
        
        try {
            fachada.loginGestor("gestor1", "12345");
            System.out.println("Gestor logueado");
        } catch(PolloException p) {
            System.out.println(p);
        }
        
        try {
            fachada.loginGestor("gestor1", "12345");
            System.out.println("Gestor logueado");
        } catch(PolloException p) {
            System.out.println(p);
        }
        
        //fachada.getGestores();
        /*
        fachada.loginCliente(dispositivo1, "1", "1234");
        fachada.loginCliente(dispositivo1, "1", "1234");
        fachada.loginCliente(dispositivo2, "1", "1234");
        fachada.loginCliente(dispositivo2, "2", "1234");
        fachada.loginCliente(dispositivo2, "1", "12345");
        fachada.loginCliente(dispositivo2, "5", "1234");
        */
         
        
        //fachada.getClientes();

        // Insumos
        Insumo aceituna = new Insumo("Aceituna", 100, 500);
        Insumo tomate = new Insumo("Tomate", 50, 200);
        Insumo papa = new Insumo("Papa", 100, 500);
        Insumo carne = new Insumo("Carne", 20, 100);
        Insumo ginebra = new Insumo("Ginebra", 10, 50);
        Insumo tonico = new Insumo("Tónico", 20, 100);
        Insumo arroz = new Insumo("Arroz", 50, 200);
        Insumo salmón = new Insumo("Salmón", 15, 75);
        Insumo alga = new Insumo("Alga", 100, 500);

        // Categorías
        CategoriaItem entrada = new CategoriaItem("Entrada");
        CategoriaItem platoPrincipal = new CategoriaItem("Plato Principal");
        CategoriaItem bebida = new CategoriaItem("Bebida");
        CategoriaItem sushi = new CategoriaItem("Sushi");

        menu.setCategoriaItems(new ArrayList<>(List.of(entrada, platoPrincipal, bebida, sushi)));
        menu.setNombreMenu("Menu de invierno");
        
        // Ítems del menú

        Ingrediente ingredienteCarne = new Ingrediente(1,carne);
        Ingrediente ingredienteArroz = new Ingrediente(1,arroz);
        ArrayList<Ingrediente> ingredientesMilanesas = new ArrayList<>();
        ingredientesMilanesas.add(ingredienteCarne);
        ingredientesMilanesas.add(ingredienteArroz);

        Item milanesaConArroz = new Item(ingredientesMilanesas, cocina, platoPrincipal, "Milanesa Con Arroz", 250);

        // Agregando ítems a categorías
        platoPrincipal.agregarItem(milanesaConArroz);

        //Gestor gestorCocina2 = new Gestor("Pedro López", "gestor1", "12345", cocina);
        //Gestor gestorCocina3 = new Gestor("Pedro López", "gestor1", "12345", cocina);

        // Agregando datos a la aplicación
        // Aquí deberías agregar los datos a tu sistema de persistencia o estructura de datos
        // Por ejemplo:
        // Sistema.getInstance().agregarUnidadProcesadora(cocina);
        // Sistema.getInstance().agregarUnidadProcesadora(bar);
        // Sistema.getInstance().agregarUnidadProcesadora(barraDeSushi);
        // Sistema.getInstance().agregarCliente(cliente1);
        // Sistema.getInstance().agregarCliente(cliente2);
        // Sistema.getInstance().agregarGestor(gestorCocina);
        // Sistema.getInstance().agregarGestor(gestorBar);
        // Sistema.getInstance().agregarGestor(gestorSushi);
        // Sistema.getInstance().agregarDispositivo(dispositivo1);
        // Sistema.getInstance().agregarDispositivo(dispositivo2);
    }
}
