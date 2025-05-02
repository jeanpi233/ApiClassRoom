package com.example.APIClassRoom.ayudas;

public enum MensajesAPI {
    ESTUDINATE_NO_ENCONTRADO("El estduiante no se encuentra"),
    DOCENTE_NO_ENCOTRADO("El docente que buscas no se encuetra en la BD");

    private String texto;

    MensajesAPI(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }
}
