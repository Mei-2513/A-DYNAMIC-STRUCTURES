package view;

import javax.swing.*;

import controller.CarritoController;
import model.Articulo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class CarritoView extends JFrame {
    private JTextArea areaCarrito;
    private JButton botonAgregar;
    private JButton botonFinalizar;
    private CarritoController controller;

    public CarritoView(CarritoController controller) {
        this.controller = controller;

        areaCarrito = new JTextArea(10, 30);
        areaCarrito.setEditable(false);

        botonAgregar = new JButton("Agregar Artículo");
        botonFinalizar = new JButton("Finalizar Compra");

        botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = JOptionPane.showInputDialog("Ingrese el nombre del artículo:");
                String precioStr = JOptionPane.showInputDialog("Ingrese el precio del artículo:");
                double precio = Double.parseDouble(precioStr);

                controller.agregarArticulo(nombre, precio);
                actualizarVista(controller.getCarrito());
            }
        });

        botonFinalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double total = controller.getPrecioTotal();
                JOptionPane.showMessageDialog(null, "Gracias por su compra.\nPrecio total: $" + total);
                System.exit(0);
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JScrollPane(areaCarrito));
        panel.add(botonAgregar);
        panel.add(botonFinalizar);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Carrito de Compras");
        add(panel);
        pack();
        setLocationRelativeTo(null);
    }

    public void actualizarVista(Vector<Articulo> carrito) {
        areaCarrito.setText("");
        for (Articulo articulo : carrito) {
            areaCarrito.append(articulo.getNombre() + " - $" + articulo.getPrecio() + "\n");
        }
    }

    public static void main(String[] args) {
        CarritoController controller = new CarritoController();
        CarritoView view = new CarritoView(controller);
        controller.setView(view);
        view.setVisible(true);
    }
}

