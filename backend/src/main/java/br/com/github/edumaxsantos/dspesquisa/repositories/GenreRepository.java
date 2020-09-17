package br.com.github.edumaxsantos.dspesquisa.repositories;

import br.com.github.edumaxsantos.dspesquisa.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
