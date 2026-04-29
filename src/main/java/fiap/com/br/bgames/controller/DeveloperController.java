package fiap.com.br.bgames.controller;

import fiap.com.br.bgames.entity.Developer;
import fiap.com.br.bgames.repository.DeveloperRepository;
import fiap.com.br.bgames.service.DeveloperService;
import fiap.com.br.bgames.summary.DeveloperSummary;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("developers")
public class DeveloperController {
    @Autowired
    private DeveloperService developerService;
    @Autowired
    private DeveloperRepository developerRepository;

    @GetMapping
    public Page<Developer> listAllDevelopers(@PageableDefault Pageable pageable){
        return  developerService.getAllDeveloper(pageable);
    }

    @PostMapping
    public ResponseEntity<Developer> create(@RequestBody @Valid Developer developer){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(developerService.addDeveloper(developer));
    }

    @GetMapping("{id}")
    public ResponseEntity<Developer> getDeveloperById(@PathVariable Long id){
        log.info("Obtendo dados da Developer {}", id);
        return ResponseEntity.ok(developerService.getDeveloperById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteDeveloper(@PathVariable Long id){
        log.info("Deletando Developer com id {}", id );
        developerService.deleteDeveloper(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Developer> updateDeveloper(@PathVariable Long id, @RequestBody Developer developer){
        log.info("Atualizando Developer com id {} com os dados {}", id, developer);
        return ResponseEntity.ok( developerService.updateDeveloper(id, developer) );
    }

    @GetMapping("search")
    public List<DeveloperSummary> seachByName(@RequestParam String name) {
        return developerRepository.findByNameContainingIgnoreCase(name);
    }
}
