package br.com.github.edumaxsantos.dspesquisa.resources;

import br.com.github.edumaxsantos.dspesquisa.dto.RecordDTO;
import br.com.github.edumaxsantos.dspesquisa.dto.RecordInsertDTO;
import br.com.github.edumaxsantos.dspesquisa.services.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

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

    @GetMapping
    public ResponseEntity<Page<RecordDTO>> findAll(
            @RequestParam(value = "min", defaultValue = "") String min,
            @RequestParam(value = "max", defaultValue = "") String max,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "0") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "moment") String orderBy,
            @RequestParam(value = "direction", defaultValue = "DESC") String direction) {

        LocalDateTime minDate = min.isBlank() ? null : LocalDateTime.parse(min, DateTimeFormatter.ISO_DATE_TIME);
        LocalDateTime maxDate = max.isBlank() ? null : LocalDateTime.parse(max, DateTimeFormatter.ISO_DATE_TIME);

        if(linesPerPage == 0) {
            linesPerPage = Integer.MAX_VALUE;
        }

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);

        Page<RecordDTO> list = service.findByMoments(minDate, maxDate, pageRequest);
        return ResponseEntity.ok(list);
    }
}
