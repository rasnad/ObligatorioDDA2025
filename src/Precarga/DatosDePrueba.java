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
        
        
        // === INSUMOS ===
        Insumo carne = new Insumo("Carne vacuna", 10, 50);
        Insumo tomate = new Insumo("Tomate", 10, 30);
        Insumo lechuga = new Insumo("Lechuga", 10, 20);
        Insumo pan = new Insumo("Pan", 10, 40);
        Insumo arroz = new Insumo("Arroz", 10, 25);
        Insumo algaNori = new Insumo("Alga Nori", 5, 20);
        Insumo salmon = new Insumo("Salmón fresco", 5, 15);
        Insumo quesoCrema = new Insumo("Queso crema", 5, 10);
        Insumo huevo = new Insumo("Huevo", 10, 30);
        Insumo vodka = new Insumo("Vodka", 5, 10);
        Insumo jugoNaranja = new Insumo("Jugo de naranja", 10, 15);
        Insumo limon = new Insumo("Limón", 10, 25);
        Insumo menta = new Insumo("Menta fresca", 5, 10);
        Insumo arrozGohan = new Insumo("Arroz Gohan", 10, 25);
        Insumo atun = new Insumo("Atún rojo", 5, 10);
        Insumo wasabi = new Insumo("Wasabi", 5, 10);

        // === ITEMS COCINA ===
        // Entrada - Ensalada mixta
        Ingrediente lechugaEnsalada = new Ingrediente(2, lechuga);
        Ingrediente tomateEnsalada = new Ingrediente(1, tomate);
        Ingrediente huevoEnsalada = new Ingrediente(1, huevo);
        ArrayList<Ingrediente> ingEnsalada = new ArrayList<>();
        ingEnsalada.add(lechugaEnsalada);
        ingEnsalada.add(tomateEnsalada);
        ingEnsalada.add(huevoEnsalada);
        Item ensaladaMixta = new Item(ingEnsalada, cocina, entrada, "Ensalada Mixta", 180);
        
        // Entrada - Bruschetta
        Insumo panBrus = new Insumo("Pan rústico", 10, 20);
        Insumo ajo = new Insumo("Ajo", 5, 15);
        Insumo aceiteOliva = new Insumo("Aceite de oliva", 5, 15);
        Ingrediente panBrusIng = new Ingrediente(1, panBrus);
        Ingrediente ajoBrus = new Ingrediente(1, ajo);
        Ingrediente aceiteBrus = new Ingrediente(1, aceiteOliva);
        ArrayList<Ingrediente> ingBrus = new ArrayList<>();
        ingBrus.add(panBrusIng);
        ingBrus.add(ajoBrus);
        ingBrus.add(aceiteBrus);
        Item bruschetta = new Item(ingBrus, cocina, entrada, "Bruschetta", 160);

        // Entrada - Croquetas de arroz
        Insumo queso = new Insumo("Queso rallado", 5, 15);
        Ingrediente arrozCroq = new Ingrediente(1, arroz);
        Ingrediente quesoCroq = new Ingrediente(1, queso);
        Ingrediente huevoCroq = new Ingrediente(1, huevo);
        ArrayList<Ingrediente> ingCroq = new ArrayList<>();
        ingCroq.add(arrozCroq);
        ingCroq.add(quesoCroq);
        ingCroq.add(huevoCroq);
        Item croquetasArroz = new Item(ingCroq, cocina, entrada, "Croquetas de arroz", 190);

        // Entrada - Sopa de tomate
        Insumo cebolla = new Insumo("Cebolla", 10, 25);
        Ingrediente tomateSopa = new Ingrediente(2, tomate);
        Ingrediente cebollaSopa = new Ingrediente(1, cebolla);
        ArrayList<Ingrediente> ingSopa = new ArrayList<>();
        ingSopa.add(tomateSopa);
        ingSopa.add(cebollaSopa);
        Item sopaTomate = new Item(ingSopa, cocina, entrada, "Sopa de Tomate", 170);

        // Plato Principal - Hamburguesa completa
        Ingrediente carneHamb = new Ingrediente(1, carne);
        Ingrediente tomateHamb = new Ingrediente(1, tomate);
        Ingrediente panHamb = new Ingrediente(1, pan);
        Ingrediente lechugaHamb = new Ingrediente(1, lechuga);
        ArrayList<Ingrediente> ingHamb = new ArrayList<>();
        ingHamb.add(carneHamb);
        ingHamb.add(tomateHamb);
        ingHamb.add(panHamb);
        ingHamb.add(lechugaHamb);
        Item hamburguesa = new Item(ingHamb, cocina, platoPrincipal, "Hamburguesa Completa", 320);
        
        // Plato Principal - Milanesas con papas
        Insumo panRallado = new Insumo("Pan rallado", 10, 20);
        Insumo papa = new Insumo("Papa", 10, 30);
        Ingrediente carneMil = new Ingrediente(1, carne);
        Ingrediente panMil = new Ingrediente(1, panRallado);
        Ingrediente papaMil = new Ingrediente(2, papa);
        ArrayList<Ingrediente> ingMil = new ArrayList<>();
        ingMil.add(carneMil);
        ingMil.add(panMil);
        ingMil.add(papaMil);
        Item milanesa = new Item(ingMil, cocina, platoPrincipal, "Milanesas con papas", 350);

        // Plato Principal - Omelette de vegetales
        Ingrediente huevoOme = new Ingrediente(2, huevo);
        Ingrediente tomateOme = new Ingrediente(1, tomate);
        Ingrediente cebollaOme = new Ingrediente(1, cebolla);
        ArrayList<Ingrediente> ingOme = new ArrayList<>();
        ingOme.add(huevoOme);
        ingOme.add(tomateOme);
        ingOme.add(cebollaOme);
        Item omelette = new Item(ingOme, cocina, platoPrincipal, "Omelette de vegetales", 290);

        // Plato Principal - Arroz primavera
        Insumo zanahoria = new Insumo("Zanahoria", 10, 20);
        Ingrediente arrozPrim = new Ingrediente(1, arroz);
        Ingrediente zanahPrim = new Ingrediente(1, zanahoria);
        Ingrediente huevoPrim = new Ingrediente(1, huevo);
        ArrayList<Ingrediente> ingPrim = new ArrayList<>();
        ingPrim.add(arrozPrim);
        ingPrim.add(zanahPrim);
        ingPrim.add(huevoPrim);
        Item arrozPrimavera = new Item(ingPrim, cocina, platoPrincipal, "Arroz primavera", 310);

        // === ITEMS BARRA DE SUSHI ===
        // Sushi - Philadelphia Roll
        Ingrediente arrozPhil = new Ingrediente(1, arroz);
        Ingrediente algaPhil = new Ingrediente(1, algaNori);
        Ingrediente salmonPhil = new Ingrediente(1, salmon);
        Ingrediente quesoPhil = new Ingrediente(1, quesoCrema);
        ArrayList<Ingrediente> ingPhil = new ArrayList<>();
        ingPhil.add(arrozPhil);
        ingPhil.add(algaPhil);
        ingPhil.add(salmonPhil);
        ingPhil.add(quesoPhil);
        Item phillyRoll = new Item(ingPhil, barraDeSushi, sushi, "Philadelphia Roll", 450);

        // Sushi - Atún clásico
        Ingrediente arrozAtun = new Ingrediente(1, arrozGohan);
        Ingrediente algaAtun = new Ingrediente(1, algaNori);
        Ingrediente atunAtun = new Ingrediente(1, atun);
        Ingrediente wasabiAtun = new Ingrediente(1, wasabi);
        ArrayList<Ingrediente> ingAtun = new ArrayList<>();
        ingAtun.add(arrozAtun);
        ingAtun.add(algaAtun);
        ingAtun.add(atunAtun);
        ingAtun.add(wasabiAtun);
        Item atunClassic = new Item(ingAtun, barraDeSushi, sushi, "Sushi Clásico de Atún", 420);
        
        // Sushi - California Roll
        Insumo palta = new Insumo("Palta", 5, 10);
        Insumo cangrejo = new Insumo("Kanikama", 5, 10);
        Ingrediente arrozCal = new Ingrediente(1, arroz);
        Ingrediente paltaCal = new Ingrediente(1, palta);
        Ingrediente cangrejoCal = new Ingrediente(1, cangrejo);
        Ingrediente algaCal = new Ingrediente(1, algaNori);
        ArrayList<Ingrediente> ingCal = new ArrayList<>();
        ingCal.add(arrozCal);
        ingCal.add(paltaCal);
        ingCal.add(cangrejoCal);
        ingCal.add(algaCal);
        Item californiaRoll = new Item(ingCal, barraDeSushi, sushi, "California Roll", 430);

        // Sushi - Nigiri de salmón
        Ingrediente arrozNigiri = new Ingrediente(1, arrozGohan);
        Ingrediente salmonNigiri = new Ingrediente(1, salmon);
        ArrayList<Ingrediente> ingNigiri = new ArrayList<>();
        ingNigiri.add(arrozNigiri);
        ingNigiri.add(salmonNigiri);
        Item nigiriSalmon = new Item(ingNigiri, barraDeSushi, sushi, "Nigiri de Salmón", 390);

        // Sushi - Roll Veggie
        Ingrediente arrozVeggie = new Ingrediente(1, arroz);
        Ingrediente zanahoriaVeg = new Ingrediente(1, zanahoria);
        Ingrediente paltaVeg = new Ingrediente(1, palta);
        Ingrediente algaVeg = new Ingrediente(1, algaNori);
        ArrayList<Ingrediente> ingVeg = new ArrayList<>();
        ingVeg.add(arrozVeggie);
        ingVeg.add(zanahoriaVeg);
        ingVeg.add(paltaVeg);
        ingVeg.add(algaVeg);
        Item veggieRoll = new Item(ingVeg, barraDeSushi, sushi, "Roll Veggie", 400);

        // === ITEMS BAR ===
        // Bebida - Screwdriver
        Ingrediente vodkaScrew = new Ingrediente(1, vodka);
        Ingrediente jugoScrew = new Ingrediente(1, jugoNaranja);
        ArrayList<Ingrediente> ingScrew = new ArrayList<>();
        ingScrew.add(vodkaScrew);
        ingScrew.add(jugoScrew);
        Item screwdriver = new Item(ingScrew, bar, bebida, "Screwdriver", 200);

        // Bebida - Mojito
        Ingrediente limonMojito = new Ingrediente(1, limon);
        Ingrediente mentaMojito = new Ingrediente(2, menta);
        Ingrediente vodkaMojito = new Ingrediente(1, vodka); // Reutilizando insumo vodka
        ArrayList<Ingrediente> ingMojito = new ArrayList<>();
        ingMojito.add(limonMojito);
        ingMojito.add(mentaMojito);
        ingMojito.add(vodkaMojito);
        Item mojito = new Item(ingMojito, bar, bebida, "Mojito", 230);
        
        // === INSUMOS HAYPOCO ===
        Insumo hayPocoCarne = new Insumo("Carne vacuna (hay poco)", 10, 15);
        Insumo hayPocoQueso = new Insumo("Queso cheddar (hay poco)", 10, 15);
        Insumo hayPocoPan = new Insumo("Pan artesanal (hay poco)", 10, 15);
        Insumo hayPocoArroz = new Insumo("Arroz japonés (hay poco)", 10, 15);
        Insumo hayPocoAlga = new Insumo("Alga nori (hay poco)", 10, 15);
        Insumo hayPocoAtun = new Insumo("Atún rojo (hay poco)", 10, 15);

        // === INGREDIENTES HAYPOCO ===
        // Item: hayPocoMilanesa (Plato Principal)
        Ingrediente hayPocoCarneIng = new Ingrediente(3, hayPocoCarne);
        Ingrediente hayPocoPanIng = new Ingrediente(2, hayPocoPan);
        Ingrediente hayPocoQuesoIng = new Ingrediente(2, hayPocoQueso);
        ArrayList<Ingrediente> ingHayPocoMilanesa = new ArrayList<>();
        ingHayPocoMilanesa.add(hayPocoCarneIng);
        ingHayPocoMilanesa.add(hayPocoPanIng);
        ingHayPocoMilanesa.add(hayPocoQuesoIng);
        Item hayPocoMilanesa = new Item(ingHayPocoMilanesa, cocina, platoPrincipal, "hayPocoMilanesa", 340);

        // Item: hayPocoAtunRoll (Sushi)
        Ingrediente hayPocoArrozIng = new Ingrediente(2, hayPocoArroz);
        Ingrediente hayPocoAlgaIng = new Ingrediente(1, hayPocoAlga);
        Ingrediente hayPocoAtunIng = new Ingrediente(2, hayPocoAtun);
        ArrayList<Ingrediente> ingHayPocoAtun = new ArrayList<>();
        ingHayPocoAtun.add(hayPocoArrozIng);
        ingHayPocoAtun.add(hayPocoAlgaIng);
        ingHayPocoAtun.add(hayPocoAtunIng);
        Item hayPocoAtunRoll = new Item(ingHayPocoAtun, barraDeSushi, sushi, "hayPocoAtunRoll", 460);
        
        // INSUMOS
        Insumo hayPocoPollo = new Insumo("Pollo (hay poco)", 10, 15);
        Insumo hayPocoPimiento = new Insumo("Pimiento rojo (hay poco)", 10, 15);
        Insumo hayPocoTortilla = new Insumo("Tortilla de trigo (hay poco)", 10, 15);

        // INGREDIENTES
        Ingrediente hayPocoPolloIng = new Ingrediente(3, hayPocoPollo);
        Ingrediente hayPocoPimientoIng = new Ingrediente(2, hayPocoPimiento);
        Ingrediente hayPocoTortillaIng = new Ingrediente(2, hayPocoTortilla);

        ArrayList<Ingrediente> ingHayPocoFajitas = new ArrayList<>();
        ingHayPocoFajitas.add(hayPocoPolloIng);
        ingHayPocoFajitas.add(hayPocoPimientoIng);
        ingHayPocoFajitas.add(hayPocoTortillaIng);
        Item hayPocoFajitas = new Item(ingHayPocoFajitas, cocina, platoPrincipal, "hayPocoFajitas", 360);
        
        // INSUMOS
        Insumo hayPocoCachaca = new Insumo("Cachaça (hay poco)", 10, 15);
        Insumo hayPocoAzucar = new Insumo("Azúcar (hay poco)", 10, 15);
        Insumo hayPocoLimon = new Insumo("Limón verde (hay poco)", 10, 15);
        Insumo hayPocoGinebra = new Insumo("Ginebra (hay poco)", 10, 15);
        Insumo hayPocoVermouth = new Insumo("Vermouth rojo (hay poco)", 10, 15);
        Insumo hayPocoCampari = new Insumo("Campari (hay poco)", 10, 15);

        // hayPocoCaipirinha
        Ingrediente ingCachaca = new Ingrediente(2, hayPocoCachaca);
        Ingrediente ingAzucar = new Ingrediente(1, hayPocoAzucar);
        Ingrediente ingLimon = new Ingrediente(2, hayPocoLimon);
        ArrayList<Ingrediente> ingHayPocoCaipirinha = new ArrayList<>();
        ingHayPocoCaipirinha.add(ingCachaca);
        ingHayPocoCaipirinha.add(ingAzucar);
        ingHayPocoCaipirinha.add(ingLimon);
        Item hayPocoCaipirinha = new Item(ingHayPocoCaipirinha, bar, bebida, "hayPocoCaipirinha", 240);

        // hayPocoNegroni
        Ingrediente ingGinebra = new Ingrediente(1, hayPocoGinebra);
        Ingrediente ingVermouth = new Ingrediente(1, hayPocoVermouth);
        Ingrediente ingCampari = new Ingrediente(1, hayPocoCampari);
        ArrayList<Ingrediente> ingHayPocoNegroni = new ArrayList<>();
        ingHayPocoNegroni.add(ingGinebra);
        ingHayPocoNegroni.add(ingVermouth);
        ingHayPocoNegroni.add(ingCampari);
        Item hayPocoNegroni = new Item(ingHayPocoNegroni, bar, bebida, "hayPocoNegroni", 260);
        
        // INSUMOS
        Insumo hayPocoLangostino = new Insumo("Langostino tempura (hay poco)", 10, 15);
        Insumo hayPocoHarina = new Insumo("Harina para tempura (hay poco)", 10, 15);
        Insumo hayPocoSriracha = new Insumo("Salsa Sriracha (hay poco)", 10, 15);
        Insumo hayPocoPepino = new Insumo("Pepino (hay poco)", 10, 15);

        // hayPocoTempuraRoll
        Ingrediente ingArrozTempura = new Ingrediente(2, hayPocoArroz);
        Ingrediente ingLangostino = new Ingrediente(2, hayPocoLangostino);
        Ingrediente ingHarina = new Ingrediente(1, hayPocoHarina);
        Ingrediente ingAlgaTempura = new Ingrediente(1, hayPocoAlga);
        ArrayList<Ingrediente> ingHayPocoTempura = new ArrayList<>();
        ingHayPocoTempura.add(ingArrozTempura);
        ingHayPocoTempura.add(ingLangostino);
        ingHayPocoTempura.add(ingHarina);
        ingHayPocoTempura.add(ingAlgaTempura);
        Item hayPocoTempuraRoll = new Item(ingHayPocoTempura, barraDeSushi, sushi, "hayPocoTempuraRoll", 470);

        // hayPocoSpicyTuna
        Ingrediente ingAtunSpicy = new Ingrediente(2, hayPocoAtun);
        Ingrediente ingSriracha = new Ingrediente(1, hayPocoSriracha);
        Ingrediente ingPepino = new Ingrediente(1, hayPocoPepino);
        Ingrediente ingArrozSpicy = new Ingrediente(2, hayPocoArroz);
        ArrayList<Ingrediente> ingHayPocoSpicy = new ArrayList<>();
        ingHayPocoSpicy.add(ingAtunSpicy);
        ingHayPocoSpicy.add(ingSriracha);
        ingHayPocoSpicy.add(ingPepino);
        ingHayPocoSpicy.add(ingArrozSpicy);
        Item hayPocoSpicyTuna = new Item(ingHayPocoSpicy, barraDeSushi, sushi, "hayPocoSpicyTuna", 480);

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
