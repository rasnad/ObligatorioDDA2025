package Precarga;

import Modelo.Cliente;
import Modelo.Gestor;
import Modelo.UnidadProcesadora;
import Modelo.TiposDeCliente.Frecuente;
import Modelo.CategoriaItem;
import Modelo.TiposDeCliente.DeLaCasa;
import Modelo.Dispositivo;
import Modelo.Sistema.Fachada;
import Modelo.Exception.PolloException;
import Modelo.Ingrediente;
import Modelo.Item;
import Modelo.Insumo;
import java.util.*;

public class DatosDePrueba {
    public static void cargarDatos() throws PolloException {
        
        Fachada fachada = Fachada.getInstancia();

        // Clientes
        Cliente cliente1 = new Cliente(1, new Frecuente(), "1234", "Juan");
        Cliente cliente2 = new Cliente(2, new DeLaCasa(), "1234", "Maria");

        // Dispositivos
        Dispositivo dispositivo1 = new Dispositivo();
        Dispositivo dispositivo2 = new Dispositivo();


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
        
        try {
            dispositivo1.loginCliente(1, "1234");
            System.out.println("Cliente logueado");
        } catch(PolloException p) {
            System.out.println(p);
        }
        
        try {
            dispositivo1.loginCliente(1, "1234");
            System.out.println("Cliente logueado");
        } catch(PolloException p) {
            System.out.println(p);
        }
        
        try {
            dispositivo2.loginCliente(1, "1234");
            System.out.println("Cliente logueado");
        } catch(PolloException p) {
            System.out.println(p);
        }
        
        try {
            dispositivo2.loginCliente(2, "1234");
            System.out.println("Cliente logueado");
        } catch(PolloException p) {
            System.out.println(p);
        }
        
        try {
            dispositivo2.loginCliente(1, "12345");
            System.out.println("Cliente logueado");
        } catch(PolloException p) {
            System.out.println(p);
        }
        
        try {
            dispositivo2.loginCliente(5, "1234");
            System.out.println("Cliente logueado");
        } catch(PolloException p) {
            System.out.println(p);
        }
         
         
        
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
