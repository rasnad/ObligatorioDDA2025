package Precarga;

import Vista.VistaEscritorioDevMenu;
import Vista.VistaEscritorioDispositivo;
import Modelo.Exception.PolloException;
import Precarga.DatosDePrueba;
import Vista.VistaEscritorioLoginGestor;
import Vista.VistaEscritorioProcesadorPedidos;

public class Main {
    
    public static void main(String[] args) throws PolloException {
        
       DatosDePrueba.cargarDatos();
       
       VistaEscritorioDispositivo rp = new VistaEscritorioDispositivo();
       rp.setVisible(true);
       VistaEscritorioDispositivo rp2 = new VistaEscritorioDispositivo();
       rp2.setVisible(true);
       VistaEscritorioDispositivo rp3 = new VistaEscritorioDispositivo();
       rp3.setVisible(true);
       VistaEscritorioDevMenu rp4 = new VistaEscritorioDevMenu();
       rp4.setVisible(true);
       VistaEscritorioLoginGestor rp5 = new VistaEscritorioLoginGestor();
       rp5.setVisible(true);
       VistaEscritorioProcesadorPedidos rp6 = new VistaEscritorioProcesadorPedidos();
       rp6.setVisible(true);


    }
    
}
