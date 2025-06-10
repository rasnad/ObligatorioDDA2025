package obligatorio;

import java.util.ArrayList;
import java.util.List;

public abstract class ObservableBase implements Observable {

    private List<Observador> observadores = new ArrayList<>();

    @Override
    public void agregarObservador(Observador observador) {
        if (!observadores.contains(observador)) {
            observadores.add(observador);
        }
    }

    @Override
    public void quitarObservador(Observador observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificarObservadores(EstadoPedido evento, Object datos) {
        for (Observador obs : observadores) {
            obs.actualizar(evento, datos);
        }
    }
}
