package dev.tizi224.Ej3.modelo.actividades;

import dev.tizi224.Ej3.modelo.Estudiante;
import dev.tizi224.Ej3.modelo.certificacion.Certificable;

public class Taller extends Actividad implements Certificable {
    private boolean requiereNotebook;

    public Taller(int id, String titulo, int cupoMaximo) {
        this(id, titulo, cupoMaximo, false);
    }

    public Taller(int id, String titulo, int cupoMaximo, boolean requiereNotebook) {
        super(id, titulo, cupoMaximo);
        this.requiereNotebook = requiereNotebook;
    }

    public boolean isRequiereNotebook() {
        return requiereNotebook;
    }

    public void setRequiereNotebook(boolean requiereNotebook) {
        this.requiereNotebook = requiereNotebook;
    }

    public double calcularCostoMateriales(){
        return requiereNotebook ? 5000 : 2000;
    }
    public String getTipo(){
        return "Taller";
    }

    @Override
    public String generarCertificado(Estudiante estudiante) {
        String cert = "Certificado de Taller - " + this.getTitulo() + " - " + estudiante.getNombre();
        return cert;
    }
}
