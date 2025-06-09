package obligatorio;

import java.util.ArrayList;

public class SubsistemaAcceso {

    ArrayList<Dispositivo> listDispositivos;
    ArrayList<Cliente> clientesLogueados;
    ArrayList<Cliente> clientesDeslogueados;
    ArrayList<Cliente> todosLosClientes;
    ArrayList<Gestor> todosLosGestores;

    public void loginCliente(Dispositivo dispositivo, String password, String idDispositivo) {

        dispositivo.asignarCliente();
    }


    public void loginGestor(Dispositivo dispositivo, String password, String idDispositivo) {
        dispositivo.asignarCliente();
    }
}
