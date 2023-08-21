package model;


import java.util.Vector;

public class CarritoModel {
    private Vector<Articulo> carrito;

    public CarritoModel() {
        carrito = new Vector<>();
    }

    public void agregarArticulo(String nombre, double precio) {
        Articulo articulo = new Articulo(nombre, precio);
        carrito.add(articulo);
    }

    public Vector<Articulo> getCarrito() {
        return carrito;
    }

    public double calcularPrecioTotal() {
        double total = 0;
        for (Articulo articulo : carrito) {
            total += articulo.getPrecio();
        }
        return total;
    }
}




