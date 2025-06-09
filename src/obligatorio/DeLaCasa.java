package obligatorio;

public class DeLaCasa extends TipoCliente {

    @Override
    public float servicioBeneficio(float subtotal) {
        return subtotal - 500;
    }
}
