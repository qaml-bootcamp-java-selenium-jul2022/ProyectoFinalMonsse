package PuntoDeVenta;
import java.util.Map;
import java.util.TreeMap;

public class Vendedor {
    private Map<String, Cliente> registgroDeClientes;

    public Vendedor (){
        registgroDeClientes = new TreeMap<>();
    }
    public void registrar(Cliente clienteNuevo){
        registgroDeClientes.put(clienteNuevo.getEmail(), clienteNuevo);

    }

    public boolean buscar (String email){
        return registgroDeClientes.containsKey(email);
    }

}
