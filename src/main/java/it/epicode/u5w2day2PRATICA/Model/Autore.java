package it.epicode.u5w2day2PRATICA.Model;

import lombok.Data;

import java.time.LocalDate;

@Data

public class Autore {
    private int id;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataNascita;
    private String avatar;
}
