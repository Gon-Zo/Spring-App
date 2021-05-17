package io.gonzo.jpa.app.service;

import io.gonzo.jpa.app.domain.base.CustomPK;
import io.gonzo.jpa.app.domain.basic.Custom;
import io.gonzo.jpa.app.repository.CustomOnly;
import io.gonzo.jpa.app.repository.CustomRepository;
import io.gonzo.jpa.app.web.dto.CustomDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class CustomService {

    private final CustomRepository repository;

    public CustomService(CustomRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void saveBy(CustomDTO dto) {
        repository.save(dto.toEntity());
    }

    @Transactional(readOnly = true)
    public Optional<Custom> getById(CustomPK pk) {
        return repository.findById(pk);
    }

    @Transactional(readOnly = true)
    public Optional<List<Custom>> getByCustomPK_Email(String email) {
        return repository.findByCustomPK_Email(email);
    }

    @Transactional(readOnly = true)
    public Optional<List<Custom>> getByAll() {
        return Optional.of(repository.findAll());
    }

    @Transactional(readOnly = true)
    public Collection<CustomOnly> getByCustomPK_Url(String url) {
        return repository.findByCustomPK_Url(url);
    }

    @Transactional(readOnly = true)
    public Optional<List<Custom>> getByContentContaining(String content) {
        return repository.findByContentContaining(content);
    }

    @Transactional(readOnly = true)
    public Optional<List<Custom>> getByContentLike(String content) {
        return repository.findByContentLike(content);
    }

    @Transactional(readOnly = true)
    public Optional<List<Custom>> getByContentStartingWith(String content) {
        return repository.findByContentStartingWith(content);
    }

    @Transactional(readOnly = true)
    public Optional<List<Custom>> getByContentEndingWith(String content) {
        return repository.findByContentEndingWith(content);
    }

    @Transactional(readOnly = true)
    public Optional<List<Custom>> getByContentStartsWith(String content) {
        return repository.findByContentStartsWith(content);
    }

    @Transactional(readOnly = true)
    public Optional<List<Custom>> getByContentEndsWith(String content) {
        return repository.findByContentEndsWith(content);
    }

}
