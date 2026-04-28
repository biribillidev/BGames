package fiap.com.br.bgames.dto;

import fiap.com.br.bgames.entity.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CategoryRequest(
        @NotBlank(message = "O nome da categoria é obrigatório")
        @Size(min = 3, max = 50)
        String name,

        @NotBlank(message = "A descrição da categoria é obrigatória")
        @Size(min = 10, max = 100)
        String description,

        @NotNull(message = "O status ativo é obrigatório")
        Boolean active

){
        public Category toEntity(){
                return Category.builder()
                        .name(name)
                        .description(description)
                        .active(active)
                        .build();
        }
}
