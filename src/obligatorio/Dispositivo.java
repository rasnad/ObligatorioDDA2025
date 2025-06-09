package obligatorio;

public class Dispositivo {

    Fachada fachada;
    int id;
    Cliente clienteAsignado;
    boolean estaOcupado;

    public Dispositivo(int i) {
        this.estaOcupado = false;
    }

    public void asignarCliente(Cliente cliente) {
        clienteAsignado = cliente;
        estaOcupado = true;
    }

    public void liberarCliente() {
        clienteAsignado = null;
        estaOcupado = false;
    }

    public void loginCliente(Dispositivo dispositivo, String username, String password) {
        fachada.loginCliente(this, username, password);
    }
}
