package br.com.github.edumaxsantos.dspesquisa.repositories;

import br.com.github.edumaxsantos.dspesquisa.entities.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
}
