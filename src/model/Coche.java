package model;

public class Coche extends Vehiculo {


    public Coche(String marca) throws MarcaInvalidaException {
        super(marca);
    }

    public void acelerar() {
        velocidad += 10;
    }

    @Override
    public String toString() {
        return "Coche{" +
                super.toString() +
                '}';
    }


}