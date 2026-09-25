package dev.tizi224.Ej1.modelo.actividades;
public class Taller extends Actividad {
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
}
