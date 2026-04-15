package model;

import java.util.Objects;

public abstract class Vehiculo implements Comparable<Vehiculo> {
    private String marca;
    protected int velocidad;

    public Vehiculo(String marca) throws MarcaInvalidaException {
        if (marca == null || marca.isEmpty()){
            throw  new MarcaInvalidaException("La marca no puede estar vacía");
        }
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

    @Override
    public int compareTo(Vehiculo o) {
        return this.marca.compareTo(o.marca);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return velocidad == vehiculo.velocidad && Objects.equals(marca, vehiculo.marca);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marca, velocidad);
    }
}
