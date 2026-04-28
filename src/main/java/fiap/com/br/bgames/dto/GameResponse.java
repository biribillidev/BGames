package fiap.com.br.bgames.dto;

import fiap.com.br.bgames.entity.Category;
import fiap.com.br.bgames.entity.Game;

import java.time.LocalDate;
import java.util.List;

public record GameResponse(
        Long id,
        String name,
        String platform,
        LocalDate releaseDate,
        String developer,
        List<String> categories
) {

    public static GameResponse fromEntity(Game game) {
        return new GameResponse(
                game.getId(),
                game.getName(),
                game.getPlatform(),
                game.getReleaseDate(),
                game.getDeveloper().getName(),
                game.getCategories()
                        .stream()
                        .map(Category::getName)
                        .toList()
        );
    }
}