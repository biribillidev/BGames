package fiap.com.br.bgames.service;

import fiap.com.br.bgames.entity.Game;
import fiap.com.br.bgames.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public Game addGame(Game game){
        return gameRepository.save(game);
    }

    public Page<Game> getAllGames(Pageable pageable) {
        return gameRepository.findAll(pageable);
    }

    public Game getGameById(Long id){
        return findGameById(id);
    }

    public void deleteGame(Long id) {
        findGameById(id);
        gameRepository.deleteById(id);
    }

    public Game updateGame(Long id, Game newGame) {
        findGameById(id);
        newGame.setId(id);
        return gameRepository.save(newGame);
    }

    private Game findGameById(Long id) {
        return gameRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Game com id " + id + " não encontrada")
        );
    }
}