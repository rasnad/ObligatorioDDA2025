package Modelo.Sistema;

import Modelo.Cliente;
import Modelo.Dispositivo;
import Modelo.Exception.PolloException;
import Modelo.Gestor;
import Modelo.Usuario;
import java.util.ArrayList;

public class SubsistemaAcceso {

    ArrayList<Dispositivo> todosLosDispositivos = new ArrayList<>();
    ArrayList<Cliente> todosLosClientes = new ArrayList<>();
    ArrayList<Gestor> todosLosGestores = new ArrayList<>();   
    ArrayList<Cliente> clientesLogueados = new ArrayList<>();
    ArrayList<Gestor> gestoresLogueados = new ArrayList<>();
    
    protected SubsistemaAcceso(){}

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
        Fachada.getInstancia().crearServicio(dispositivo, cliente);
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
        dispositivo.liberarClienteDelServicio();
        cliente.terminarServicioEnDispositivo();
        logout(clientesLogueados, cliente);
    }
        
    public void logoutGestor(Gestor gestor) {
        gestor.getUnidadProcesadora().desloguearGestor(gestor);
        logout(gestoresLogueados, gestor);
    }

    public void nuevoCliente(Cliente cliente) {
        todosLosClientes.add(cliente);
    }

    public void nuevoGestor(Gestor gestor) {
        todosLosGestores.add(gestor);
    }
    
    public void nuevoDispositivo(Dispositivo dispositivo) {
        todosLosDispositivos.add(dispositivo);
    }
    
    public Dispositivo devolverDispositivo(){
        
        if (todosLosDispositivos.isEmpty()){  //si no hay dispositivos, devuelve uno nuevo
            Dispositivo d = new Dispositivo();
            nuevoDispositivo(d);
            return d;
        }
        
        //devuelve uno random libre
        Dispositivo disp = todosLosDispositivos.get((int)(Math.random() * todosLosDispositivos.size()));
        if (!disp.getEstaOcupado()){
            return disp;
        }
        
        for (Dispositivo libre : todosLosDispositivos){ //devuelve primer disp libre
            if (!libre.getEstaOcupado()){
                return libre;
            }
        }
        
        return todosLosDispositivos.getFirst(); //devuelve disp 0 si están todos ocupados
        
    }
    
}
