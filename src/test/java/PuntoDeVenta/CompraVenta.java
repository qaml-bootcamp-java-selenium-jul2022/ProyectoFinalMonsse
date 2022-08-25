package PuntoDeVenta;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

class CompraVenta {
    Vendedor vendedor = new Vendedor();
    Cliente clienteNuevo = new Cliente("Monsse", "Mi direccion num1",
            "example@test.com", 331257466);

    List<EstadosRepublica> regionNorte = new ArrayList<>(List.of(new EstadosRepublica[]{
            EstadosRepublica.NUEVO_LEON,
            EstadosRepublica.CHIHUAHUA,
            EstadosRepublica.COAHUILA
    }));

  List<EstadosRepublica> regionCentro = new ArrayList<>(List.of(new EstadosRepublica[]{
          EstadosRepublica.JALISCO,
          EstadosRepublica.COLIMA,
          EstadosRepublica.MICHOACAN
  }));

    List<Prenda> inicializaListaDePrendas(List<Prenda> prendas)
    {
      prendas.add(new Prenda(TipoDePrenda.BLUSA, regionCentro, Categoria.COMUN, 40, 150, 100));
      prendas.add(new Prenda(TipoDePrenda.PANTALON, regionNorte, Categoria.GALA, 80, 250, 180));

      return prendas;
    }
    @Test
    void registroDeCliente(){
      vendedor.registrar(clienteNuevo);

      Assertions.assertEquals(vendedor.buscar(clienteNuevo.getEmail()), true);
      Assertions.assertEquals(vendedor.buscar("example@test.com"), true);
      Assertions.assertEquals(vendedor.buscar("noexisto@test.com"), false);
    }

    @Test
    void ventaDePrendas(){
      List<Prenda> prendasPorComprar = new ArrayList<>();
      prendasPorComprar = inicializaListaDePrendas(prendasPorComprar);
      
      float totalVenta = 0;
      for (Prenda prenda: prendasPorComprar) {
        totalVenta += prenda.getCostoVenta();
      }

      Assertions.assertEquals(totalVenta, vendedor.venta(prendasPorComprar));


    }
}
