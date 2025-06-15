package Controlador;

import Modelo.*;
import Modelo.Exception.PolloException;
import Modelo.Sistema.Fachada;
import Observador.Observador;

public class ControladorGestor implements Observador {

    private VistaLoginGestor vista;
    private Fachada fachada = Fachada.getInstancia();
    private Gestor gestor;

    public ControladorGestor(VistaLoginGestor vista) {
        this.vista = vista;
        fachada.agregarObservador(this);
    }

    public void loginGestor(String username, String password) {
        try {
            Gestor gestorLogueado = fachada.loginGestor(username, password);
            this.gestor = gestorLogueado;
            vista.dispose();
            //
        } catch (PolloException e) {
            vista.mostrarError(e.getMessage());
        }
    }

    @Override
    public void actualizar(Object evento, Object origen) {

    }
}
