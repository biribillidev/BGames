package fiap.com.br.bgames.dto;

import fiap.com.br.bgames.entity.Category;

public record CategoryResponse(
        Long id,
        String name,
        String description,
        Boolean active
) {
    public static CategoryResponse fromEntity(Category category){
        return new CategoryResponse(
                category.getId(),
                category.getName(),
                category.getDescription(),
                category.getActive()
        );
    }
}
