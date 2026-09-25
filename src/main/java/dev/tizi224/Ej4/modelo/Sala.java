package dev.tizi224.Ej4.modelo;

import java.io.Serializable;

public class Sala implements Serializable {
    private String nombre;
    public int salaId;
    private static int siguienteId = 1;

    public Sala(String nombre) {
        this.nombre = nombre;
        this.salaId = siguienteId++;
    }

    public Sala crearSala(String nombre) {
        return new Sala(nombre);
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    @Override
    public String toString() {
        return "Sala{" +
                "nombre='" + nombre + '\'' +
                ", salaId=" + salaId +
                '}';
    }
}
