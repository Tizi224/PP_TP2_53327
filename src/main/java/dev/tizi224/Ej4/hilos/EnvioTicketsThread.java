package dev.tizi224.Ej4.hilos;
 import dev.tizi224.Ej4.modelo.EventoUniversitario;
 import dev.tizi224.Ej4.modelo.Inscripcion;
 import dev.tizi224.Ej4.modelo.actividades.Actividad;

public class EnvioTicketsThread extends Thread{
    public EventoUniversitario evento;

    public EnvioTicketsThread(EventoUniversitario evento) {
        this.evento = evento;
    }

    @Override
    public void run(){
        System.out.println("Trabajando en el hilo secundario");
        for(Actividad actividad : evento.getActividades()) {
            for(Inscripcion inscripcion : actividad.getInscripciones()){
                if (inscripcion.getTicket() != null) {
                    inscripcion.getTicket().enviarTicket();
                }
            }
        }
    }
}
