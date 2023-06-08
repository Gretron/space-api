package dev.gretron.spaceapi.repository;

import dev.gretron.spaceapi.model.PlanetDto;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface PlanetRepository extends R2dbcRepository<PlanetDto, Long> {
}
