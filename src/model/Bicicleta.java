package model;

public class Bicicleta extends Vehiculo{
    public Bicicleta(String marca) {
        super(marca);
    }

    @Override
    public void acelerar() {
        velocidad +=1;
    }

    @Override
    public String toString() {
        return "Bicicleta{" +
                super.toString() +
                '}';
    }
}
