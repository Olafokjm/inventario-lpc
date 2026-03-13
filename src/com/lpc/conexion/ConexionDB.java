package com.lpc.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionDB {

    private static final String URL = "jdbc:mysql://localhost:3306/inventario_lpc";
    private static final String USER = "root";
    private static final String PASSWORD = "GunnerY";

    public static Connection conectar() {
        Connection conexion = null;

        try {
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexion exitosa");
        } catch (Exception e) {
            System.out.println("Error en la conexion: " + e.getMessage());
        }

        return conexion;
    }
}