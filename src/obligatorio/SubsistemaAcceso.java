package obligatorio;

import java.util.ArrayList;

public class SubsistemaAcceso {

    ArrayList<Dispositivo> listDispositivos = new ArrayList<>();
    ArrayList<Cliente> clientesLogueados = new ArrayList<>();
    ArrayList<Cliente> clientesDeslogueados = new ArrayList<>();
    ArrayList<Cliente> todosLosClientes = new ArrayList<>();
    ArrayList<Gestor> todosLosGestores = new ArrayList<>();   
    ArrayList<Gestor> gestoresLogueados = new ArrayList<>();

    private Usuario login(ArrayList<? extends Usuario> lista, String username, String password){
        for(Usuario u : lista){
            if ( u.login(username, password)){
                return u;
            }
        }
        return null;
    }
    
    public void loginCliente(Dispositivo dispositivo, String username, String password ) throws PolloException {
        Cliente cliente = (Cliente) login(todosLosClientes, username, password);
        if (cliente != null) {
            clientesLogueados.add(cliente);
            dispositivo.asignarCliente(cliente);
        } else {
            throw new PolloException("ID y/o contraseña incorrecta.");
        }
    }

    public void loginGestor(String username, String password) throws PolloException {
        Gestor gestor = (Gestor) login(todosLosGestores, username, password);
        if (gestor != null) {
            gestoresLogueados.add(gestor);
            gestor.unidadProcesadora.loguearGestor(gestor);
        } else {
            throw new PolloException("Username y/o contraseña incorrecta.");
        }
    }
    
    
    private void logout(ArrayList<? extends Usuario> lista, Usuario usuario){
        if (lista.contains(usuario)){
            lista.remove(usuario);
        }
    }
    
    public void logoutCliente(Dispositivo dispositivo, Cliente cliente) {
        dispositivo.liberarCliente();
        logout(clientesLogueados, cliente);
    }

        
    public void logoutGestor(Gestor gestor) {
        gestor.unidadProcesadora.desloguearGestor(gestor);
        logout(gestoresLogueados, gestor);
    }

    void nuevoCliente(Cliente cliente) {
        todosLosClientes.add(cliente);
    }

    void nuevoGestor(Gestor gestor) {
        todosLosGestores.add(gestor);
    }
}
