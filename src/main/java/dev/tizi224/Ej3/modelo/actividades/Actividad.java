package dev.tizi224.Ej3.modelo.actividades;

import dev.tizi224.Ej1.excepciones.CupoExcedidoException;
import dev.tizi224.Ej3.modelo.Estudiante;
import dev.tizi224.Ej3.modelo.Inscripcion;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Actividad implements Serializable {
    private int id;
    private String titulo;
    private int cupoMaximo;
    // inscripciones representan la composición entre Actividad e Inscripcion
    private List<Inscripcion> inscripciones = new ArrayList<>();

    public Actividad(int id, String titulo, int cupoMaximo) {
        this.id = id;
        this.titulo = titulo;
        this.cupoMaximo = cupoMaximo;
    }
    public double calcularCostoMateriales(){return 0.0;}
    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getTipo(){return "Actividad";}
    public int getCupoMaximo() { return cupoMaximo; }
    public List<Inscripcion> getInscripciones() { return inscripciones; }

    public Inscripcion incribir(Estudiante estudiante) throws CupoExcedidoException {
        if (inscripciones.size() < cupoMaximo) {
            Inscripcion ins = new Inscripcion(LocalDate.now(), "Inscrito", estudiante, this);
            inscripciones.add(ins);
            return ins;
        }else{
            throw new CupoExcedidoException("Cupo excedido para la actividad: " + titulo);
        }

    }
    public final void mostrarIdentificacion(){
        System.out.println("ID: " + id + ", Título: " + titulo);
    }

    @Override
    public String toString() {
        return "Actividad{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", cupoMaximo=" + cupoMaximo +
                ", inscripcionesCount=" + inscripciones.size() +
                '}';
    }
}
