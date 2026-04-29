package fiap.com.br.bgames.controller;

import fiap.com.br.bgames.entity.Category;
import fiap.com.br.bgames.repository.CategoryRepository;
import fiap.com.br.bgames.service.CategoryService;
import fiap.com.br.bgames.summary.CategorySummary;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public Page<Category> listAllCategories(@PageableDefault Pageable pageable){
        return  categoryService.getAllCategories(pageable);
    }

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody @Valid Category category){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(categoryService.addCategory(category));
    }

    @GetMapping("{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id){
        log.info("Obtendo dados da Category {}", id);
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
        log.info("Deletando Category com id {}", id );
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category){
        log.info("Atualizando Category com id {} com os dados {}", id, category);
        return ResponseEntity.ok( categoryService.updateCategory(id, category) );
    }

    @GetMapping("search")
    public List<CategorySummary> seachByTitle(@RequestParam String title) {
        return categoryRepository.findByTitleContainingIgnoreCase(title);
    }
}
