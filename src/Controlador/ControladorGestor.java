package Controlador;

import Modelo.*;
import Modelo.Exception.PolloException;
import Modelo.Sistema.Fachada;
import Observador.Observador;

public class ControladorGestor implements Observador {

    private VistaLoginGestor vistaLogin;
    private VistaProcesarPedidos vistaProcesar;
    private Fachada fachada = Fachada.getInstancia();
    private Gestor gestor;

    public ControladorGestor(VistaLoginGestor vista) {
        this.vistaLogin = vista;
        fachada.agregarObservador(this);
    }
    
    public void setVistaProcesar(VistaProcesarPedidos vistaNueva){
        vistaProcesar = vistaNueva;
        vistaLogin = null;
    }
    
    //Eventos del usuario
    
    public void salir(){
        fachada.quitarObservador(this);
    }

    public void loginGestor(String username, String password) {
        try {
            Gestor gestorLogueado = fachada.loginGestor(username, password);
            this.gestor = gestorLogueado;
        } catch (PolloException e) {
            vistaLogin.mostrarError(e.getMessage());
        }
    }

    @Override
    public void actualizar(Object evento, Object origen) {

    }
}
