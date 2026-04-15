package model;

public class Moto extends Vehiculo {


    public Moto(String marca) throws MarcaInvalidaException {
        super(marca);

    }

    public void acelerar() {
        velocidad += 5;
    }

    @Override
    public String toString() {
        return "Moto{" +
                super.toString() +
                '}';
    }
}