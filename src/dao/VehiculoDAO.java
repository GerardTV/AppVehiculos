package dao;

import com.sun.source.tree.Tree;
import model.Vehiculo;

import java.util.TreeSet;

public interface VehiculoDAO {
    boolean añadirVehiculo(Vehiculo v);
    boolean acelerarTodos(TreeSet<Vehiculo> vehiculos);
    TreeSet<Vehiculo> getVehiculos();
    void guardar(TreeSet<Vehiculo> vehiculos);
}
