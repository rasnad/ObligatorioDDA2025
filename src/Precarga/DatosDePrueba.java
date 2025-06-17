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
        Insumo aguacate = new Insumo("Aguacate", 10, 200);
        Insumo hierbas = new Insumo("Hierbas", 10, 200);

        // Categorías
        CategoriaItem entrada = new CategoriaItem("Entrada");
        CategoriaItem platoPrincipal = new CategoriaItem("Plato Principal");
        CategoriaItem bebida = new CategoriaItem("Bebida");
        CategoriaItem sushi = new CategoriaItem("Sushi");

        
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


        // Unidades procesadoras

        UnidadProcesadora cocina = new UnidadProcesadora("Cocina");
        UnidadProcesadora bar = new UnidadProcesadora("Bar");
        UnidadProcesadora barraDeSushi = new UnidadProcesadora("BarraDeSushi");


        Item cafe = new Item(new ArrayList<>(), bar, bebida, "Café", 120);
        Item aguaMineral = new Item(new ArrayList<>(), bar, bebida, "Agua Mineral", 100);
        Item milanesa = new Item(ingredientesMilanesas, cocina, platoPrincipal, "Milanesa con Arroz", 250);
        Item platoCaro = new Item(ingredientesMilanesas, cocina, platoPrincipal, "Plato Caro Especial", 2100);

        Frecuente frecuente = new Frecuente();
        frecuente.setItemsConDescuento(new ArrayList<> (List.of(cafe)));

        Preferencial preferencial = new Preferencial();
        preferencial.setItemsConDescuento(new ArrayList<> (List.of(aguaMineral)));

        DeLaCasa deLaCasa = new DeLaCasa(); // No requiere items específicos, tiene crédito global

        Comun comun = new Comun(); // Sin beneficios

        Cliente clienteFrecuente = new Cliente(1, frecuente, "1", "Juan Café");
        Cliente clientePreferencial = new Cliente(2, preferencial, "1", "Ana Agua");
        Cliente clienteDeLaCasa = new Cliente(3, deLaCasa, "1", "Carlos VIP");
        Cliente clienteComun = new Cliente(4, comun, "1", "Luisa Sin Beneficio");

        // Dispositivos
        Dispositivo dispositivo1 = new Dispositivo();
        Dispositivo dispositivo2 = new Dispositivo();

        // FACHADA !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        Fachada fachada = Fachada.getInstancia();

        //Menú

        fachada.crearMenu("Menu de Invierno");
        Menu menu = fachada.devolverMenuPorNombre("Menu de Invierno");

        //Añadir categorías
        menu.agregarCategoria(entrada);
        menu.agregarCategoria(platoPrincipal);
        menu.agregarCategoria(bebida);
        menu.agregarCategoria(sushi);

        // Clientes

        fachada.nuevoCliente(clienteFrecuente);
        fachada.nuevoCliente(clientePreferencial);
        fachada.nuevoCliente(clienteDeLaCasa);
        fachada.nuevoCliente(clienteComun);

        // Gestores
        fachada.nuevoDispositivo(dispositivo2);
        fachada.nuevoDispositivo(dispositivo1);

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

    }
}
