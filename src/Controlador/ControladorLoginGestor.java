package Controlador;

import Modelo.*;
import Modelo.Exception.PolloException;
import Modelo.Sistema.Fachada;
import Observador.Observador;

public class ControladorLoginGestor implements Observador {

    private VistaLoginGestor vistaLogin;
    private final Fachada fachada = Fachada.getInstancia();
    private Gestor gestor;

    public ControladorLoginGestor(VistaLoginGestor vista) {
        this.vistaLogin = vista;
    }
    
    //Eventos del usuario

    public void loginGestor(String username, String password) {
        try {
            Gestor gestorLogueado = fachada.loginGestor(username, password);
            this.gestor = gestorLogueado;
            vistaLogin.abrirVentanaProcesar( gestorLogueado );
        } catch (PolloException e) {
            vistaLogin.mostrarError(e.getMessage());
        }
    }

    @Override
    public void actualizar(Object evento, Object origen) {

    }
}
