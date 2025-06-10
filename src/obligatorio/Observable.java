package obligatorio;

import java.util.ArrayList;
import java.util.List;

public interface Observable {
    void agregarObservador(Observador observador);
    void quitarObservador(Observador observador);
    void notificarObservadores(EstadoPedido evento, Object datos);
}


