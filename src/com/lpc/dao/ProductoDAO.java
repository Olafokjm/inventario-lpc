package com.lpc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lpc.conexion.ConexionBD;
import com.lpc.conexion.ConexionDB;
import com.lpc.modelo.Producto;

public class ProductoDAO {

    public void insertarProducto(Producto producto) {

        String sql = "INSERT INTO producto(nombre,cantidad,precio) VALUES(?,?,?)";

        try (Connection con = ConexionDB.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, producto.getNombre());
            ps.setInt(2, producto.getCantidad());
            ps.setDouble(3, producto.getPrecio());

            ps.executeUpdate();

            System.out.println("Producto insertado correctamente");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void consultarProductos() {

        String sql = "SELECT * FROM producto";

        try (Connection con = ConexionDB.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Cantidad: " + rs.getInt("cantidad"));
                System.out.println("Precio: " + rs.getDouble("precio"));
                System.out.println("-----------------------");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void actualizarProducto(int id, int cantidad) {

        String sql = "UPDATE producto SET cantidad=? WHERE id=?";

        try (Connection con = ConexionDB.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, cantidad);
            ps.setInt(2, id);

            ps.executeUpdate();

            System.out.println("Producto actualizado");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void eliminarProducto(int id) {

        String sql = "DELETE FROM producto WHERE id=?";

        try (Connection con = ConexionDB.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Producto eliminado");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}