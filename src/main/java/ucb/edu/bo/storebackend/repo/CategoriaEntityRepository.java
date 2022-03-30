package ucb.edu.bo.storebackend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ucb.edu.bo.storebackend.mapping.CategoriaEntity;

public interface CategoriaEntityRepository extends JpaRepository<CategoriaEntity, Long> {
}