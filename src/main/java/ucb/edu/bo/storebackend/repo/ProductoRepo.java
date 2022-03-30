package ucb.edu.bo.storebackend.repo;

import org.springframework.data.repository.CrudRepository;
import ucb.edu.bo.storebackend.mapping.ProductoEntity;

public interface ProductoRepo extends CrudRepository<ProductoEntity,Integer> {

}
