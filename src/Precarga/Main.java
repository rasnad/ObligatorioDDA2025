package Precarga;

import Vista.VistaEscritorioDispositivo;
import Modelo.Exception.PolloException;
import Precarga.DatosDePrueba;

public class Main {
    
    public static void main(String[] args) throws PolloException {
        
       DatosDePrueba.cargarDatos();
       
       VistaEscritorioDispositivo rp = new VistaEscritorioDispositivo();
       rp.setVisible(true);
       VistaEscritorioDispositivo rp2 = new VistaEscritorioDispositivo();
       rp2.setVisible(true);
       VistaEscritorioDispositivo rp3 = new VistaEscritorioDispositivo();
       rp3.setVisible(true);
       
    }
    
}
