package it.epicode.u5w2day2PRATICA.Service;


import it.epicode.u5w2day2PRATICA.Exception.NotFoundException;
import it.epicode.u5w2day2PRATICA.Model.Autore;
import it.epicode.u5w2day2PRATICA.Repository.AutoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AutoreService {
    @Autowired
    AutoreRepository autoreRepository;

    @Autowired
    private BlogPostService blogPostService;

    public Autore saveAutore(Autore autore) {
        autore.setId(new Random().nextInt(1, 10000));
        autore.setAvatar("https://ui-avatars.com/api/?name=" + autore.getNome() + "+" + autore.getCognome());
        autori.add(autore);
        return autore;
    }

    public List<Autore> getAutori() {
        return autori;
    }

    public Autore getAutore(int id) throws NotFoundException {
        return autori.stream()
                .filter(autore -> autore.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Autore con id: " + id + " non trovato"));
    }


    public Autore updateAutore(int id, Autore autore) throws NotFoundException {
        Autore autoreDaAggiornare = getAutore(id);

        autoreDaAggiornare.setNome(autore.getNome());
        autoreDaAggiornare.setEmail(autore.getEmail());
        autoreDaAggiornare.setCognome(autore.getCognome());
        autoreDaAggiornare.setDataNascita(autore.getDataNascita());

        return autoreDaAggiornare;

    }

    public void deleteAutore(int id) throws NotFoundException {
        Autore autoreDaRimuovere = getAutore(id);
        autori.remove(autoreDaRimuovere);
    }
}