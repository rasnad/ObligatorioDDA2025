package Controlador;

//Nota: esta va a usar el mismo controlador de Gestor, porque sólo tiene el método login

public interface VistaLoginGestor {
    
    public void loginGestor();
    
    public void mostrarError(String mensaje);

}