package ucb.edu.bo.storebackend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ucb.edu.bo.storebackend.mapping.ProductoEntity;

import java.util.List;

public interface ProductoEntityRepository extends CrudRepository<ProductoEntity, Integer> {

    public Iterable<ProductoEntity> findByNombre(String nombre);
    boolean existsByNombre(String nombre);

    List<Object> getByNombre(String nombre);

}