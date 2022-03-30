package ucb.edu.bo.storebackend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ucb.edu.bo.storebackend.mapping.ProductoEntity;

public interface ProductoEntityRepository extends CrudRepository<ProductoEntity, Long> {
    public Iterable<ProductoEntity> findByNombre(String nombre);
}