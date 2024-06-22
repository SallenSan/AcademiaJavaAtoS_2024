package org.example;

import org.example.entidades.Pessoal;
import org.example.entidades.Profissional;

import java.time.LocalDate;
import java.time.LocalTime;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        LocalDate data = LocalDate.of(2024, 6, 10);
        LocalTime hora = LocalTime.of(8, 30);

        // Criando compromisso profisional
        Profissional compromisso = new Profissional();
        compromisso.setNomeCompromisso("reunião");
        compromisso.setDataCompromisso(LocalDate.of(2024, 6, 9));
        compromisso.setHoraCompromisso(LocalTime.of(8, 00));
        compromisso.exibeCompromissoProfissional(compromisso);

        System.out.println();

        // Criando compromisso pessoal
        Pessoal compromissoPessoal = new Pessoal();
        compromissoPessoal.setNomeCompromisso("jantar");
        compromissoPessoal.setDataCompromisso(LocalDate.of(2024, 6, 15));
        compromissoPessoal.setHoraCompromisso(LocalTime.of(20, 30));
        compromissoPessoal.exibeCompromissoPessoal(compromissoPessoal);

    }
}