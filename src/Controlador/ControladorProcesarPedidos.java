package Controlador;

import Modelo.EstadosDePedido.Pedido;
import Modelo.Exception.PolloException;
import Modelo.Gestor;
import Modelo.Sistema.Fachada;
import Observador.Observador;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static Modelo.EstadosDePedido.EstadoPedido.TipoDeEstado.CONFIRMADO;

public class ControladorProcesarPedidos implements Observador {

    private VistaProcesarPedidos vista;
    private final Fachada fachada = Fachada.getInstancia();
    private Gestor gestor;

    public ControladorProcesarPedidos(Gestor gestor, VistaProcesarPedidos vista) {
        this.vista = vista;
        this.gestor = gestor;
        fachada.agregarObservador(this);
        inicializarVista();
    }

    //Eventos del Usuario

    public void inicializarVista() {
        vista.mostrarInfoGestor(gestor.getNombreCompleto(), gestor.getUnidadProcesadora().getNombre());
        vista.mostrarPedidosConfirmados(obtenerPedidosConfirmados());
        vista.mostrarPedidosTomados(gestor.getPedidosTomados());
    }

    public ArrayList<Pedido> obtenerPedidosConfirmados() {
        return gestor.getUnidadProcesadora().getPedidos()
                .stream()
                .filter(pedido -> pedido.getTipoDeEstado().equals(CONFIRMADO))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public void salir() {
        fachada.quitarObservador(this);
    }

    public void logoutGestor() {
        try {
            fachada.logoutGestor(gestor);
            vista.puedeCerrarse();
        }  catch (PolloException e) {
            vista.mostrarError(e.getMessage());
        }
    }

    public void tomarPedido(Pedido pedido) {
        try {
            fachada.tomarPedido(pedido, getGestor());
        } catch (PolloException e) {
            vista.mostrarError(e.getMessage());
        }
    }

    public void finalizarPedido(Pedido pedido) {
        try {
            fachada.finalizarPedido(pedido, getGestor());
        } catch (PolloException e) {
            vista.mostrarError(e.getMessage());
        }
    }

    public void entregarPedido(Pedido pedido) {
        try {
            fachada.entregarPedido(pedido, getGestor());
        } catch (PolloException e) {
            vista.mostrarError(e.getMessage());
        }

    }

    //Eventos del Modelo

    @Override
    public void actualizar(Object evento, Object origen) {
        if (evento.equals(Fachada.eventos.estadoDePedidoActualizado)) {
            vista.mostrarPedidosConfirmados(obtenerPedidosConfirmados());
            vista.mostrarPedidosTomados(gestor.getPedidosTomados());
        }
        //vista.mostrarMonto(); //evento montoActualizado
        //vista.mostrarMensaje(); //evento nuevoMensaje
    }

    public Gestor getGestor() {
        return gestor;
    }
}
