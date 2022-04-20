package ucb.edu.bo.storebackend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ucb.edu.bo.storebackend.mapping.UsuarioEntity;

public interface UsuarioEntityRepository extends JpaRepository<UsuarioEntity, Long> {
}