package Observador;

import java.util.ArrayList;

public abstract class Observable {

    private ArrayList<Observador> observadores = new ArrayList<>();

    public void agregarObservador(Observador observador) {
        if (!observadores.contains(observador)) {
            observadores.add(observador);
        }
    }

    public void quitarObservador(Observador observador) {
        observadores.remove(observador);
    }

    public void notificarObservadores(Object evento, Object origen) {
        ArrayList<Observador> copia = new ArrayList(observadores);
        for (Observador obs : copia) {
            obs.actualizar(evento, this);
        }
    }
}
