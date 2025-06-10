package obligatorio;

public class Cliente extends Usuario {
    int id;
    TipoCliente tipoCliente;
    Servicio servicio;
    
    public Cliente(int id, TipoCliente tipo, String password, String nombreCompleto){
        super(nombreCompleto, Integer.toString(id), password);
        this.id = id;
        this.tipoCliente = tipo;
    }

    public void empezarServicio(){
        servicio = new Servicio(this);
    }

    public void terminarServicio(){
        servicio = null;
    }
    
    public float calcularBeneficioItem(Item item) {
        return 0;
    }
    
    public float calcularBeneficioServicio(float subTotal) {
        return 0;
    }
}
