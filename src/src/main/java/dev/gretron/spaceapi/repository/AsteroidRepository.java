package dev.gretron.spaceapi.repository;

import dev.gretron.spaceapi.model.AsteroidDto;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsteroidRepository extends R2dbcRepository<AsteroidDto, Long> {

}
