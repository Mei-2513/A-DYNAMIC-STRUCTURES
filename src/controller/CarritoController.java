package controller;

import model.CarritoModel;
import view.CarritoView;

public class CarritoController {
    private CarritoModel carritoModel;
    private CarritoView carritoView;

    public CarritoController(CarritoModel model, CarritoView view) {
        carritoModel = model;
        carritoView = view;
    }

    public void iniciar() {
        carritoView.actualizarVista(); // Inicializa la vista con los datos del modelo
    }

    public void agregarArticulo(String nombre, double precio) {
        carritoModel.agregarArticulo(nombre, precio);
        carritoView.actualizarVista();
    }

   
}



