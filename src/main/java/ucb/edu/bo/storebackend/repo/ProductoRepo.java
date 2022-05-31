package ucb.edu.bo.storebackend.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ucb.edu.bo.storebackend.mapping.ProductoEntity;
@Repository
public interface ProductoRepo extends CrudRepository<ProductoEntity,Integer> {

}
