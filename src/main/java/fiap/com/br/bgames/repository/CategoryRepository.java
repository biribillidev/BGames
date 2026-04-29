package fiap.com.br.bgames.repository;

import fiap.com.br.bgames.entity.Category;
import fiap.com.br.bgames.entity.Developer;
import fiap.com.br.bgames.summary.CategorySummary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<CategorySummary> findByTitleContainingIgnoreCase(String name);
}
