package org.example.interfaces;

import java.time.LocalDate;
import java.time.LocalTime;

public interface Acesso {
    String getNomeCompromisso();
    LocalDate getDataCompromisso();
    LocalTime getHoraCompromisso();
}
