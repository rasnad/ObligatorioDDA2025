package IURestaurante;

import obligatorio.PolloException;
import obligatorio.app.DatosDePrueba;

public class Main {
    
    public static void main(String[] args) throws PolloException {
        
       DatosDePrueba.cargarDatos();
       
       RealizarPedidos rp = new RealizarPedidos();
       rp.setVisible(true);
       
    }
    
}
