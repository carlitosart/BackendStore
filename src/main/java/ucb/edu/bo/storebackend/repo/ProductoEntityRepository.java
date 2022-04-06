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

    @Query(value = "SELECT tienda_online.producto.*, tienda_online.disponibilidad.stock,  tienda_online.color.nombre as color, tienda_online.talla.nombre as talla  FROM tienda_online.producto  INNER JOIN tienda_online.disponibilidad  ON tienda_online.producto.id_producto = tienda_online.disponibilidad.id_producto  INNER JOIN tienda_online.color  ON tienda_online.disponibilidad.id_color  = tienda_online.color.id_color  INNER JOIN tienda_online.talla  ON tienda_online.disponibilidad.id_talla  = tienda_online.talla.id_talla  WHERE tienda_online.producto.nombre = ?1",nativeQuery = true)

    //@Query(value = "SELECT * FROM tienda_online.producto where nombre = :nompro",nativeQuery = true)
    List<Object> getNomPro(String nompro);

}