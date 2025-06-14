package Controlador;

//Nota: esta va a usar el mismo controlador de Gestor, porque sólo tiene el método login

import Modelo.Gestor;

public interface VistaLoginGestor {
    public Gestor loginGestor(String username, String password); //va a pasar el objeto Gestor a la vista ProcesarPedidos
}
