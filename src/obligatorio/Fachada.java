package obligatorio;

public class Fachada {

    private SubsistemaAcceso subsistemaAcceso;
    private SubsistemaServicio subsistemaServicio;

    public void loginCliente(Dispositivo dispositivo, int id, String passowrd){
        subsistemaAcceso.loginCliente(dispositivo, id, passowrd);
    }

    public void loginGestor(String username, String passowrd){
        subsistemaServicio.loginGestor(username, passowrd);
    }


}
