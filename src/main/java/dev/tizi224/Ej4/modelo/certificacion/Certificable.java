package dev.tizi224.Ej4.modelo.certificacion;

import dev.tizi224.Ej4.modelo.Estudiante;

public interface Certificable {
    String ENTIDAD_EMISORA = "UTN";

    String generarCertificado(Estudiante estudiante);
}

