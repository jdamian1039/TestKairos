package com.jorgegalvan.testkairos.repository;

import com.jorgegalvan.testkairos.models.TvMazeShow;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TvShowRepository extends MongoRepository<TvMazeShow, Long> {
}