package Modelo.TiposDeCliente;

public class Preferencial extends TipoCliente {

    @Override
    public float servicioBeneficio(float subtotal) {
        return subtotal > 2000 ? subtotal*0.5F : subtotal;
    }

}
