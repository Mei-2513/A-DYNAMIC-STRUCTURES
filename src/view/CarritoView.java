package view;

import javax.swing.*;

import model.Articulo;
import model.CarritoModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class CarritoView extends JFrame {
    private JTextArea areaCarrito;
    private JLabel labelTotal;
    private CarritoModel carritoModel;

    public CarritoView(CarritoModel model) {
        carritoModel = model;

        areaCarrito = new JTextArea(10, 30);
        areaCarrito.setEditable(false);

        labelTotal = new JLabel("Total: ");

        JButton botonAgregar = new JButton("Agregar Artículo");
        botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = JOptionPane.showInputDialog("Ingrese el nombre del artículo:");
                String precioStr = JOptionPane.showInputDialog("Ingrese el precio del artículo:");
                double precio = Double.parseDouble(precioStr);

                carritoModel.agregarArticulo(nombre, precio);
                actualizarVista();
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JScrollPane(areaCarrito));
        panel.add(labelTotal);
        panel.add(botonAgregar);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Carrito de Compras");
        add(panel);
        pack();
        setVisible(true);
    }

    public void actualizarVista() {
        Vector<Articulo> carrito = carritoModel.getCarrito();
        areaCarrito.setText("");
        for (Articulo articulo : carrito) {
            areaCarrito.append(articulo.getNombre() + " - $" + articulo.getPrecio() + "\n");
        }
        double total = carritoModel.calcularPrecioTotal();
        labelTotal.setText("Total: $" + total);
    }

    public static void main(String[] args) {
        CarritoModel model = new CarritoModel();
        CarritoView view = new CarritoView(model);
    }
}


