package br.com.github.edumaxsantos.dspesquisa.repositories;

import br.com.github.edumaxsantos.dspesquisa.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
}
