package obligatorio;

public class Fachada {
    
    private static Fachada instancia = new Fachada();
    private SubsistemaAcceso subsistemaAcceso = new SubsistemaAcceso();
    private SubsistemaServicio subsistemaServicio = new SubsistemaServicio();
    
    //Constructor Singleton
    private Fachada(){}
    
    //Retorno de Instancia
    public static Fachada getInstancia(){
        return instancia;
    }

    public void loginCliente(Dispositivo dispositivo, String username, String password) throws PolloException {
        subsistemaAcceso.loginCliente(dispositivo, username, password );
    }

    public void loginGestor(String username, String password) throws PolloException {
        subsistemaAcceso.loginGestor(username, password);
    }
        
    public void logoutCliente(Dispositivo dispositivo, Cliente cliente){
        subsistemaAcceso.logoutCliente(dispositivo, cliente);
    }
    
    public void logoutGestor(Gestor gestor){
        subsistemaAcceso.logoutGestor(gestor);
    }
    
    public void nuevoGestor(Gestor gestor){
        subsistemaAcceso.nuevoGestor(gestor);
    }
    
    public void nuevoCliente(Cliente cliente){
        subsistemaAcceso.nuevoCliente(cliente);
    }

}
