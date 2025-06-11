package it.epicode.u5w2day2PRATICA.Controller;


import it.epicode.u5w2day2PRATICA.Exception.NotFoundException;
import it.epicode.u5w2day2PRATICA.Model.Autore;
import it.epicode.u5w2day2PRATICA.Service.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class AutoreController {

    @Autowired
    private AutoreService autoreService;

    @PostMapping("/autori")
    @ResponseStatus(HttpStatus.CREATED)
    public Autore saveAutore(@RequestBody Autore autore) {
        return autoreService.saveAutore(autore);
    }

    @GetMapping ("/autori")
    public List<Autore> getAllAutori() {
        return autoreService.getAutori();
    }
    @GetMapping("/autori/{id}")
    public Autore getAutore(@PathVariable int id) throws NotFoundException {
        return autoreService.getAutore(id);
    }


    @PutMapping("/autori/{id}")

    public Autore updateAutore(@PathVariable int id, @RequestBody Autore autore) throws NotFoundException{
        return autoreService.updateAutore(id, autore);
    }

    @DeleteMapping("/autori")
    public void deleteAutore (@PathVariable int id) throws NotFoundException{
    autoreService.deleteAutore(id);
    }


}