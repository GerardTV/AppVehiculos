import model.Coche;
import model.MarcaInvalidaException;
import model.Moto;
import model.Vehiculo;

import java.util.*;

public class App {


    static Set<Vehiculo> vehiculos = new TreeSet<>();
    public static void main(String[] args) {
        addTestData();
        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        do {
            System.out.println("1. Añadir coche");
            System.out.println("2. Añadir moto");
            System.out.println("3. Acelerar todo");
            System.out.println("4. Mostrar");
            System.out.println("0. Salir");
            try {
                opcion = sc.nextInt();
            }catch (Exception e) {
                System.out.println("ERROR: " + e.getMessage());
            }

            switch (opcion) {
                case 1:
                    sc.nextLine(); // limpiar buffer
                    System.out.print("Introduce la marca del coche: ");
                    String marcaCoche = sc.nextLine();
                    try {
                        vehiculos.add(new Coche(marcaCoche));
                    } catch (MarcaInvalidaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    sc.nextLine(); // limpiar buffer
                    System.out.print("Introduce la marca de la moto: ");
                    String marcaMoto = sc.nextLine();
                    try {
                        vehiculos.add(new Moto(marcaMoto));
                    } catch (MarcaInvalidaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:

                    for (Vehiculo v : vehiculos) v.acelerar();
                    break;
                case 4:
                    //Collections.sort(vehiculos);
                    for (Vehiculo v : vehiculos)
                        System.out.println(v);
                    break;
            }

        } while (opcion != 0);
    }

    public static void addTestData() {
        try{
            // Añadimos coches
            vehiculos.add(new Coche("Toyota"));
            vehiculos.add(new Coche("Honda"));
            vehiculos.add(new Coche("Ford"));

            // Añadimos motos
            vehiculos.add(new Moto("Toyota"));
            vehiculos.add(new Moto("Yamaha"));
            vehiculos.add(new Moto("Kawasaki"));
            vehiculos.add(new Moto("Ducati"));
        } catch (MarcaInvalidaException e) {
            System.out.println(e.getMessage());
        }
    }
}