package obligatorio;

import java.util.ArrayList;

public class SubsistemaAcceso {

    ArrayList<Dispositivo> listDispositivos;
    ArrayList<Cliente> clientesLogueados;
    ArrayList<Cliente> clientesDeslogueados;
    ArrayList<Cliente> todosLosClientes;
    ArrayList<Gestor> todosLosGestores;    
    ArrayList<Gestor> gestoresLogueados;

    private Usuario login(ArrayList<? extends Usuario> lista, String username, String password){
        for(Usuario u : lista){
            if ( u.login(username, password)){
                return u;
            }
        }
        return null;
    }
    
    public void loginCliente(Dispositivo dispositivo, String username, String password ) {
        Cliente cliente = (Cliente) login(todosLosClientes, username, password);
        if (cliente != null) {
            clientesLogueados.add(cliente);
            dispositivo.asignarCliente(cliente);
        }
        //else throw error
    }

    public void loginGestor(String username, String password) {
        Gestor gestor = (Gestor) login(todosLosGestores, username, password);
        if (gestor != null) {
            gestoresLogueados.add(gestor);
            gestor.unidadProcesadora.loguearGestor(gestor);
        }
        //throw error
    }
    
    
    private void logout(ArrayList<? extends Usuario> lista, Usuario usuario){
        if (lista.contains(usuario)){
            lista.remove(usuario);
        }
        //else un throws
    }
    
    public void logoutCliente(Dispositivo dispositivo, Cliente cliente) {
        dispositivo.liberarCliente();
        logout(clientesLogueados, cliente);
        //else throw error
    }

        
    public void logoutGestor(Gestor gestor) {
        gestor.unidadProcesadora.desloguearGestor(gestor);
        logout(gestoresLogueados, gestor);
        //else throw error
    }
}
