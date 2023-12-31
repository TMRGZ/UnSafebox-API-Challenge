package com.rviewer.skeletons.infrastructure.persistence.repository.impl;

import com.rviewer.skeletons.domain.model.Safebox;
import com.rviewer.skeletons.domain.repository.SafeboxRepository;
import com.rviewer.skeletons.infrastructure.mapper.SafeboxMapper;
import com.rviewer.skeletons.infrastructure.persistence.repository.ReactiveSafeboxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class SafeboxRepositoryImpl implements SafeboxRepository {

    @Autowired
    private ReactiveSafeboxRepository reactiveSafeboxRepository;

    @Autowired
    private SafeboxMapper safeboxMapper;

    @Override
    public Mono<Safebox> findById(Long id) {
        return reactiveSafeboxRepository.findById(id).map(safeboxMapper::map);
    }

    @Override
    public Mono<Safebox> findByNameIgnoreCase(String name) {
        return reactiveSafeboxRepository.findByNameIgnoreCase(name).map(safeboxMapper::map);
    }

    @Override
    public Mono<Safebox> save(Safebox safebox) {
        return reactiveSafeboxRepository.save(safeboxMapper.map(safebox)).map(safeboxMapper::map);
    }
}
