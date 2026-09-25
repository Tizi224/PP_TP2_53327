<img width="1579" height="852" alt="image" src="https://github.com/user-attachments/assets/ce53f5ce-9372-416a-a561-68f221cfc0bf" /># Trabajo Práctico 2 - Paradigmas de Programación
## Organización, reutilización y recursos avanzados en POO

**Autor:** Tiziano Contino  
**Legajo:** 53327  
**Universidad:** Universidad Tecnológica Nacional - Facultad Regional Mendoza (UTN FRM)  
**Carrera:** Ingeniería en Sistemas de Información  

---

## Descripción del Proyecto
Este proyecto es un sistema de gestión de eventos universitarios desarrollado en Java. El sistema permite la administración de eventos, asignación de salas, creación de distintas actividades (Charlas, Talleres y Cursos) y la inscripción de estudiantes. 

El objetivo principal de este trabajo es aplicar conceptos avanzados de Programación Orientada a Objetos (POO) para lograr un sistema robusto, escalable y tolerante a fallos.

## Funcionalidades Implementadas

El desarrollo se divide en cuatro grandes módulos según los requerimientos del trabajo práctico:

1. **Manejo de Excepciones y Persistencia (Ejercicio 1):**
   - Implementación de excepciones personalizadas (`CupoExcedidoException`) para controlar el límite de inscripciones en las actividades.
   - Gestión de persistencia de datos mediante serialización y deserialización de los objetos `EventoUniversitario`, incluyendo tolerancia a fallos de lectura/escritura (I/O).

2. **Interfaces y Certificación (Ejercicio 2):**
   - Uso de la interfaz `Certificable` para desacoplar la lógica de emisión de certificados.
   - Emisión de certificados exclusiva para actividades prácticas (`Taller` y `Curso`), restringiendo esta funcionalidad para las clases teóricas (`Charla`).

3. **Genéricos y Wildcards (Ejercicio 3):**
   - Implementación de métodos parametrizados (`<T extends Actividad>`) para filtrar de manera dinámica las listas de actividades según su tipo concreto.
   - Uso de wildcards (`List<? extends Actividad>`) para calcular los costos de materiales de colecciones heterogéneas de actividades de forma segura.

4. **Concurrencia y Clases Anidadas (Ejercicio 4):**
   - Modelado de la clase `TicketDeAcceso` como una clase anidada dentro de `Inscripcion`, garantizando que un ticket solo exista bajo el contexto de una inscripción confirmada.
   - Implementación de la clase `EnvioTicketsThread` para ejecutar el envío de tickets en un hilo secundario (multithreading), permitiendo que el hilo principal del programa siga mostrando información del evento de forma asíncrona.

## Estructura de Paquetes
El proyecto está modularizado de la siguiente manera para garantizar un correcto encapsulamiento:
- `modelo`: Clases principales del dominio (`EventoUniversitario`, `Sala`, `Estudiante`, `Inscripcion`).
- `actividades`: Tipos de actividades y jerarquía de herencia (`Actividad`, `Charla`, `Taller`, `Curso`).
- `excepciones`: Clases de manejo de errores personalizados.
- `certificacion`: Interfaces para la emisión de documentos.
- `hilos`: Clases encargadas de la ejecución concurrente.

## Ejecución del Programa
El código fuente está diseñado para ser ejecutado desde la clase principal `App.java`. 

1. Clonar este repositorio vía HTTPS:
   ```bash
   git clone [https://github.com/Tizi224/PP_TP2_53327.git](https://github.com/Tizi224/PP_TP2_53327.git)

Abrir el proyecto en IntelliJ IDEA.   
Ejecutar la clase App.java. El programa mostrará por consola el flujo completo de creación, inscripción, persistencia, generación de certificados y envío de tickets en hilos paralelos.

<img width="1798" height="833" alt="image" src="https://github.com/user-attachments/assets/0e7a31d7-84ff-45ff-9e13-a4b206bd372e" />
<img width="1795" height="854" alt="image" src="https://github.com/user-attachments/assets/908a75c9-a590-474f-9d43-fe5824dd9d0b" />
<img width="596" height="167" alt="image" src="https://github.com/user-attachments/assets/62da1b73-1e2c-4090-965c-eb1888d5604d" />


