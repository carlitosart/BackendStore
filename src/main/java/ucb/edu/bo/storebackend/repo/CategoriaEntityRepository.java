package ucb.edu.bo.storebackend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucb.edu.bo.storebackend.mapping.CategoriaEntity;
@Repository
public interface CategoriaEntityRepository extends JpaRepository<CategoriaEntity, Long> {
}