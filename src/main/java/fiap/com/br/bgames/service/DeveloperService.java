package fiap.com.br.bgames.service;

import fiap.com.br.bgames.dto.DeveloperRequest;
import fiap.com.br.bgames.dto.DeveloperResponse;
import fiap.com.br.bgames.entity.Developer;
import fiap.com.br.bgames.repository.DeveloperRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeveloperService {

    private final DeveloperRepository repository;

    public DeveloperResponse create(DeveloperRequest request) {
        Developer developer = request.toEntity();
        return DeveloperResponse.fromEntity(repository.save(developer));
    }

    public List<DeveloperResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(DeveloperResponse::fromEntity)
                .toList();
    }

    public DeveloperResponse findById(Long id) {
        Developer developer = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Desenvolvedora não encontrada"));

        return DeveloperResponse.fromEntity(developer);
    }

    public DeveloperResponse update(Long id, DeveloperRequest request) {
        Developer developer = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Desenvolvedora não encontrada"));

        developer.setName(request.name());
        developer.setFoundedDate(request.foundedDate());
        developer.setActive(request.active());

        return DeveloperResponse.fromEntity(repository.save(developer));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}