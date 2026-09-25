package dev.tizi224.Ej2.modelo;

import dev.tizi224.Ej2.modelo.actividades.Actividad;
import dev.tizi224.Ej2.modelo.actividades.Charla;
import dev.tizi224.Ej2.modelo.actividades.Taller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EventoUniversitario implements Serializable {

    private String id;
    private String titulo;
    private double costoBase;
    private boolean gratuito;
    public Sala salaAsignada;
    List<Actividad> actividades = new ArrayList<>();

    private static int cantidadEventos = 0;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getCostoBase() {
        return costoBase;
    }

    public void setCostoBase(double costoBase) {
        this.costoBase = costoBase;
    }

    public boolean isGratuito() {
        return gratuito;
    }

    public void setGratuito(boolean gratuito) {
        this.gratuito = gratuito;
    }

    public String getId() {
        return id;
    }
    public EventoUniversitario(String id, String titulo, double costoBase, boolean gratuito) {
        this.id = id;
        this.titulo = titulo;
        this.costoBase = costoBase;
        this.gratuito = gratuito;
        cantidadEventos++;
    }

    public EventoUniversitario(EventoUniversitario otro){
        this.id = otro.id;
        this.titulo = otro.titulo;
        this.costoBase = otro.costoBase;
        this.gratuito = otro.gratuito;
        cantidadEventos++;
    }

    public double calcularCostoEstimado(){
        if (gratuito) {
            return 0.0;
        }

        double costoActividades = 0;
        for (Actividad actividad : actividades) {
            if (actividad instanceof Taller) {
                costoActividades += ((Taller) actividad).calcularCostoMateriales();
            } else if (actividad instanceof Charla) {
                costoActividades += ((Charla) actividad).calcularCostoMateriales();
            }
        }

        return (costoBase + costoActividades) * 1.21;
    }
    public Actividad crearActividad(int id, String titulo, int cupoMaximo, String tipo) {
        if ("Taller".equals(tipo)) {
            return new Taller(id, titulo, cupoMaximo);
        } else if ("Charla".equals(tipo)) {
            return new Charla(id, titulo, cupoMaximo, "Disertante");
        }
        return null;
    }

    public void agregarSala(Sala sala){
        if (sala == null) {
            System.out.println("Sala no puede ser null");
            return;
        }
        this.salaAsignada = sala;
        System.out.println("El evento " + this.titulo + " se asignó a la sala con id " + sala.salaId);
    }

    public void agregarActividad(Actividad actividad) {
        if (actividad == null) {
            System.out.println("La actividad no puede ser null");
            return;
        }
        this.actividades.add(actividad);
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void mostrarDatos(){
        System.out.println(this.toString());
    }
    public static int getCantidadEventos(){
        return cantidadEventos;
    }

    @Override
    public String toString() {
        return "EventoUniversitario{" +
                "id='" + id + '\'' +
                ", titulo='" + titulo + '\'' +
                ", costoBase=" + costoBase +
                ", gratuito=" + gratuito +
                ", salaAsignada=" + (salaAsignada == null ? "No asignada" : salaAsignada.toString()) +
                ", actividades=" + actividades +
                '}';
    }

    public void asignarSala(int salaId) {
        System.out.println("El evento " + this.titulo + " se asignó a la sala con id " + salaId);
    }

    public double calcularCostoMateriales(List<? extends Actividad> actividades){
        double costoTotal = 0;
        for(Actividad actividad : actividades){
            costoTotal += actividad.calcularCostoMateriales();
        }
        return costoTotal;
    }

    // Persiste este evento en un archivo usando serialización
    public boolean persistirEvento() {
        try (FileOutputStream fos = new FileOutputStream("datosid" + this.id + ".dat");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(this);
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo");
        } catch (IOException e) {
            System.out.println("No se pudo grabar el archivo");
        }
        return false;
    }

    // Recupera un evento desde archivo; devuelve null si falla
    public static EventoUniversitario recuperarEvento(String id) {
        try (FileInputStream fis = new FileInputStream("datosid" + id + ".dat");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            EventoUniversitario evento = (EventoUniversitario) ois.readObject();
            return evento;
        } catch (FileNotFoundException e) {
            System.out.println("No se encontro el archivo");
        } catch (IOException e) {
            System.out.println("Error al leer datos");
        } catch (ClassNotFoundException e) {
            System.out.println("No se encontró la clase");
        }
        return null;
    }
}
