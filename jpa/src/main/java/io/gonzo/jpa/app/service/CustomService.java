package io.gonzo.jpa.app.service;

import io.gonzo.jpa.app.domain.base.CustomPK;
import io.gonzo.jpa.app.domain.basic.Custom;
import io.gonzo.jpa.app.repository.CustomRepository;
import io.gonzo.jpa.app.web.dto.CustomDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomService {

    private CustomRepository repository;

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

}
