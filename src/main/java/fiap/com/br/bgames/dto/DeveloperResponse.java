package fiap.com.br.bgames.dto;

import fiap.com.br.bgames.entity.Developer;

import java.time.LocalDate;

public record DeveloperResponse(
        Long id,
        String name,
        LocalDate foundedDate,
        Boolean active
) {

    public static DeveloperResponse fromEntity(Developer developer) {
        return new DeveloperResponse(
                developer.getId(),
                developer.getName(),
                developer.getFoundedDate(),
                developer.getActive()
        );
    }
}