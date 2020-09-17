package br.com.github.edumaxsantos.dspesquisa.services;

import br.com.github.edumaxsantos.dspesquisa.dto.GameDTO;
import br.com.github.edumaxsantos.dspesquisa.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    @Autowired
    private GameRepository repository;

    @Transactional(readOnly = true)
    public List<GameDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(GameDTO::new)
                .collect(Collectors.toList());
    }
}
