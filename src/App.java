import model.Coche;
import model.Moto;
import model.Vehiculo;

import java.util.ArrayList;
import java.util.Scanner;

public class App {


    static ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    public static void main(String[] args) {
        addTestData();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("1. Añadir coche");
            System.out.println("2. Añadir moto");
            System.out.println("3. Acelerar todo");
            System.out.println("4. Mostrar");
            System.out.println("0. Salir");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    sc.nextLine(); // limpiar buffer
                    System.out.print("Introduce la marca del coche: ");
                    String marcaCoche = sc.nextLine();
                    vehiculos.add(new Coche(marcaCoche));
                    break;
                case 2:
                    sc.nextLine(); // limpiar buffer
                    System.out.print("Introduce la marca de la moto: ");
                    String marcaMoto = sc.nextLine();
                    vehiculos.add(new Moto(marcaMoto));
                    break;
                case 3:

                    for (Vehiculo v : vehiculos) v.acelerar();
                    break;
                case 4:
                    for (Vehiculo v : vehiculos)
                        System.out.println(v);
                    break;
            }

        } while (opcion != 0);
    }

    public static void addTestData() {
        // Añadimos coches
        vehiculos.add(new Coche("Toyota"));
        vehiculos.add(new Coche("Honda"));
        vehiculos.add(new Coche("Ford"));

        // Añadimos motos
        vehiculos.add(new Moto("Yamaha"));
        vehiculos.add(new Moto("Kawasaki"));
        vehiculos.add(new Moto("Ducati"));
    }
}