package br.com.github.edumaxsantos.dspesquisa.services;

import br.com.github.edumaxsantos.dspesquisa.dto.RecordDTO;
import br.com.github.edumaxsantos.dspesquisa.dto.RecordInsertDTO;
import br.com.github.edumaxsantos.dspesquisa.entities.Game;
import br.com.github.edumaxsantos.dspesquisa.entities.Record;
import br.com.github.edumaxsantos.dspesquisa.repositories.GameRepository;
import br.com.github.edumaxsantos.dspesquisa.repositories.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RecordService {

    @Autowired
    private RecordRepository repository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional
    public RecordDTO insert(RecordInsertDTO dto) {
        Record entity = new Record();

        entity.setName(dto.getName());
        entity.setAge(dto.getAge());
        entity.setMoment(LocalDateTime.now());

        Game game = gameRepository.getOne(dto.getGameId());

        entity.setGame(game);

        Record saved = repository.save(entity);

        return new RecordDTO(saved);

    }


    @Transactional(readOnly = true)
    public Page<RecordDTO> findByMoments(LocalDateTime minDate, LocalDateTime maxDate, PageRequest pageRequest) {
        return repository.findByMoments(minDate, maxDate, pageRequest).map(RecordDTO::new);
    }
}
