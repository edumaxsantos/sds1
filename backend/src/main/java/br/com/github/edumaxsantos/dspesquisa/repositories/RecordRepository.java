package br.com.github.edumaxsantos.dspesquisa.repositories;

import br.com.github.edumaxsantos.dspesquisa.entities.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record, Long> {
}
