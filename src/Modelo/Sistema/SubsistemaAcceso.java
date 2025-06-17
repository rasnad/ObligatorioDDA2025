package Modelo.Sistema;

import Modelo.Cliente;
import Modelo.Dispositivo;
import Modelo.Exception.PolloException;
import Modelo.Gestor;
import Modelo.Usuario;
import Precarga.DatosDePrueba;

import java.util.ArrayList;

public class SubsistemaAcceso {
    private static int ultimoDispositivoAbierto = 0;
    private ArrayList<Dispositivo> todosLosDispositivos = new ArrayList<>();
    private ArrayList<Cliente> todosLosClientes = new ArrayList<>();
    private ArrayList<Gestor> todosLosGestores = new ArrayList<>();   
    private ArrayList<Cliente> clientesLogueados = new ArrayList<>();
    private ArrayList<Gestor> gestoresLogueados = new ArrayList<>();
    private DatosDePrueba datosDePrueba = new DatosDePrueba();
    
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
    


    public Gestor loginGestor(String username, String password) throws PolloException {
        Gestor gestor = (Gestor) login(todosLosGestores, username, password);

        if (gestor == null) {
            throw new PolloException("Username y/o contraseña incorrecta.");
        }
        
        if (gestoresLogueados.contains(gestor)){
            throw new PolloException("Acceso denegado. El usuario ya está logueado");
        }

        gestoresLogueados.add(gestor);
        gestor.getUnidadProcesadora().loguearGestor(gestor);
        return gestor;
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
    
    //MÉTODO TEMPORAL PARA TESTING, BORRAR LUEGO DE IMPLEMENTAR SOLUCIÓN FINAL
    public Dispositivo devolverDispositivo(){
        
        //devuelve el primer dispositivo cuya GUI no ha iniciado
        int i = ultimoDispositivoAbierto;
        while (i < todosLosDispositivos.size()){
            Dispositivo d = todosLosDispositivos.get(i);
            ultimoDispositivoAbierto++;
            return d;
        }
        
        //devuelve un dispositivo random si ya se abrieron todos los dispositivos
        return todosLosDispositivos.get((int)(Math.random() * todosLosDispositivos.size()));
    }
    
}
