package com.example.APIClassRoom.ayudas;

public enum MensajesAPI {
    ESTUDINATE_NO_ENCONTRADO("El estudiante no se encuentra"),
    DOCENTE_NO_ENCOTRADO("El docente que buscas no se encuetra en la BD"),
    ASISTENCIA_NO_ENCONTRADA("Asistencia no encontrada"),
    CALIFICACION_NO_ENCONTRADA("Calificacion no encontrada"),
    MATERIA_NO_ENCONTRADA("Materia no encontrada"),
    CURSO_NO_ENCONTRADO("Curso no encontrado"),
    INSCRIPCION_NO_ENCONTRADA("Inscripcion no encontrada "),
    USUARIO_NO_ENCONTRADO("Usuario no encontrado ");

    private String texto;

    MensajesAPI(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }
}
