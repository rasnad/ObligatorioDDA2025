package Controlador;

//Nota: esta va a usar el mismo controlador de Gestor, porque sólo tiene el método login

import Modelo.Gestor;

public interface VistaLoginGestor {
    
    public void loginGestor();
    
    public void abrirVentanaProcesar(Gestor gestor);
    
    public void mostrarError(String mensaje);

}