package dev.tizi224.Ej3.modelo.actividades;

import dev.tizi224.Ej3.modelo.Estudiante;
import dev.tizi224.Ej3.modelo.certificacion.Certificable;

public class Curso extends Actividad implements Certificable {
    private int nivel;

    public Curso(int id, String titulo, int cupoMaximo, int nivel) {
        super(id, titulo, cupoMaximo);
        this.nivel = nivel;
    }

    public int getNivel() {
        return nivel;
    }
    public double calcularCostoMateriales(){
        return nivel * 100.0;
    }
    public String getTipo(){
        return "Curso";
    }

    @Override
    public String toString() {
        return "Curso{" +
                "nivel=" + nivel +
                '}';
    }

    @Override
    public String generarCertificado(Estudiante estudiante) {
        String cert = "Certificado de Curso - " + this.getTitulo() + " - " + estudiante.getNombre();
        return cert;
    }
}
