package Modelo.TiposDeCliente;

public class DeLaCasa extends TipoCliente {

    @Override
    public float aplicarBeneficioServicio(float subtotal) {
        return subtotal - 500;
    }
}
