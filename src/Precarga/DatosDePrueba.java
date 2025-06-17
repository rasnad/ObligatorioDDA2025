package Precarga;

import Modelo.*;
import Modelo.TiposDeCliente.*;
import Modelo.Sistema.Fachada;
import Modelo.Exception.PolloException;

import java.util.*;

public class DatosDePrueba {

    public Menu obtenerMenuPorNombre(String nombre) {

        Menu menu = new Menu("Menu De Invierno");

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

        // Clientes
        Cliente cliente1 = new Cliente(1, new Frecuente(), "1", "Juan Nieve el Frecuente");
        Cliente cliente2 = new Cliente(2, new DeLaCasa(), "1", "Maria Becerra de la Casa");
        Cliente cliente3 = new Cliente(3, new Comun(), "1", "Pedro Comun Aristóteles");
        Cliente cliente4 = new Cliente(4, new Preferencial(), "1", "Preferencialmente Fernando");
        fachada.nuevoCliente(cliente1);
        fachada.nuevoCliente(cliente2);
        fachada.nuevoCliente(cliente3);
        fachada.nuevoCliente(cliente4);

        // Dispositivos
        Dispositivo dispositivo1 = new Dispositivo();
        Dispositivo dispositivo2 = new Dispositivo();
        Dispositivo dispositivo3 = new Dispositivo();
        Dispositivo dispositivo4 = new Dispositivo();
        fachada.nuevoDispositivo(dispositivo1);
        fachada.nuevoDispositivo(dispositivo2);
        fachada.nuevoDispositivo(dispositivo3);
        fachada.nuevoDispositivo(dispositivo4);


        // Unidades procesadoras
        UnidadProcesadora cocina = new UnidadProcesadora("Cocina");
        UnidadProcesadora bar = new UnidadProcesadora("Bar");
        //UnidadProcesadora barraDeSushi = new UnidadProcesadora("BarraDeSushi");

        // Gestores
        Gestor gestorCocina1 = new Gestor("Pedro López", "gestor1", "12345", cocina);
        fachada.nuevoGestor(gestorCocina1);
        Gestor gestorBar1 = new Gestor("PuntoExtraPorfa", "queBuenProfeTuvimos!", "12345", bar);
        fachada.nuevoGestor(gestorBar1);
        Gestor gestorCocina2 = new Gestor("Don Diego de la Vega", "a", "1", cocina);
        fachada.nuevoGestor(gestorCocina2);
        Gestor gestorBar2 = new Gestor("Batman Rodriguez", "b", "1", bar);
        fachada.nuevoGestor(gestorBar2);
        Gestor gestorCocina3 = new Gestor("Pickle Riiick", "c", "1", cocina);
        fachada.nuevoGestor(gestorCocina3);
        Gestor gestorBar3 = new Gestor("Iron Maiden", "d", "1", bar);
        fachada.nuevoGestor(gestorBar3);

        
        /*try {
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
        }/*
        
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
        Insumo aceituna = new Insumo("Aceituna", 10, 20);
        Insumo tomate = new Insumo("Tomate", 10, 20);
        Insumo papa = new Insumo("Papa", 10, 20);
        Insumo carne = new Insumo("Carne", 10, 20);
        Insumo ginebra = new Insumo("Ginebra", 10, 20);
        Insumo tonico = new Insumo("Tónico", 10, 20);
        Insumo arroz = new Insumo("Arroz", 10, 20);
        Insumo salmón = new Insumo("Salmón", 10, 20);
        Insumo alga = new Insumo("Alga", 10, 20);
        Insumo aguacate = new Insumo("Aguacate", 10, 20);
        Insumo hierbas = new Insumo("Hierbas", 10, 20);

        // Categorías
        CategoriaItem entrada = new CategoriaItem("Entrada");
        CategoriaItem platoPrincipal = new CategoriaItem("Plato Principal");
        CategoriaItem bebida = new CategoriaItem("Bebida");
        CategoriaItem sushi = new CategoriaItem("Sushi");

        //Menú
        fachada.crearMenu("Menu de Invierno");
        Menu menu = fachada.devolverMenuPorNombre("Menu de Invierno");

        //Añadir categorías
        menu.agregarCategoria(entrada);
        menu.agregarCategoria(platoPrincipal);
        menu.agregarCategoria(bebida);
        menu.agregarCategoria(sushi);
        
        // Ítems del menú

        Ingrediente ingredienteCarne = new Ingrediente(10,carne);
        Ingrediente ingredienteArroz = new Ingrediente(5,arroz);

        Ingrediente ingredienteAguacateInsuficiente = new Ingrediente(11,aguacate);
        Ingrediente ingredienteHierbasSuficiente = new Ingrediente(10,hierbas);
        Ingrediente ingredienteAguacateSuficiente = new Ingrediente(9,aguacate);

        ArrayList<Ingrediente> ingredientesMilanesas = new ArrayList<>();
        ingredientesMilanesas.add(ingredienteCarne);
        ingredientesMilanesas.add(ingredienteArroz);

        ArrayList<Ingrediente> ingredienteDeComidaConInsumoInsuficiente = new ArrayList<>();
        ingredienteDeComidaConInsumoInsuficiente.add(ingredienteAguacateInsuficiente);

        ArrayList<Ingrediente> ingredienteDeComidaConInsumoInsuficienteYUnoSuficiente = new ArrayList<>();
        ingredienteDeComidaConInsumoInsuficienteYUnoSuficiente.add(ingredienteAguacateInsuficiente);
        ingredienteDeComidaConInsumoInsuficienteYUnoSuficiente.add(ingredienteHierbasSuficiente);

        ArrayList<Ingrediente> ingredienteDeComidaConAmbosSuficientes = new ArrayList<>();
        ingredienteDeComidaConAmbosSuficientes.add(ingredienteAguacateSuficiente);
        ingredienteDeComidaConAmbosSuficientes.add(ingredienteHierbasSuficiente);

        Item milanesaConArroz = new Item(ingredientesMilanesas, cocina, platoPrincipal, "Milanesa Con Arroz", 250);
        Item pureZapalloFideo = new Item(ingredientesMilanesas, cocina, platoPrincipal, "Puré de zapallo con fideos", 250);

        Item plato1 = new Item(ingredienteDeComidaConInsumoInsuficiente, cocina, platoPrincipal, "Plato 1", 250); // No deberia verse.
        Item plato2 = new Item(ingredienteDeComidaConInsumoInsuficienteYUnoSuficiente, cocina, platoPrincipal, "Plato 2", 250); // No deberia verse.
        Item plato3 = new Item(ingredienteDeComidaConAmbosSuficientes, cocina, platoPrincipal, "Plato 3", 250);  // Deberia verse.

        // Agregando ítems a categorías

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
