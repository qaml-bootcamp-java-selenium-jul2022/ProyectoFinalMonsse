package PuntoDeVenta;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class PuntoDeVentaORenta {
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

  List<EstadosRepublica> regionSur = new ArrayList<>(List.of(new EstadosRepublica[]{
          EstadosRepublica.CAMPEHCE,
          EstadosRepublica.OAXACA,
          EstadosRepublica.YUCATAN
  }));

    List<Prenda> inicializaListaDePrendasPorComprar(List<Prenda> prendas)
    {
      prendas.add(new Prenda(TipoDePrenda.BLUSA, regionCentro, Categoria.COMUN, 40, 150, 100));
      prendas.add(new Prenda(TipoDePrenda.PANTALON, regionNorte, Categoria.GALA, 80, 250, 180));

      return prendas;
    }

  List<Prenda> inicializaListaDePrendasPorRentar(List<Prenda> prendas)
  {
    prendas.add(new Prenda(TipoDePrenda.FALDA, regionSur, Categoria.COMUN, 70, 180, 120));
    prendas.add(new Prenda(TipoDePrenda.SOMBRERO, regionNorte, Categoria.COMUN, 50, 140, 110));
    prendas.add(new Prenda(TipoDePrenda.BLUSA, regionCentro, Categoria.GALA, 85, 240, 190));
    prendas.add(new Prenda(TipoDePrenda.ZAPATO, regionNorte, Categoria.GALA, 150, 320, 250));


    return prendas;
  }
    @Test
    void registroDeCliente(){
      vendedor.registrar(clienteNuevo);

      Assertions.assertEquals(vendedor.buscarCliente(clienteNuevo.getEmail()), true);
      Assertions.assertEquals(vendedor.buscarCliente("example@test.com"), true);
      Assertions.assertEquals(vendedor.buscarCliente("noexisto@test.com"), false);
    }

    @Test
    void ventaDePrendas(){
      List<Prenda> prendasPorComprar = new ArrayList<>();
      prendasPorComprar = inicializaListaDePrendasPorComprar(prendasPorComprar);
      
      float totalVenta = 0;
      for (Prenda prenda: prendasPorComprar) {
        totalVenta += prenda.getCostoVenta();
      }

      Assertions.assertEquals(totalVenta, vendedor.venta(prendasPorComprar));

    }
    @Test
    void rentaDePrendas(){
      String emaiCliente = "example@test.com";
      float totalRenta = 0;

      List<Prenda> prendasPorRentar = new ArrayList<>();
      prendasPorRentar = inicializaListaDePrendasPorRentar(prendasPorRentar);

      for (Prenda prenda: prendasPorRentar) {
        totalRenta += prenda.getCostoRenta();
      }

      vendedor.registrar(clienteNuevo);
      Assertions.assertEquals(totalRenta, vendedor.renta(prendasPorRentar, emaiCliente));
      Assertions.assertEquals(0, vendedor.renta(prendasPorRentar, "noExisto@test.com"));
    }
}
