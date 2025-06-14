package Precarga;

import Modelo.*;
import Modelo.EstadosDePedido.Pedido;
import Modelo.TiposDeCliente.Frecuente;
import Modelo.TiposDeCliente.DeLaCasa;
import Modelo.Sistema.Fachada;
import Modelo.Exception.PolloException;

import java.util.*;

public class DatosDePrueba {
    public static void cargarDatos() throws PolloException {
        
        Fachada fachada = Fachada.getInstancia();

        // Clientes
        Cliente cliente1 = new Cliente(1, new Frecuente(), "1234", "Juan");
        Cliente cliente2 = new Cliente(2, new DeLaCasa(), "1234", "Maria");
        Cliente cliente3 = new Cliente(3, new Frecuente(), "1234", "Pedro");
        Cliente cliente4 = new Cliente(4, new DeLaCasa(), "1234", "Lucia");
        Cliente cliente5 = new Cliente(5, new Frecuente(), "1234", "Ana");
        Cliente cliente6 = new Cliente(6, new DeLaCasa(), "1234", "Carlos");

        // Dispositivos
        Dispositivo dispositivo1 = new Dispositivo();
        Dispositivo dispositivo2 = new Dispositivo();
        Dispositivo dispositivo3 = new Dispositivo();
        Dispositivo dispositivo4 = new Dispositivo();
        Dispositivo dispositivo5 = new Dispositivo();

        // Unidades procesadoras
        UnidadProcesadora cocina = new UnidadProcesadora("cocina");
        UnidadProcesadora bar = new UnidadProcesadora("bar");
        UnidadProcesadora barraDeSushi = new UnidadProcesadora("barraDeSushi");

        // Gestores
        Gestor gestorCocina = new Gestor("Pedro López", "gestorCocina", "12345", cocina);
        Gestor gestorBar = new Gestor("Ana Torres", "gestorBar", "abcde", bar);
        Gestor gestorSushi = new Gestor("Mika Tanaka", "gestorSushi", "sushi123", barraDeSushi);
        fachada.nuevoGestor(gestorCocina);
        fachada.nuevoGestor(gestorBar);
        fachada.nuevoGestor(gestorSushi);
        fachada.nuevoCliente(cliente1);
        fachada.nuevoCliente(cliente2);
        fachada.nuevoCliente(cliente3);
        fachada.nuevoCliente(cliente4);
        fachada.nuevoCliente(cliente5);
        fachada.nuevoCliente(cliente6);

        try {
            fachada.loginGestor("gestorCocina", "12345");
            System.out.println("Gestor logueado");
        } catch(PolloException p) {
            System.out.println(p);
        }
        try {
            fachada.loginGestor("gestorCocina", "12345");
            System.out.println("Gestor logueado");
        } catch(PolloException p) {
            System.out.println(p);
        }

        fachada.logoutGestor(gestorCocina);
        System.out.println("Gestor Deslogueado");

        try {
            fachada.loginGestor("gestorCocina", "12345");
            System.out.println("Gestor logueado");
        } catch(PolloException p) {
            System.out.println(p);
        }
        try {
            fachada.loginGestor("USERNAME-ERRONEO", "PASSWORD-ERRONEA");
            System.out.println("Gestor Logueado");
        } catch(PolloException p) {
            System.out.println(p);
        }

        try {
            fachada.loginGestor("gestorBar", "abcde");
            System.out.println("Gestor logueado");
        } catch(PolloException p) {
            System.out.println(p);
        }

        try {
            fachada.loginGestor("gestorSushi", "sushi123");
            System.out.println("Gestor logueado");
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
        // Servicio
        Servicio servicio1 = new Servicio(cliente1, dispositivo1);

        // Insumos
        Insumo aceituna = new Insumo("Aceituna", 100, 500);
        Insumo tomate = new Insumo("Tomate", 50, 200);
        Insumo papa = new Insumo("Papa", 100, 500);
        Insumo carne = new Insumo("Carne", 20, 100);
        Insumo pollo = new Insumo("Pollo", 30, 120);
        Insumo huevo = new Insumo("Huevo", 60, 300);
        Insumo pan = new Insumo("Pan", 80, 400);
        Insumo lechuga = new Insumo("Lechuga", 40, 200);
        Insumo queso = new Insumo("Queso", 70, 250);
        Insumo ginebra = new Insumo("Ginebra", 10, 50);
        Insumo tonico = new Insumo("Tónico", 20, 100);
        Insumo arroz = new Insumo("Arroz", 50, 200);
        Insumo salmon = new Insumo("Salmón", 15, 75);
        Insumo alga = new Insumo("Alga", 100, 500);
        Insumo azucar = new Insumo("Azúcar", 90, 300);
        Insumo cacao = new Insumo("Cacao", 60, 200);

        // Categorías
        CategoriaItem entrada = new CategoriaItem("Entrada");
        CategoriaItem platoPrincipal = new CategoriaItem("Plato Principal");
        CategoriaItem bebida = new CategoriaItem("Bebida");
        CategoriaItem sushi = new CategoriaItem("Sushi");
        CategoriaItem postre = new CategoriaItem("Postre");

        // Ingredientes y ítems del menú
        ArrayList<Ingrediente> ingredientesMilanesas = new ArrayList<>();
        ingredientesMilanesas.add(new Ingrediente(1, carne));
        ingredientesMilanesas.add(new Ingrediente(1, arroz));
        Item milanesaConArroz = new Item(ingredientesMilanesas, cocina, platoPrincipal, "Milanesa Con Arroz", 250);

        ArrayList<Ingrediente> ingredientesEnsalada = new ArrayList<>();
        ingredientesEnsalada.add(new Ingrediente(1, lechuga));
        ingredientesEnsalada.add(new Ingrediente(1, tomate));
        ingredientesEnsalada.add(new Ingrediente(1, huevo));
        Item ensaladaMixta = new Item(ingredientesEnsalada, cocina, entrada, "Ensalada Mixta", 150);

        ArrayList<Ingrediente> ingredientesSushi = new ArrayList<>();
        ingredientesSushi.add(new Ingrediente(1, salmon));
        ingredientesSushi.add(new Ingrediente(1, arroz));
        ingredientesSushi.add(new Ingrediente(1, alga));
        Item sushiRoll = new Item(ingredientesSushi, barraDeSushi, sushi, "Sushi Roll", 400);

        ArrayList<Ingrediente> ingredientesGinTonic = new ArrayList<>();
        ingredientesGinTonic.add(new Ingrediente(1, ginebra));
        ingredientesGinTonic.add(new Ingrediente(1, tonico));
        Item ginTonic = new Item(ingredientesGinTonic, bar, bebida, "Gin Tonic", 180);

        ArrayList<Ingrediente> ingredientesTorta = new ArrayList<>();
        ingredientesTorta.add(new Ingrediente(1, azucar));
        ingredientesTorta.add(new Ingrediente(1, huevo));
        ingredientesTorta.add(new Ingrediente(1, cacao));
        Item tortaChocolate = new Item(ingredientesTorta, cocina, postre, "Torta de Chocolate", 220);

        // Agregar ítems a categorías
        platoPrincipal.agregarItem(milanesaConArroz);
        entrada.agregarItem(ensaladaMixta);
        sushi.agregarItem(sushiRoll);
        bebida.agregarItem(ginTonic);
        postre.agregarItem(tortaChocolate);

        // (Opcional) Agregar dispositivos y unidades al sistema si corresponde
        // Sistema.getInstance().agregarUnidadProcesadora(cocina);
        // Sistema.getInstance().agregarUnidadProcesadora(bar);
        // Sistema.getInstance().agregarUnidadProcesadora(barraDeSushi);
        // Sistema.getInstance().agregarCliente(cliente1);
        // ...
        // Sistema.getInstance().agregarDispositivo(dispositivo1);
        // ...

        // Flujo correcto

        // Agregamos 3 items a nuestro servicio.
        servicio1.agregarItemsAlServicio(milanesaConArroz);
        servicio1.agregarItemsAlServicio(ensaladaMixta);
        servicio1.agregarItemsAlServicio(sushiRoll);

        // Posibilidad de agregar comentario x item
        servicio1.agregarComentarioAlItem(milanesaConArroz, "La quiero bastante tierna, gracias papu");


        try {
            fachada.nuevoPedido(servicio1);
            System.out.println("Pedido generado con exito, platos :");
            int i = 1;
            for (Item item : servicio1.getItems().keySet()) {
                System.out.println("Item " + item.getNombre() + ", UnidadProcesadora" + item.getUnidadProcesadora() + ", precio " + item.getPrecioUnitario());
                i++;
            }
            System.out.println("");
            int j = 1;
            for (Pedido pedido : servicio1.getPedidos()) {
                System.out.println("Pedido " + pedido.getItem().getNombre() + ", Gestor" + pedido.getGestor() + ", " + "Estado " + pedido.getEstado()); // O personaliza el toString
                j++;
            }
        } catch(PolloException p) {
            System.out.println(p);
        }



    }
}
