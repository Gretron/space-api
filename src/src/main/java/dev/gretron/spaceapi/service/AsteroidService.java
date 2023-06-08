package dev.gretron.spaceapi.service;

import dev.gretron.spaceapi.model.AsteroidDto;
import dev.gretron.spaceapi.model.PaginatedEntity;
import dev.gretron.spaceapi.model.PlanetDto;
import dev.gretron.spaceapi.repository.AsteroidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

@Service
public class AsteroidService {

    @Autowired
    AsteroidRepository asteroidRepository;

    public Mono<PaginatedEntity<AsteroidDto>> getAllAsteroids(Pageable pageable) {

        return asteroidRepository.count()
                .log()
                .flatMap(count -> asteroidRepository.findAll()
                        .log()
                        .skip(pageable.getPageNumber() * pageable.getPageSize())
                        .take(pageable.getPageSize())
                        .collectList()
                        .map(list -> new PaginatedEntity<AsteroidDto>(list, pageable.getPageNumber(), pageable.getPageSize(), count)));

    }

}
