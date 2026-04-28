package fiap.com.br.bgames.dto;

import fiap.com.br.bgames.entity.Category;
import fiap.com.br.bgames.entity.Developer;
import fiap.com.br.bgames.entity.Game;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;

public record GameRequest(

        @NotBlank(message = "O nome do jogo é obrigatório")
        @Size(min = 2, max = 100)
        String name,

        @NotBlank(message = "A plataforma é obrigatória")
        String platform,

        @NotNull(message = "A data de lançamento é obrigatória")
        LocalDate releaseDate,

        @NotNull(message = "O developer é obrigatório")
        Long developerId,

        @NotNull(message = "As categorias são obrigatórias")
        List<Long> categoryIds

) {
    public Game toEntity(Developer developer, List<Category> categories) {
        return Game.builder()
                .name(name)
                .platform(platform)
                .releaseDate(releaseDate)
                .developer(developer)
                .categories(categories)
                .build();
    }
}