package model;

public abstract class   Vehiculo {
    private String marca;
    protected int velocidad;

    public Vehiculo(String marca) {
        this.marca = marca;
        this.velocidad = 0;
    }

    public abstract void acelerar();

    @Override
    public String toString() {
        return
                "marca='" + marca + '\'' +
                ", velocidad=" + velocidad;
    }
}
