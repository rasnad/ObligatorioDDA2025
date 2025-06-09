package obligatorio;

public class Cliente extends Usuario {
    int id;
    TipoCliente tipoCliente;
    
    public Cliente(int id, TipoCliente tipo, String password, String nombreCompleto){
        super(nombreCompleto, Integer.toString(id), password);
        this.id = id;
        this.tipoCliente = tipo;
    }
    
    public void terminarServicio(){

    }
    
    public float calcularBeneficioItem(Item item) {
        return 0;
    }
    
    public float calcularBeneficioServicio(float subTotal) {
        return 0;
    }
}
