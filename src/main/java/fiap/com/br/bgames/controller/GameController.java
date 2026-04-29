package fiap.com.br.bgames.controller;

import fiap.com.br.bgames.entity.Developer;
import fiap.com.br.bgames.entity.Game;
import fiap.com.br.bgames.repository.DeveloperRepository;
import fiap.com.br.bgames.repository.GameRepository;
import fiap.com.br.bgames.service.DeveloperService;
import fiap.com.br.bgames.service.GameService;
import fiap.com.br.bgames.summary.DeveloperSummary;
import fiap.com.br.bgames.summary.GameSummary;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("games")
public class GameController {
    @Autowired
    private GameService gameService;
    @Autowired
    private GameRepository gameRepository;

    @GetMapping
    public Page<Game> listAllGames(@PageableDefault Pageable pageable){
        return gameService.getAllGames(pageable);
    }

    @PostMapping
    public ResponseEntity<Game> create(@RequestBody @Valid Game game){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(gameService.addGame(game));
    }

    @GetMapping("{id}")
    public ResponseEntity<Game> getGameById(@PathVariable Long id){
        log.info("Obtendo dados do Game {}", id);
        return ResponseEntity.ok(gameService.getGameById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteGame(@PathVariable Long id){
        log.info("Deletando Game com id {}", id );
        gameService.deleteGame(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Game> updateGame(@PathVariable Long id, @RequestBody Game game){
        log.info("Atualizando Game com id {} com os dados {}", id, game);
        return ResponseEntity.ok( gameService.updateGame(id, game) );
    }

    @GetMapping("search")
    public List<Game> searchByName(@RequestParam String name) {
        return gameService.searchByName(name);
    }

    @GetMapping("by-platform")
    public List<Game> findByPlatform(@RequestParam String platform) {
        return gameService.findByPlatform(platform);
    }

    @GetMapping("by-developer")
    public List<Game> findByDeveloperName(@RequestParam String name) {
        return gameService.findByDeveloperName(name);
    }

    @GetMapping("by-category")
    public List<Game> findByCategoryName(@RequestParam String name) {
        return gameService.findByCategoryName(name);
    }

    @GetMapping("released-after")
    public List<Game> findReleasedAfter(@RequestParam LocalDate date) {
        return gameService.findReleasedAfter(date);
    }

    @GetMapping("summary")
    public List<GameSummary> getSummary(@RequestParam String name) {
        return gameService.searchSummaryByName(name);
    }
}
