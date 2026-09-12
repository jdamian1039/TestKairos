package com.jorgegalvan.testkairos.repository;

import com.jorgegalvan.testkairos.models.Comentario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComentarioRepository extends MongoRepository<Comentario, String> {
    List<Comentario> findByShowId(Long showId);
}
