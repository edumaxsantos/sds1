package br.com.github.edumaxsantos.dspesquisa.repositories;

import br.com.github.edumaxsantos.dspesquisa.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
