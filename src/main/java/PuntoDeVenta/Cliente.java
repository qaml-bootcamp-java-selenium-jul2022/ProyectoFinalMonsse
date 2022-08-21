package PuntoDeVenta;

public class Cliente {
    private String nombre;
    private  String direccion;
    private String email;
    private int telefono;

    public Cliente (String nombre, String direccion, String email, int telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
        this.telefono =telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEmail() {
        return email;
    }

    public int getTelefono() {
        return telefono;
    }
}

