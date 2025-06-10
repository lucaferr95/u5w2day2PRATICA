package it.epicode.u5w2day2PRATICA.Controller;


import it.epicode.u5w2day2PRATICA.Model.Autore;
import it.epicode.u5w2day2PRATICA.Service.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autori")
public class AutoreController {

    @Autowired
    private AutoreService autoreService;

    @PostMapping
    public Autore creaAutore(@RequestBody Autore autore) {
        return autoreService.saveAutore(autore);
    }

    @GetMapping
    public List<Autore> getAllAutori() {
        return autoreService.getAutori();
    }
}