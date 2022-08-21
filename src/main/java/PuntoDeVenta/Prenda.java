package PuntoDeVenta;

import java.util.List;

public class Prenda {
    private TipoDePrenda tipoDePrenda;
    List<EstadosRepublica> listaDeEstados;
    private Categoria categoria;
    private float costoProduccion;
    private float costoVenta;
    private  float costoRenta;

    public Prenda (TipoDePrenda tipoDePrenda, List<EstadosRepublica> listaDeEstados, Categoria categoria,
                   float costoProduccion, float costoVenta, float costoRenta) {
        this.tipoDePrenda = tipoDePrenda;
        this.listaDeEstados = listaDeEstados;
        this.categoria = categoria;
        this.costoProduccion = costoProduccion;
        this.costoVenta = costoVenta;
        this.costoRenta =costoRenta;
    }
  
    public TipoDePrenda getTipoDePrenda() {
        return tipoDePrenda;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public float getCostoProduccion() {
        return costoProduccion;
    }

    public float getCostoVenta() {
        return costoVenta;
    }

    public float getCostoRenta() {
        return costoRenta;
    }
    
}
