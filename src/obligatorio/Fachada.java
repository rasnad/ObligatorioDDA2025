package obligatorio;

public class Fachada {

    private SubsistemaAcceso subsistemaAcceso;
    private SubsistemaServicio subsistemaServicio;

    public void loginCliente(Dispositivo dispositivo, String username, String password){
        subsistemaAcceso.loginCliente(dispositivo, username, password );
    }

    public void loginGestor(String username, String password){
        subsistemaAcceso.loginGestor(username, password);
    }

}
