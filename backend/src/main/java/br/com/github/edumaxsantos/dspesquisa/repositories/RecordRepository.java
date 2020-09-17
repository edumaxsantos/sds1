package br.com.github.edumaxsantos.dspesquisa.repositories;


import br.com.github.edumaxsantos.dspesquisa.entities.Record;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {

    @Query("SELECT obj FROM Record obj WHERE (coalesce(:min, null) IS NULL OR obj.moment >= :min) AND (coalesce(:max, null) IS NULL OR obj.moment <= :max)")
    Page<Record> findByMoments(LocalDateTime min, LocalDateTime max, Pageable pageable);
}
