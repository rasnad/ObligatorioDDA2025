package obligatorio;

import java.util.ArrayList;

public class SubsistemaAcceso {

    ArrayList<Dispositivo> listDispositivos;
    ArrayList<Cliente> clientesLogueados;
    ArrayList<Cliente> clientesDeslogueados;
    ArrayList<Cliente> todosLosClientes;
    ArrayList<Gestor> todosLosGestores;    
    ArrayList<Gestor> gestoresLogueados;

    public Usuario login(ArrayList<? extends Usuario> lista, String username, String password){
        for(Usuario u : lista){
            if ( u.login(username, password)){
                return u;
            }
        }
        return null;
    }
    
    public void loginCliente(Dispositivo dispositivo, String username, String password ) {
        Cliente cliente = (Cliente) login(todosLosClientes, password, username);
        if (cliente != null) {
            clientesLogueados.add(cliente);
            dispositivo.asignarCliente(cliente);
        }
        //else throw error
    }

    public void loginGestor(String password, String username) {
        Gestor gestor = (Gestor) login(todosLosGestores, password, username);
        if (gestor != null) {
            gestoresLogueados.add(gestor);
            gestor.unidadProcesadora.loguearGestor(gestor);
        }
        //throw error
    }
}
