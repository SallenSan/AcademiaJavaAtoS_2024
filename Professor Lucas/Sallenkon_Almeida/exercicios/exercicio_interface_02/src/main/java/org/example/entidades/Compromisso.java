package org.example.entidades;

import java.time.LocalDate;
import java.time.LocalTime;

public class Compromisso {
    private String nomeCompromisso;
    private LocalDate dataCompromisso;
    private LocalTime horaCompromisso;

    public Compromisso() {

    }

    public Compromisso(String nomeCompromisso, LocalDate dataCompromisso, LocalTime horaCompromisso) {
        this.nomeCompromisso = nomeCompromisso;
        this.dataCompromisso = dataCompromisso;
        this.horaCompromisso = horaCompromisso;
    }

    public String getNomeCompromisso() {
        return nomeCompromisso;
    }

    public void setNomeCompromisso(String nomeCompromisso) {
        this.nomeCompromisso = nomeCompromisso;
    }

    public LocalDate getDataCompromisso() {
        return dataCompromisso;
    }

    public void setDataCompromisso(LocalDate dataCompromisso) {
        this.dataCompromisso = dataCompromisso;
    }

    public LocalTime getHoraCompromisso() {
        return horaCompromisso;
    }

    public void setHoraCompromisso(LocalTime horaCompromisso) {
        this.horaCompromisso = horaCompromisso;
    }
}
