public class Moto {
    String marca;
    int velocidad;

    public Moto(String marca) {
        this.marca = marca;
        this.velocidad = 0;
    }

    public void acelerar() {
        velocidad += 5;
    }
}