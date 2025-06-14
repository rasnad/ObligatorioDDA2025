package Controlador;

import Modelo.*;
import Observador.Observador;
import Modelo.Sistema.Fachada;
import Modelo.Exception.PolloException;

public class ControladorDispositivo implements Observador {
    
    private VistaDispositivo vista;
    private Servicio servicio;
    private Dispositivo dispositivo;
    private Fachada fachada = Fachada.getInstancia();

    
    public ControladorDispositivo(VistaDispositivo vista){
        this.vista = vista;
        inicializarVista();
        dispositivo = fachada.devolverDispositivo(); //tomar un dispositivo random de la fachada
    }
    
    public String getDispositivoId(){
        return dispositivo.getId() + "";
    }
    
    //Eventos del usuario
    
    private void inicializarVista(){
        //Carga de información dinámica que necesita la vista
        //vista.mostrar( datos de inicialización );
    }
    
    public void loginCliente(String username, String password) {
        try {
            dispositivo.puedeLoguearseCliente();
            fachada.loginCliente(dispositivo, username, password);
        } catch (PolloException e){
            vista.mostrarError(e.getMessage());
        }
    }
    
    public void salir(){
        servicio.quitarObservador(this);
    }
    
    //Evento del modelo
    @Override
    public void actualizar(Object evento, Object origen) {
        //Algún evento:
        vista.mostrarServicio(servicio);
    }
     
}
