package Controlador;

import Modelo.EstadosDePedido.Pedido;
import Modelo.Exception.PolloException;
import Modelo.Gestor;
import Modelo.Sistema.Fachada;
import Modelo.UnidadProcesadora;
import Observador.Observador;
import java.text.SimpleDateFormat;

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
        vista.mostrarPedidosConfirmados(unidadProcesadora.obtenerPedidosConfirmados());
        vista.mostrarPedidosTomados(gestor.getPedidosTomados());
    }
    
    public String textoDeUnPedidoConfirmados(Pedido p){
         SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
         String pedidoFormateado = p.getTipoDeEstado().toString() + " - "
                + p.getItem().getNombre() + " - "
                + p.getServicio().getCliente().getNombreCompleto() + " - "
                + sdf.format(p.getFecha());
            
            if (!"".equals(p.getComentario())) {
                pedidoFormateado += " - " + p.getComentario();
            }
        
        return pedidoFormateado;
    }

    public void salir() {
        fachada.quitarObservador(this);
    }

    public void logoutGestor() {
        try {
            fachada.logoutGestor(gestor);
            vista.puedeCerrarse();
        }  catch (PolloException e) {
            vista.mostrarError("Error logout", e.getMessage());
        }
    }

    public void tomarPedido(Pedido pedido) {
        try {
            fachada.tomarPedido(pedido, getGestor());
        } catch (PolloException e) {
            vista.mostrarError("Error al tomar pedido", e.getMessage());
        }
    }

    public void finalizarPedido(Pedido pedido) {
        try {
            fachada.finalizarPedido(pedido, getGestor());
        } catch (PolloException e) {
            vista.mostrarError("Error al finalizar pedido", e.getMessage());
        }
    }

    public void entregarPedido(Pedido pedido) {
        try {
            fachada.entregarPedido(pedido, getGestor());
        } catch (PolloException e) {
            vista.mostrarError("Error al entregar pedido", e.getMessage());
        }

    }

    //Eventos del Modelo

    @Override
    public void actualizar(Object evento, Object origen) {
        if (evento.equals(Fachada.eventos.estadoDePedidoActualizado)) {
            vista.mostrarPedidosConfirmados(unidadProcesadora.obtenerPedidosConfirmados());
            vista.mostrarPedidosTomados(gestor.getPedidosTomados());
        }
    }
}
