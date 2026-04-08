import java.util.ArrayList;
import java.util.Scanner;

public class App {

    static ArrayList<Coche> coches = new ArrayList<>();
    static ArrayList<Moto> motos = new ArrayList<>();
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
                    coches.add(new Coche(marcaCoche));
                    break;
                case 2:
                    sc.nextLine(); // limpiar buffer
                    System.out.print("Introduce la marca de la moto: ");
                    String marcaMoto = sc.nextLine();
                    motos.add(new Moto(marcaMoto));
                    break;
                case 3:
                    for (Coche c : coches) c.acelerar();
                    for (Moto m : motos) m.acelerar();
                    break;
                case 4:
                    for (Coche c : coches)
                        System.out.println("Coche " + c.marca + " " + c.velocidad);
                    for (Moto m : motos)
                        System.out.println("Moto " + m.marca + " " + m.velocidad);
                    break;
            }

        } while (opcion != 0);
    }

    public static void addTestData() {
        // Añadimos coches
        coches.add(new Coche("Toyota"));
        coches.add(new Coche("Honda"));
        coches.add(new Coche("Ford"));

        // Añadimos motos
        motos.add(new Moto("Yamaha"));
        motos.add(new Moto("Kawasaki"));
        motos.add(new Moto("Ducati"));
    }
}