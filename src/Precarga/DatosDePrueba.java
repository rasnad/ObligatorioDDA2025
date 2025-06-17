package Precarga;

import Modelo.*;
import Modelo.TiposDeCliente.*;
import Modelo.Sistema.Fachada;
import Modelo.Exception.PolloException;

import java.util.*;

public class DatosDePrueba {

    public static void cargarDatos() throws PolloException {

        Fachada fachada = Fachada.getInstancia();
        
        // Unidades procesadoras
        UnidadProcesadora cocina = new UnidadProcesadora("Cocina");
        UnidadProcesadora bar = new UnidadProcesadora("Bar");
        UnidadProcesadora barraDeSushi = new UnidadProcesadora("BarraDeSushi");
        fachada.nuevaUnidadProcesadora(cocina);
        fachada.nuevaUnidadProcesadora(bar);
        fachada.nuevaUnidadProcesadora(barraDeSushi);
        
        // Categorías de menú
        CategoriaItem entrada = new CategoriaItem("Entrada");
        CategoriaItem platoPrincipal = new CategoriaItem("Plato Principal");
        CategoriaItem bebida = new CategoriaItem("Bebida");
        CategoriaItem sushi = new CategoriaItem("Sushi");

        Menu menu = new Menu("Menu1");
        menu.setCategoriaItems(new ArrayList<>(List.of(entrada, platoPrincipal, bebida, sushi)));
        fachada.agregarMenu(menu);
        
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
        Insumo pan = new Insumo("Pan", 10, 20);
        Insumo pasta = new Insumo("Pasta", 20, 30);
        
        Ingrediente ingredienteCarne = new Ingrediente(10,carne);
        Ingrediente ingredienteArroz = new Ingrediente(5,arroz);
        Ingrediente ingredienteAguacateInsuficiente = new Ingrediente(11,aguacate);
        Ingrediente ingredienteHierbasSuficiente = new Ingrediente(10,hierbas);
        Ingrediente ingredienteAguacateSuficiente = new Ingrediente(9,aguacate);
        
        //posibles ingredientes
        //carne
        //arroz
        //papa
        //huevos
        //lechuga
        //tomate
        //masa
        //queso
        
        //posibles comidas
        
        //Entradas 
        //porción de fritas (papa)
        //croquetas de arroz (arroz)
        //croquetas de papa (papa)
        //ensalada mixta (tomate, lechuga)
        
        //Principal
        //milanesa con arroz (carne, arroz)
        //milanesa con puré (carne, papa)
        //milanesa con fritas (carne, papa)
        //milanesa napolitana (carne, tomate, queso)
        //fritas con huevo frito (papa, huevo)
        //lehmeyun de carne (carne, masa)
        //lehmeyun vegetariano (tomate, lechuga, queso, masa)
        //lehmeyun vegeno (tomate, lechuga, masa)
        //empanada (carne, masa)
        //pizza (masa, tomate, queso)
        
        //Bebidas
        //coca-cola
        //sprite
        //pepsi
        //yougurt añejado
        
        //Sushi
        //ver restaurant de sushi
        
        // Ítems del menú
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

        Item milanesa = new Item(ingredientesMilanesas, cocina, platoPrincipal, "Milanesa con Arroz", 250);
        Item platoCaro = new Item(ingredientesMilanesas, cocina, platoPrincipal, "Plato Caro Especial", 2100);

        //Tipos de cliente
        Frecuente frecuente = new Frecuente(); // Café gratis
        Preferencial preferencial = new Preferencial();  // Agua gratis y 5% de descuento si la factura es más de 2000
        DeLaCasa deLaCasa = new DeLaCasa(); // 500 pesos de descuento siempre
        Comun comun = new Comun(); // Sin beneficios

        fachada.nuevoCliente( new Cliente(1, frecuente, "1", "Juan Frecuenta Cafés") );
        fachada.nuevoCliente( new Cliente(2, preferencial, "1", "Ana Prefiere Agua") );
        fachada.nuevoCliente( new Cliente(3, deLaCasa, "1", "Carlos el hijo del dueño") );
        fachada.nuevoCliente( new Cliente(4, comun, "1", "Luisa La Plebeya Sin Beneficios") );
        //Cambio de tipo de cliente (Strategy)
        Cliente clientePromovido = new Cliente(5, comun, "1", "Diego Armando Programas");
        fachada.nuevoCliente(clientePromovido);
        clientePromovido.setTipo(deLaCasa);

        // Dispositivos
        fachada.nuevoDispositivo(new Dispositivo());
        fachada.nuevoDispositivo(new Dispositivo());
        fachada.nuevoDispositivo(new Dispositivo());
        fachada.nuevoDispositivo(new Dispositivo());

        // Gestores
        fachada.nuevoGestor( new Gestor("Pedro López", "gestor1", "12345", cocina) );
        fachada.nuevoGestor( new Gestor("PuntoExtraPorfa", "queBuenProfeTuvimos!", "12345", bar) );
        fachada.nuevoGestor( new Gestor("Don Diego de la Vega", "a", "1", cocina) );
        fachada.nuevoGestor( new Gestor("Batman Rodriguez", "b", "1", bar) );
        fachada.nuevoGestor( new Gestor("Pickle Riiick", "c", "1", cocina) );
        fachada.nuevoGestor(new Gestor("Iron Maiden", "d", "1", bar) );

    }
}
