package it.epicode.u5w2day2PRATICA.Service;


import it.epicode.u5w2day2PRATICA.Dto.AutoreDto;
import it.epicode.u5w2day2PRATICA.Exception.NotFoundException;
import it.epicode.u5w2day2PRATICA.Model.Autore;
import it.epicode.u5w2day2PRATICA.Repository.AutoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class AutoreService {
    @Autowired
    AutoreRepository autoreRepository;

    public Autore saveAutore(AutoreDto autoreDto) {
        Autore autore = new Autore();
        autore.setNome(autoreDto.getNome());
        autore.setCognome(autoreDto.getCognome());
        autore.setEmail(autoreDto.getEmail());
        autore.setDataNascita(autoreDto.getDataNascita());

        if (autoreDto.getAvatar() == null || autoreDto.getAvatar().isBlank()) {
            String nomeCompleto = autoreDto.getNome() + "+" + autoreDto.getCognome();
            autore.setAvatar("https://ui-avatars.com/api/?name=" + nomeCompleto);
        } else {
            autore.setAvatar(autoreDto.getAvatar());
        }

        return autoreRepository.save(autore);
    }


    public Page<Autore> getAllAutori(int page, int size, String sortBy) {

        PageRequest pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return autoreRepository.findAll(pageable);
    }

    public Autore getAutore(int id) throws NotFoundException {
        return autoreRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Autore con id: " + id + " non trovato"));
    }


    public Autore updateAutore(int id, AutoreDto autoreDto) throws NotFoundException {
        Autore autoreDaAggiornare = getAutore(id);

        autoreDaAggiornare.setNome(autoreDto.getNome());
        autoreDaAggiornare.setEmail(autoreDto.getEmail());
        autoreDaAggiornare.setCognome(autoreDto.getCognome());
        autoreDaAggiornare.setDataNascita(autoreDto.getDataNascita());

        return autoreRepository.save(autoreDaAggiornare);

    }

    public void deleteAutore(int id) throws NotFoundException {
        Autore autoreDaRimuovere = getAutore(id);
        autoreRepository.delete(autoreDaRimuovere);
    }
}