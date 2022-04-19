package ucb.edu.bo.storebackend.security.repository;

import ucb.edu.bo.storebackend.security.entity.Rol;
import ucb.edu.bo.storebackend.security.enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
