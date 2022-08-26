package PuntoDeVenta;
import java.util.List;
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
    public boolean buscarCliente(String email){
        return registgroDeClientes.containsKey(email);
    }

    public float venta(List<Prenda> prendasParaVender){
        float totalVenta = 0;

        System.out.println("PRENDA\t\t COSTO($)");
        System.out.println("********************************************");
        for (Prenda prenda: prendasParaVender) {
            totalVenta += prenda.getCostoVenta();
            System.out.println(prenda.getTipoDePrenda() + "\t\t\t" + "$ " + prenda.getCostoVenta());
        }
        System.out.println("********************************************");
        System.out.println("TOTAL\t\t" + "$ " + totalVenta);
        return totalVenta;
    }

    public float renta(List<Prenda> prendasParaRentar, String emailCliente){
        float totalRenta = 0;
        if (buscarCliente(emailCliente)) {
            System.out.println("PRENDA\t\t COSTO($)");
            System.out.println("********************************************");
            for (Prenda prenda : prendasParaRentar) {
                totalRenta += prenda.getCostoRenta();
                System.out.println(prenda.getTipoDePrenda() + "\t\t\t" + "$ " + prenda.getCostoRenta());
            }
            System.out.println("********************************************");
            System.out.println("TOTAL\t\t" + "$ " + totalRenta);
        } else {
            System.out.println("El email del usuario es incorrecto o no existe, favor de validarlo y en su caso registrarse.");
        }
        return totalRenta;
    }

}
