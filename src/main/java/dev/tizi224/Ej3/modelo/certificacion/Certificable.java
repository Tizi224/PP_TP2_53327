package dev.tizi224.Ej3.modelo.certificacion;

import dev.tizi224.Ej3.modelo.Estudiante;

public interface Certificable {
    String ENTIDAD_EMISORA = "UTN";

    String generarCertificado(Estudiante estudiante);
}

