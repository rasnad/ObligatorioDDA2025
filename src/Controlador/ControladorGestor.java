package Controlador;

import Modelo.*;
import Modelo.Exception.PolloException;
import Modelo.Sistema.Fachada;
import Observador.Observador;

import java.util.Observer;

public class ControladorGestor implements Observador {

    private VistaLoginGestor vista;
    private Fachada fachada = Fachada.getInstancia();

    public ControladorGestor(VistaLoginGestor vista) {
        this.vista = vista;
        fachada.agregarObservador(this);
    }

    public Gestor loginGestor(String username, String password) throws PolloException {
        try {
            return fachada.loginGestor(username, password);
        } catch (PolloException e) {
            vista.mostrarError(e.getMessage());
        }
        return null;
    }

    @Override
    public void actualizar(Object evento, Object origen) {

    }
}
