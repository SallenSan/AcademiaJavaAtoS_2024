package org.example.entidades;

import org.example.interfaces.Acesso;

import java.time.LocalDate;
import java.time.LocalTime;

public class Profissional extends Compromisso implements Acesso {

    public Profissional() {
    }

    public Profissional(String nomeCompromisso, LocalDate dataCompromisso, LocalTime horaCompromisso) {
        super(nomeCompromisso, dataCompromisso, horaCompromisso);
    }

    @Override
    public String getNomeCompromisso() {
        return super.getNomeCompromisso();
    }

    @Override
    public LocalDate getDataCompromisso() {
        return super.getDataCompromisso();
    }

    @Override
    public LocalTime getHoraCompromisso() {
        return super.getHoraCompromisso();
    }

    public void exibeCompromissoProfissional(Acesso acesso) {
        System.out.println("Compromisso profissional: ");
        System.out.println("Nome do compromisso: " + acesso.getNomeCompromisso());
        System.out.println("Data do compromisso: " + acesso.getDataCompromisso());
        System.out.println("Hora do compromisso: " + acesso.getHoraCompromisso());

    }
}
