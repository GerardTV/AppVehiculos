package dao;

import dao.VehiculoDAO;
import model.*;

import java.sql.*;
import java.util.TreeSet;

public class VehiculoDAOBBDD implements VehiculoDAO {

    private Connection conn = DBConnection.getInstance().getConnection();

    // ✅ Añadir vehículo
    @Override
    public boolean añadirVehiculo(Vehiculo v) {
        String sql = "INSERT INTO vehiculo (marca, velocidad, tipo) VALUES (?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, v.getMarca());
            ps.setInt(2, v.getVelocidad());

            if (v instanceof Coche) {
                ps.setString(3, "COCHE");
            } else if (v instanceof Moto) {
                ps.setString(3, "MOTO");
            }

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ✅ Obtener todos los vehículos
    @Override
    public TreeSet<Vehiculo> getVehiculos() {
        TreeSet<Vehiculo> vehiculos = new TreeSet<>();

        String sql = "SELECT * FROM vehiculo";

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                String marca = rs.getString("marca");
                int velocidad = rs.getInt("velocidad");
                String tipo = rs.getString("tipo");

                Vehiculo v;

                if ("COCHE".equals(tipo)) {
                    v = new Coche(marca);
                } else {
                    v = new Moto(marca);
                }

                vehiculos.add(v);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return vehiculos;
    }

    // ✅ Acelerar todos y actualizar en BD
    @Override
    public boolean acelerarTodos(TreeSet<Vehiculo> vehiculos) {
        String sql = "UPDATE vehiculo SET velocidad = ? WHERE id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            for (Vehiculo v : vehiculos) {
                v.acelerar(); // suponiendo que existe

                ps.setInt(1, v.getVelocidad());
                ps.setInt(2, v.getId());
                ps.addBatch();
            }

            ps.executeBatch();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ✅ Guardar colección completa (sobrescribe BD)
    @Override
    public void guardar(TreeSet<Vehiculo> vehiculos) {
        String deleteSQL = "DELETE FROM vehiculo";
        String insertSQL = "INSERT INTO vehiculo (marca, velocidad, tipo) VALUES (?, ?, ?)";

        try (Statement st = conn.createStatement()) {
            st.executeUpdate(deleteSQL);

            try (PreparedStatement ps = conn.prepareStatement(insertSQL)) {

                for (Vehiculo v : vehiculos) {
                    ps.setString(1, v.getMarca());
                    ps.setInt(2, v.getVelocidad());

                    if (v instanceof Coche) {
                        ps.setString(3, "COCHE");
                    } else {
                        ps.setString(3, "MOTO");
                    }

                    ps.addBatch();
                }

                ps.executeBatch();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}