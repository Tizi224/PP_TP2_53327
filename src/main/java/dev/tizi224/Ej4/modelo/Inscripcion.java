package dev.tizi224.Ej4.modelo;

import dev.tizi224.Ej4.modelo.actividades.Actividad;

import java.io.Serializable;
import java.time.LocalDate;

public class Inscripcion implements Serializable {
    private LocalDate fecha;
    private String estado;
    private Estudiante estudiante;
    private Actividad actividad;
    private TicketDeAcceso ticket;

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
    public TicketDeAcceso getTicket() { return ticket; }
    public TicketDeAcceso setTicket(TicketDeAcceso ticket) {
        this.ticket = ticket;
        return ticket;
    }
    @Override
    public String toString() {
        return "Inscripcion{" +
                "fecha=" + fecha +
                ", estado='" + estado + '\'' +
                ", estudiante=" + (estudiante == null ? "null" : estudiante.getNombre()) +
                ", actividad=" + (actividad == null ? "null" : actividad.getTitulo()) +
                '}';
    }
    public class TicketDeAcceso{
        private String idTicket;
        private LocalDate fechaEmision;

        public TicketDeAcceso(String idTicket, LocalDate fechaEmision) {
            this.idTicket = idTicket;
            this.fechaEmision = fechaEmision;
        }

        public String getIdTicket() { return idTicket; }
        public LocalDate getFechaEmision() { return fechaEmision; }

        public void enviarTicket(){
            System.out.println("Enviando ticket: " + this.toString());
        }

        @Override
        public String toString() {
            return "TicketDeAcceso{" +
                    "idTicket='" + idTicket + '\'' +
                    ", fechaEmision=" + fechaEmision +
                    '}';
        }
    }
}
