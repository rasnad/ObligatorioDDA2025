package Controlador;

//Nota: esta va a usar el mismo controlador de Gestor, porque sólo tiene el método login

import Modelo.Exception.PolloException;
import Modelo.Gestor;

public interface VistaLoginGestor {
    public Gestor loginGestor() throws PolloException; //va a pasar el objeto Gestor a la vista ProcesarPedidos
    public void mostrarError(String mensaje);

}
