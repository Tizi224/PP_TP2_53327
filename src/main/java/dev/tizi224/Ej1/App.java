package dev.tizi224.Ej1;

import dev.tizi224.Ej1.excepciones.CupoExcedidoException;
import dev.tizi224.Ej1.modelo.Estudiante;
import dev.tizi224.Ej1.modelo.EventoUniversitario;
import dev.tizi224.Ej1.modelo.Inscripcion;
import dev.tizi224.Ej1.modelo.Sala;
import dev.tizi224.Ej1.modelo.actividades.Actividad;
import dev.tizi224.Ej1.modelo.actividades.Charla;
import dev.tizi224.Ej1.modelo.actividades.Taller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static boolean grabado = false;
    public static boolean leido = false;
    public static void main(String[] args) {
        System.out.println("--- Registro de estudiantes ---");
        Estudiante estudiante1 = new Estudiante("67982", "Santiago Calderón");
        Estudiante estudiante2 = new Estudiante("69420", "Ezequiel Pérez");
        Estudiante estudiante3 = new Estudiante("45678", "María López");

        List<Estudiante> estudiantes = new ArrayList<>();
        estudiantes.add(estudiante1);
        estudiantes.add(estudiante2);
        estudiantes.add(estudiante3);

        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante);
        }

        System.out.println("\n--- Construcción de evento y sala ---");
        EventoUniversitario evento = new EventoUniversitario("E1", "Jornada de Tecnología", 10000.0, false);

        Sala sala = new Sala("Sala Principal");
        evento.agregarSala(sala);

        System.out.println("Evento asignado a: " + evento.salaAsignada);

        System.out.println("\n--- Creación de actividades ---");
        Charla charla = new Charla(1, "Ciberseguridad", 1, "Dr. Gómez");
        Taller taller = new Taller(2, "Fundamentos de IA", 40, true);

        evento.agregarActividad(charla);
        evento.agregarActividad(taller);

        System.out.println("\n--- Inscripción de estudiantes en actividades ---");
        Inscripcion insc1 = null;
        Inscripcion insc2 = null;
        try {
            // Inscribir 2 estudiantes en Charla
            insc1 = charla.incribir(estudiante1);
            insc2 = charla.incribir(estudiante2);
        } catch (CupoExcedidoException e) {
            System.out.println(e.getMessage());
        }

        // Inscribir 2 estudiantes en Taller
        Inscripcion insc3 = taller.incribir(estudiante2);
        Inscripcion insc4 = taller.incribir(estudiante3);

        System.out.println(insc1);
        System.out.println(insc2);
        System.out.println(insc3);
        System.out.println(insc4);

        System.out.println("\n--- Resumen de eventos y actividades ---");
        evento.mostrarDatos();
        for (Actividad actividad : evento.getActividades()) {
            actividad.mostrarIdentificacion();
            System.out.println("Inscripciones: " + actividad.getInscripciones().size());
            for (Inscripcion i : actividad.getInscripciones()) {
                System.out.println(" - " + i);
            }
        }

        System.out.println("\n--- Total de eventos creados ---");
        System.out.println(EventoUniversitario.getCantidadEventos());

        System.out.println("--- Serializamos los datos ---");

        try {
            grabar(evento);
            leer("E1");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println(grabado ? "Datos grabados correctamente" : "No se pudo grabar datos" + " y " + (leido ? "datos leídos correctamente" : "no se pudo leer datos"));

        }

        System.out.println("--- Prueba de error ---");
        try {
            grabar(evento);
            leer("E5");
        } catch (Exception e) {
            System.out.println("Error al leer datos");
        } finally {
            System.out.println(grabado ? "Datos grabados correctamente" : "No se pudo grabar datos" + " y " + (leido ? "datos leídos correctamente" : "no se pudo leer datos"));

        }
    }
    public static void grabar(EventoUniversitario evento){
        // Delegar la persistencia al propio EventoUniversitario
        grabado = evento.persistirEvento();
    }

    public static void leer(String id){
        // Delegar la recuperación al propio EventoUniversitario
        EventoUniversitario evento = EventoUniversitario.recuperarEvento(id);
        if (evento != null) {
            leido = true;
            evento.mostrarDatos();
        } else {
            leido = false;
        }
    }
}
