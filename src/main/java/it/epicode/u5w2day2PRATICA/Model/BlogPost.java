package it.epicode.u5w2day2PRATICA.Model;

import lombok.Data;

@Data
public class BlogPost {
    private int id;
    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private int tempoDiLettura;
}