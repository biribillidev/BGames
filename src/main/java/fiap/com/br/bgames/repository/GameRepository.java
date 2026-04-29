package fiap.com.br.bgames.repository;

import fiap.com.br.bgames.entity.Game;
import fiap.com.br.bgames.summary.GameSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    List<Game> findByNameContainingIgnoreCase(String name);

    List<Game> findByPlatformContainingIgnoreCase(String platform);

    List<Game> findByDeveloperNameContainingIgnoreCase(String developerName);

    List<Game> findByCategoriesNameContainingIgnoreCase(String categoryName);

    List<Game> findByReleaseDateAfter(LocalDate date);

    List<GameSummary> findSummaryByNameContainingIgnoreCase(String name);
}
