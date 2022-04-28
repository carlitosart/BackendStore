package ucb.edu.bo.storebackend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ucb.edu.bo.storebackend.mapping.Compra;

public interface CompraRepository extends JpaRepository<Compra, Integer> {
}