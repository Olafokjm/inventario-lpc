package com.lpc.main;

import com.lpc.dao.ProductoDAO;
import com.lpc.modelo.Producto;

public class Main {

    public static void main(String[] args) {

        ProductoDAO dao = new ProductoDAO();

        Producto producto = new Producto("Bebida energetica", 50, 5000);

        dao.insertarProducto(producto);

        dao.consultarProductos();

        dao.actualizarProducto(1, 80);

        dao.eliminarProducto(2);
    }
}