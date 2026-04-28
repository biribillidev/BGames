package fiap.com.br.bgames.service;

import fiap.com.br.bgames.dto.GameRequest;
import fiap.com.br.bgames.dto.GameResponse;
import fiap.com.br.bgames.entity.Category;
import fiap.com.br.bgames.entity.Developer;
import fiap.com.br.bgames.entity.Game;
import fiap.com.br.bgames.repository.CategoryRepository;
import fiap.com.br.bgames.repository.DeveloperRepository;
import fiap.com.br.bgames.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;
    private final DeveloperRepository developerRepository;
    private final CategoryRepository categoryRepository;

    public GameResponse create(GameRequest request) {

        Developer developer = developerRepository.findById(request.developerId())
                .orElseThrow(() -> new RuntimeException("Developer não encontrado"));

        List<Category> categories = categoryRepository.findAllById(request.categoryIds());

        Game game = request.toEntity(developer, categories);

        return GameResponse.fromEntity(gameRepository.save(game));
    }

    public List<GameResponse> findAll() {
        return gameRepository.findAll()
                .stream()
                .map(GameResponse::fromEntity)
                .toList();
    }

    public GameResponse findById(Long id) {
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Game não encontrado"));

        return GameResponse.fromEntity(game);
    }

    public GameResponse update(Long id, GameRequest request) {

        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Game não encontrado"));

        Developer developer = developerRepository.findById(request.developerId())
                .orElseThrow(() -> new RuntimeException("Developer não encontrado"));

        List<Category> categories = categoryRepository.findAllById(request.categoryIds());

        game.setName(request.name());
        game.setPlatform(request.platform());
        game.setReleaseDate(request.releaseDate());
        game.setDeveloper(developer);
        game.setCategories(categories);

        return GameResponse.fromEntity(gameRepository.save(game));
    }

    public void delete(Long id) {
        gameRepository.deleteById(id);
    }
}