package fiap.com.br.bgames.dto;

import fiap.com.br.bgames.entity.Developer;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record DeveloperRequest(

        @NotBlank(message = "O nome da desenvolvedora é obrigatório")
        @Size(min = 2, max = 100)
        String name,

        @NotNull(message = "A data de fundação é obrigatória")
        @PastOrPresent(message = "A data de fundação não pode ser no futuro")
        LocalDate foundedDate,

        @NotNull(message = "O status ativo é obrigatório")
        boolean active
) {
        public Developer toEntity() {
                return Developer.builder()
                        .name(name)
                        .foundedDate(foundedDate)
                        .active(active)
                        .build();
        }
}
