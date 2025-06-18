package Controlador;

import Modelo.EstadosDePedido.Pedido;
import Modelo.Exception.PolloException;
import Modelo.Gestor;
import Modelo.Sistema.Fachada;
import Modelo.UnidadProcesadora;
import Observador.Observador;
import java.util.ArrayList;

public class ControladorProcesarPedidos implements Observador {

    private VistaProcesarPedidos vista;
    private final Fachada fachada = Fachada.getInstancia();
    private Gestor gestor;
    private UnidadProcesadora unidadProcesadora;

    public ControladorProcesarPedidos(Gestor gestor, VistaProcesarPedidos vista) {
        this.vista = vista;
        this.gestor = gestor;
        unidadProcesadora = gestor.getUnidadProcesadora();
        fachada.agregarObservador(this);
        inicializarVista();
    }

    public Gestor getGestor() {
        return gestor;
    }
    
    //Eventos del Usuario

    public void inicializarVista() {
        vista.mostrarInfoGestor(gestor.getNombreCompleto(), unidadProcesadora.getNombre());
        vista.mostrarPedidosConfirmados(obtenerPedidosConfirmados());
        vista.mostrarPedidosTomados(gestor.getPedidosTomados());
    }

    public ArrayList<Pedido> obtenerPedidosConfirmados() {
        return unidadProcesadora.obtenerPedidosConfirmados();
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
    }
}
