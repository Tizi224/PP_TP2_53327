package dev.tizi224.Ej2.modelo.certificacion;
import dev.tizi224.Ej2.modelo.Estudiante;

public interface Certificable {
    String ENTIDAD_EMISORA = "UTN";

    String generarCertificado(Estudiante estudiante);
}

