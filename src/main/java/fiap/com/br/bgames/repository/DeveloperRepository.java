package fiap.com.br.bgames.repository;

import fiap.com.br.bgames.entity.Developer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long> {

    Page<Developer> findByNameContainingIgnoreCase(String name, Pageable pageable);
}
