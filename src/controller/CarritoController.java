package controller;

import java.util.Vector;

import model.Articulo;
import model.CarritoModel;
import view.CarritoView;

public class CarritoController {
    private CarritoModel carritoModel;
    private CarritoView carritoView;

    public CarritoController() {
        carritoModel = new CarritoModel();
    }

    public void setView(CarritoView view) {
        carritoView = view;
    }

    public void agregarArticulo(String nombre, double precio) {
        carritoModel.agregarArticulo(nombre, precio);
    }

    public Vector<Articulo> getCarrito() {
        return carritoModel.getCarrito();
    }

    public double getPrecioTotal() {
        return carritoModel.calcularPrecioTotal();
    }

    public static void main(String[] args) {
        CarritoController controller = new CarritoController();
        CarritoView view = new CarritoView(controller);
        controller.setView(view);
        view.setVisible(true);
    }
}




