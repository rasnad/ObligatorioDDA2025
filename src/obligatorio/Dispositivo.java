package obligatorio;

public class Dispositivo {

    Fachada fachada = Fachada.getInstancia();
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

    public void loginCliente(int username, String password) throws PolloException {
        fachada.loginCliente(this, Integer.toString(username), password);
    }
}
