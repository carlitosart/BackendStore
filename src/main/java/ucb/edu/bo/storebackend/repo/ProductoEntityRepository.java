package ucb.edu.bo.storebackend.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import org.springframework.data.repository.PagingAndSortingRepository;
import ucb.edu.bo.storebackend.entityInterfaces.ProductInfoInterface;
import ucb.edu.bo.storebackend.mapping.ProductoEntity;
import ucb.edu.bo.storebackend.objAux.disponibilidadAux;

import java.util.List;

public interface ProductoEntityRepository extends PagingAndSortingRepository<ProductoEntity, Integer> {

    public Iterable<ProductoEntity> findByNombre(String nombre);
    boolean existsByNombre(String nombre);

    List<Object> getByNombre(String nombre);




        /*SELECT tienda_online.producto.*,tienda_online.categoria.nombre, tienda_online.disponibilidad.id_disponibilidad, tienda_online.disponibilidad.stock, tienda_online.color.nombre, tienda_online.talla.nombre 
    FROM tienda_online.producto
    INNER JOIN tienda_online.categoria
        ON tienda_online.producto.id_categoria = tienda_online.categoria.id_categoria
    INNER JOIN tienda_online.disponibilidad 
        ON tienda_online.producto.id_producto = tienda_online.disponibilidad.id_producto
            INNER JOIN tienda_online.color
                ON tienda_online.disponibilidad.id_color = tienda_online.color.id_color
            INNER JOIN tienda_online.talla
                ON tienda_online.disponibilidad.id_talla = tienda_online.talla.id_talla
    WHERE tienda_online.producto.nombre = "Calcetines VMW" */
    @Query(value = "SELECT top.id_producto idProducto,top.nombre,top.descripcion,top.descuento,top.disponibilidad, top.precio,top.id_categoria idCategoria,tienda_online.categoria.nombre as categoria, tienda_online.disponibilidad.id_disponibilidad as idDisponibilidad, tienda_online.disponibilidad.stock,  tienda_online.color.nombre as color, tienda_online.talla.nombre as talla  FROM tienda_online.producto top INNER JOIN tienda_online.categoria ON top.id_categoria = tienda_online.categoria.id_categoria INNER JOIN tienda_online.disponibilidad  ON top.id_producto = tienda_online.disponibilidad.id_producto  INNER JOIN tienda_online.color  ON tienda_online.disponibilidad.id_color  = tienda_online.color.id_color  INNER JOIN tienda_online.talla  ON tienda_online.disponibilidad.id_talla  = tienda_online.talla.id_talla  WHERE top.nombre = ?1",nativeQuery = true)
    //@Query(value = "SELECT * FROM tienda_online.producto where nombre = :nompro",nativeQuery = true)
    List<ProductInfoInterface> getNomPro(String nompro);
    
    @Query(value = "DELETE FROM producto top WHERE id_producto = ?1",nativeQuery = true)
    List<ProductInfoInterface> Delete_id(int id);


    @Query(value = "SELECT * from producto where nombre LIKE %:coincidencias%",nativeQuery = true)
    List<ProductoEntity> findByCoincidencias(@Param("coincidencias") String coincidencias);


    @Query(value = "SELECT d.id_producto as idProducto,p.nombre as nombreProducto,d.id_color as idColor,c.nombre as nombreColor,d.id_talla as idTalla,t.nombre as nombreTalla,d.stock as stock,d.id_disponiblidad as idDisponibilidad"
    +" from disponibilidad d"
    +" JOIN producto p"
    +" ON p.id_producto=d.id_producto"
    +" JOIN talla t"
    +" ON t.id_talla=d.id_talla"
    +" JOIN color c"
    +" ON c.id_color=d.id_color"
    +" where stock=0",nativeQuery = true)
    List<Object> findByProductosSinStock();


    @Query(value = "SELECT d.id_producto as idProducto,p.nombre as nombreProducto,d.id_color as idColor,c.nombre as nombreColor,d.id_talla as idTalla,t.nombre as nombreTalla,d.stock as stock,d.id_disponibilidad as idDisponibilidad"
    +" from disponibilidad d"
    +" JOIN producto p"
    +" ON p.id_producto=d.id_producto"
    +" JOIN talla t"
    +" ON t.id_talla=d.id_talla"
    +" JOIN color c"
    +" ON c.id_color=d.id_color"
    +" where stock<=2",nativeQuery = true)
    List<Object> findByProductosPocoStock();
    public Iterable<ProductoEntity> findByIdCategoria(int idCategoria);

    

     public Page<ProductoEntity> findAll(Pageable pageable);



}

