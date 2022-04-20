package ucb.edu.bo.storebackend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ucb.edu.bo.storebackend.entityInterfaces.ProductInfoInterface;
import ucb.edu.bo.storebackend.mapping.ProductoEntity;

import java.util.List;

public interface ProductoEntityRepository extends CrudRepository<ProductoEntity, Integer> {

    public Iterable<ProductoEntity> findByNombre(String nombre);
    boolean existsByNombre(String nombre);

    List<Object> getByNombre(String nombre);




    @Query(value = "SELECT top.id_producto idProducto,top.nombre,top.descripcion, top.precio,top.id_categoria idCategoria, tienda_online.disponibilidad.stock,  tienda_online.color.nombre as color, tienda_online.talla.nombre as talla  FROM tienda_online.producto  top INNER JOIN tienda_online.disponibilidad  ON top.id_producto = tienda_online.disponibilidad.id_producto  INNER JOIN tienda_online.color  ON tienda_online.disponibilidad.id_color  = tienda_online.color.id_color  INNER JOIN tienda_online.talla  ON tienda_online.disponibilidad.id_talla  = tienda_online.talla.id_talla  WHERE top.nombre = ?1",nativeQuery = true)

    //@Query(value = "SELECT * FROM tienda_online.producto where nombre = :nompro",nativeQuery = true)
    List<ProductInfoInterface> getNomPro(String nompro);
    
    @Query(value = "DELETE FROM producto top WHERE id_producto = ?1",nativeQuery = true)
    List<ProductInfoInterface> Delete_id(int id);


    @Query(value = "SELECT * from producto where nombre LIKE %:coincidencias%",nativeQuery = true)
    List<ProductoEntity> findByCoincidencias(@Param("coincidencias") String coincidencias);


    public Iterable<ProductoEntity> findByIdCategoria(int idCategoria);




}

