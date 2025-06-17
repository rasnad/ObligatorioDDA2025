package Modelo.TiposDeCliente;

public class DeLaCasa extends TipoCliente {

    @Override
    public float aplicarBeneficioServicio(float subtotal) {
        if (subtotal < 500){
            return 0;
        }
        return subtotal - 500;
    }
    
    @Override
    public String toString(){
        return "Cliente de la Casa";
    }
}
