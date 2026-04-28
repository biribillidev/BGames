package fiap.com.br.bgames.service;

import fiap.com.br.bgames.dto.CategoryRequest;
import fiap.com.br.bgames.dto.CategoryResponse;
import fiap.com.br.bgames.entity.Category;
import fiap.com.br.bgames.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryResponse create(CategoryRequest request) {
        Category category = request.toEntity();
        return CategoryResponse.fromEntity(repository.save(category));
    }

    public List<CategoryResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(CategoryResponse::fromEntity)
                .toList();
    }

    public CategoryResponse findById(Long id) {
        Category category = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        return CategoryResponse.fromEntity(category);
    }

    public CategoryResponse update(Long id, CategoryRequest request) {
        Category category = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        category.setName(request.name());
        category.setDescription(request.description());
        category.setActive(request.active());

        return CategoryResponse.fromEntity(repository.save(category));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}