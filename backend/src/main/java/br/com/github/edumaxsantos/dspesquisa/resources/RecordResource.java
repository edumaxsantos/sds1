package br.com.github.edumaxsantos.dspesquisa.resources;

import br.com.github.edumaxsantos.dspesquisa.dto.RecordDTO;
import br.com.github.edumaxsantos.dspesquisa.dto.RecordInsertDTO;
import br.com.github.edumaxsantos.dspesquisa.services.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/records")
public class RecordResource {

    @Autowired
    private RecordService service;

    @PostMapping
    public ResponseEntity<RecordDTO> insert(@RequestBody RecordInsertDTO dto) {
        RecordDTO newDTO = service.insert(dto);
        return ResponseEntity.ok(newDTO);
    }
}
