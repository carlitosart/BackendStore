package ucb.edu.bo.storebackend.repo;

import org.springframework.data.repository.CrudRepository;
import ucb.edu.bo.storebackend.mapping.UsuarioEntity;

public interface UsuariRepository  extends CrudRepository<UsuarioEntity, Integer> {
}
