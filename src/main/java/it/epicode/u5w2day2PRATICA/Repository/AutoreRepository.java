package it.epicode.u5w2day2PRATICA.Repository;

import it.epicode.u5w2day2PRATICA.Model.Autore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AutoreRepository extends JpaRepository <Autore, Integer>, PagingAndSortingRepository <Autore, Integer> {
}
