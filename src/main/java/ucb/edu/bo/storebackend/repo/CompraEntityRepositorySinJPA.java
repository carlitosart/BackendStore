package ucb.edu.bo.storebackend.repo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import ucb.edu.bo.storebackend.mapping.CompraEntity;
import ucb.edu.bo.storebackend.objAux.VentasAux;

import java.util.List;


public interface CompraEntityRepositorySinJPA extends PagingAndSortingRepository<CompraEntity, Integer> {

    @Query(value = "SELECT c.fecha as fechaCompra,u.nombre as nombreComprador,cp.cantidad as cantidad,p.nombre as nombreProducto,p.precio as precio,cp.cantidad*p.precio as costoTotal from compra_producto cp JOIN compra c ON c.id_compra=cp.id_compra JOIN usuario u on u.id_usuario=c.id_usuario JOIN disponibilidad d ON d.id_disponibilidad=cp.id_disponibilidad JOIN producto p ON p.id_producto=d.id_producto",nativeQuery = true)
    List<Object> getVentasDetalle();
}
