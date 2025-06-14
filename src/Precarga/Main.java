package Precarga;

import Vista.VistaDevMenu;
import Vista.VistaEscritorioDispositivo;
import Modelo.Exception.PolloException;
import Precarga.DatosDePrueba;
import Vista.VistaLoginGestor;
import Vista.VistaProcesadorPedidos;

public class Main {
    
    public static void main(String[] args) throws PolloException {
        
       DatosDePrueba.cargarDatos();
       
       VistaEscritorioDispositivo rp = new VistaEscritorioDispositivo();
       rp.setVisible(true);
       VistaEscritorioDispositivo rp2 = new VistaEscritorioDispositivo();
       rp2.setVisible(true);
       VistaEscritorioDispositivo rp3 = new VistaEscritorioDispositivo();
       rp3.setVisible(true);
       VistaDevMenu rp4 = new VistaDevMenu();
       rp4.setVisible(true);
       VistaLoginGestor rp5 = new VistaLoginGestor();
       rp5.setVisible(true);
       VistaProcesadorPedidos rp6 = new VistaProcesadorPedidos();
       rp6.setVisible(true);


    }
    
}
