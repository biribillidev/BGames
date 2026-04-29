package fiap.com.br.bgames.service;

import fiap.com.br.bgames.entity.Developer;
import fiap.com.br.bgames.repository.DeveloperRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class DeveloperService {
    @Autowired
    private DeveloperRepository developerRepository;

    public Developer addDeveloper(Developer developer){
        return developerRepository.save(developer);
    }

    public Page<Developer> getAllDeveloper(Pageable pageable) {
        return developerRepository.findAll(pageable);
    }

    public Developer getDeveloperById(Long id){
        return findDeveloperById(id);
    }

    public void deleteDeveloper(Long id) {
        findDeveloperById(id);
        developerRepository.deleteById(id);
    }

    public Developer updateDeveloper(Long id, Developer newDeveloper) {
        findDeveloperById(id);
        newDeveloper.setId(id);
        return developerRepository.save(newDeveloper);
    }

    private Developer findDeveloperById(Long id) {
        return developerRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Developer com id " + id + " não encontrada")
        );
    }
}