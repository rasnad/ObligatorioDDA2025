package obligatorio;

public class Fachada {
    
    private static Fachada instancia = new Fachada();
    private SubsistemaAcceso subsistemaAcceso;
    private SubsistemaServicio subsistemaServicio;
    
    //Constructor Singleton
    private Fachada(){}
    
    //Retorno de Instancia
    public static Fachada getInstancia(){
        return instancia;
    }

    public void loginCliente(Dispositivo dispositivo, String username, String password){
        subsistemaAcceso.loginCliente(dispositivo, username, password );
    }

    public void loginGestor(String username, String password){
        subsistemaAcceso.loginGestor(username, password);
    }
        
    public void logoutCliente(Dispositivo dispositivo, Cliente cliente){
        subsistemaAcceso.logoutCliente(dispositivo, cliente);
    }
    
    public void logoutGestor(Gestor gestor){
        subsistemaAcceso.logoutGestor(gestor);
    }

}
