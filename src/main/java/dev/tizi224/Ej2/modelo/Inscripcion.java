package dev.tizi224.Ej2.modelo;

import dev.tizi224.Ej2.modelo.actividades.Actividad;

import java.io.Serializable;
import java.time.LocalDate;

public class Inscripcion implements Serializable {
    private LocalDate fecha;
    private String estado;
    private Estudiante estudiante;
    private Actividad actividad;

    public Inscripcion(LocalDate fecha, String estado, Estudiante estudiante, Actividad actividad) {
        this.fecha = fecha;
        this.estado = estado;
        this.estudiante = estudiante;
        this.actividad = actividad;
    }

    public LocalDate getFecha() { return fecha; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public Estudiante getEstudiante() { return estudiante; }
    public Actividad getActividad() { return actividad; }

    @Override
    public String toString() {
        return "Inscripcion{" +
                "fecha=" + fecha +
                ", estado='" + estado + '\'' +
                ", estudiante=" + (estudiante == null ? "null" : estudiante.getNombre()) +
                ", actividad=" + (actividad == null ? "null" : actividad.getTitulo()) +
                '}';
    }
}
