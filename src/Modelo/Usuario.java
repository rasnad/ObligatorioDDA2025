package Modelo;

public abstract class Usuario {
    private String nombreCompleto;
    private String password;
    private String username;
    
    public Usuario(String nombreCompleto, String username, String password){
        this.nombreCompleto = nombreCompleto;
        this.password = password;
        this.username = username;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
}
