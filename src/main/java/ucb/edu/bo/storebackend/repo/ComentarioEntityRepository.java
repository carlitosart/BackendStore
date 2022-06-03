package ucb.edu.bo.storebackend.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import ucb.edu.bo.storebackend.mapping.ComentarioEntity;

public interface ComentarioEntityRepository extends JpaRepository<ComentarioEntity, Integer>{
    
}
