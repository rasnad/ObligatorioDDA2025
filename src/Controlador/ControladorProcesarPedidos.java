package Controlador;

import Modelo.Gestor;
import Modelo.Sistema.Fachada;
import Observador.Observador;

public class ControladorProcesarPedidos implements Observador {

    VistaProcesarPedidos vista;
    private final Fachada fachada = Fachada.getInstancia();
    private Gestor gestor;
    
    public ControladorProcesarPedidos(Gestor gestor, VistaProcesarPedidos vista){
        this.vista = vista;
        this.gestor = gestor;
        inicializarVista();
        fachada.agregarObservador(this);
    }
    
    //Eventos del Usuario
    
    public void inicializarVista(){
        vista.mostrarInfoGestor(gestor.getNombreCompleto(), gestor.getUnidadProcesadora().getNombre());
        vista.mostrarPedidosConfirmados(gestor.getUnidadProcesadora().getPedidos());
    }
    
    public void salir(){
        fachada.quitarObservador(this);
    }
    
    public void logoutGestor(){
        fachada.logoutGestor(gestor);
    }
    
    //Eventos del Modelo
    
    @Override
    public void actualizar(Object evento, Object origen) {
        
        if (evento.equals(Fachada.eventos.estadoDePedidoActualizado) ){
            vista.mostrarPedidosConfirmados(gestor.getUnidadProcesadora().getPedidos());
        }
        //vista.mostrarMonto(); //evento montoActualizado
        //vista.mostrarMensaje(); //evento nuevoMensaje
        }
    
}
