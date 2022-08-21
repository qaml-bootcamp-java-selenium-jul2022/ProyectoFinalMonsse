package PuntoDeVenta;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

  class CompraVenta {
    @Test
    void registroDeCliente(){
      Cliente clienteNuevo = new Cliente("Monsse", "Mi direccion num1",
              "example@test.com", 331257466);
      Vendedor vendedor = new Vendedor();

      vendedor.registrar(clienteNuevo);

      Assertions.assertEquals(vendedor.buscar(clienteNuevo.getEmail()), true);
      Assertions.assertEquals(vendedor.buscar("noexisto@test.com"), false);
    }
}
