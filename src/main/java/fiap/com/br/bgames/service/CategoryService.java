package fiap.com.br.bgames.service;

import fiap.com.br.bgames.entity.Category;
import fiap.com.br.bgames.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category addCategory(Category category){
        return categoryRepository.save(category);
    }

    public Page<Category> getAllCategories(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    public Category getCategoryById(Long id){
        return findCategoryById(id);
    }

    public void deleteCategory(Long id) {
        findCategoryById(id);
        categoryRepository.deleteById(id);
    }

    public Category updateCategory(Long id, Category newCategory) {
        findCategoryById(id);
        newCategory.setId(id);
        return categoryRepository.save(newCategory);
    }

    private Category findCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria com id " + id + " não encontrada")
        );
    }
}