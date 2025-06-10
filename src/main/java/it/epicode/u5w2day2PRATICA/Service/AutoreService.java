package it.epicode.u5w2day2PRATICA.Service;


import it.epicode.u5w2day2PRATICA.Model.Autore;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AutoreService {
    private List<Autore> autori = new ArrayList<>();

    public Autore saveAutore(Autore autore) {
        autore.setId(new Random().nextInt(1, 10000));

        if (autore.getAvatar() == null || autore.getAvatar().isBlank()) {
            String nome = autore.getNome().replace(" ", "+");
            String cognome = autore.getCognome().replace(" ", "+");
            autore.setAvatar("https://ui-avatars.com/api/?name=" + nome + "+" + cognome);
        }

        autori.add(autore);
        return autore;
    }

    public List<Autore> getAutori() {
        return autori;
    }
}