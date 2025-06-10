package obligatorio;

import java.util.ArrayList;

import static obligatorio.EstadoPedido.*;

public class Dispositivo extends ObservableBase implements Observador{

    Fachada fachada = Fachada.getInstancia();

    int id;
    static int ultimoId = 0;
    boolean estaOcupado = false;

    Cliente clienteAsignado;
    ArrayList<Observador> observadores = new ArrayList<>();

    public Dispositivo() {
        this.id = ultimoId++;
        fachada.agregarObservador(this);
    }

    public void asignarCliente(Cliente cliente) {
        this.clienteAsignado = cliente;
        estaOcupado = true;
    }

    public void liberarCliente() {
        this.clienteAsignado = null;
        estaOcupado = false;
    }

    public void loginCliente(int username, String password) throws PolloException {
        if(this.estaOcupado){
            throw new PolloException("Debe primero finalizar el servicio actual.");
        }
        
        fachada.loginCliente(this, Integer.toString(username), password);
    }

    public void avisar(Object event, Pedido datos){
        for(Observador o : observadores){
            o.actualizar(event, datos);
        }
    }

    @Override
    public void actualizar(Object evento, Object datos) {
        if (evento.equals(PEDIDO_CONFIRMADO)) {
            mostrarPedido((Pedido) datos);
        } else if (evento.equals(PEDIDO_FINALIZADO)) {
            mostrarNotificacionFinalizado((Pedido) datos);
        } else if (evento.equals(SERVICIO_FINALIZADO)) {
            liberarCliente();
        }
    }

    private Pedido mostrarNotificacionFinalizado(Pedido datos) {
        return datos;
    }

    private Pedido mostrarPedido( Pedido datos) {
        return datos;
    }

}
