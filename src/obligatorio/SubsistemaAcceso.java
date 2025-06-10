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
        
        if (cliente == null) {
            throw new PolloException("Credenciales incorrectas.");
        }
        
        if (clientesLogueados.contains(cliente)){
            throw new PolloException("Ud. ya está identificado en otro dispositivo.");
        }
        
        clientesLogueados.add(cliente);
        dispositivo.asignarCliente(cliente);
    }

    public void loginGestor(String username, String password) throws PolloException {
        Gestor gestor = (Gestor) login(todosLosGestores, username, password);

        if (gestor == null) {
            throw new PolloException("Username y/o contraseña incorrecta.");
        }
        
        if (gestoresLogueados.contains(gestor)){
            throw new PolloException("Acceso denegado. El usuario ya está logueado");
        }

        gestoresLogueados.add(gestor);
        gestor.getUnidadProcesadora().loguearGestor(gestor);
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
