package dao;

import model.Coche;
import model.MarcaInvalidaException;
import model.Moto;
import model.Vehiculo;

import java.io.*;
import java.util.TreeSet;

public class VehiculoDAOFile implements VehiculoDAO {

    private static String file = "vehiculos.csv";

    @Override
    public boolean añadirVehiculo(Vehiculo v) {
        return false;
    }

    @Override
    public boolean acelerarTodos(TreeSet<Vehiculo> vehiculos) {
        return false;
    }

    @Override
    public TreeSet<Vehiculo> getVehiculos() {
        TreeSet<Vehiculo> vehiculos = new TreeSet<>();

        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String linea;
            while((linea = br.readLine()) != null){
                Vehiculo v = CSVToVehiculo(linea);
                if(v != null ) {
                    vehiculos.add(v);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR:" + e.getMessage());
        } catch (IOException e) {
            System.out.println("ERROR:" + e.getMessage());
        }
        return vehiculos;
    }

    @Override
    public void guardar(TreeSet<Vehiculo> vehiculos) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (Vehiculo v : vehiculos){
                bw.write(vehiculoToCSV(v));
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("ERROR:" + e.getMessage());
        }
    }

    private String vehiculoToCSV(Vehiculo v) {
        StringBuilder sb = new StringBuilder();

        // Tipo de vehículo (Moto, Coche, etc.)
        sb.append(v.getClass().getSimpleName()).append(",");

        // Atributos comunes
        sb.append(v.getMarca()).append(",");
        sb.append(v.getVelocidad()).append(",");
        sb.append(v.getId());

        return sb.toString();
    }

    private Vehiculo CSVToVehiculo(String s)  {

        String[] partes = s.split(",");

        String tipo = partes[0];
        String marca = partes[1];
        int velocidad = Integer.parseInt(partes[2]);
        int id = Integer.parseInt(partes[3]);

        Vehiculo v = null;

        switch (tipo) {
            case "Moto":
                try {
                    v = new Moto(marca);
                } catch (MarcaInvalidaException e) {
                    return null;
                }
                break;

            case "Coche":
                try {
                    v = new Coche(marca);
                } catch (MarcaInvalidaException e) {
                    return null;
                }
                break;
        }

        return v;
    }
}
