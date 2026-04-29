package fiap.com.br.bgames.repository;

import fiap.com.br.bgames.entity.Developer;
import fiap.com.br.bgames.summary.CategorySummary;
import fiap.com.br.bgames.summary.DeveloperSummary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long> {

    List<DeveloperSummary> findByTitleContainingIgnoreCase(String title);
}
