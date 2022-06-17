package ucb.edu.bo.storebackend.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ucb.edu.bo.storebackend.dto.dashBoardDto.ResponseDataInterce;
import ucb.edu.bo.storebackend.dto.dashBoardDto.ResponseDataInterfaceCategori;
import ucb.edu.bo.storebackend.dto.dashBoardDto.ResponseDataInterfaceYear;
import ucb.edu.bo.storebackend.dto.dashBoardDto.ResponsedataInterfaceTallas;
import ucb.edu.bo.storebackend.mapping.CompraEntity;

import java.util.List;

public interface CompraEntityRepository extends JpaRepository<CompraEntity, Integer> {

    @Query(value = "SELECT DISTINCT COUNT(c.id_compra) as CantidadCompras, SUM(c.costo_total) as CostoTotal " +
            "FROM compra c " +
            "WHERE YEAR(c.fecha) = :year",nativeQuery=true)
    ResponseDataInterce getVentasYear(Integer year);

    @Query(value = "SELECT DISTINCT COUNT(producto.id_producto) as cantidad, producto.nombre, SUM(producto.precio) as precioTotal " +
            "FROM producto " +
            "INNER JOIN categoria " +
            "on categoria.id_categoria = producto.id_categoria " +
            "INNER JOIN disponibilidad " +
            "on disponibilidad.id_producto = producto.id_producto " +
            "INNER JOIN compra_producto " +
            "on disponibilidad.id_disponibilidad = compra_producto.id_disponibilidad " +
            "INNER JOIN compra " +
            "on compra.id_compra = compra_producto.id_compra " +
            "WHERE YEAR(compra.fecha) = :year " +
            "AND categoria.nombre = :categoria " +
            "GROUP BY producto.id_producto, compra.costo_total " +
            "order by SUM(producto.precio) desc ",nativeQuery=true)
    List<ResponseDataInterfaceCategori> getVentasCategoria(Integer year, String categoria);

    @Query(value = "SELECT DISTINCT COUNT(categoria.id_categoria) as cantidad, categoria.nombre, SUM(producto.precio) as precioTotal " +
            "FROM producto " +
            "INNER JOIN categoria " +
            "on categoria.id_categoria = producto.id_categoria " +
            "INNER JOIN disponibilidad " +
            "on disponibilidad.id_producto = producto.id_producto " +
            "INNER JOIN compra_producto " +
            "on disponibilidad.id_disponibilidad = compra_producto.id_disponibilidad " +
            "INNER JOIN compra " +
            "on compra.id_compra = compra_producto.id_compra " +
            "WHERE YEAR(compra.fecha) = :year " +
            "GROUP BY categoria.id_categoria " +
            "order by SUM(producto.precio) desc ",nativeQuery=true)
    List<ResponsedataInterfaceTallas> getVentasCategorias(Integer year);

    @Query(value = "SELECT DISTINCT COUNT(tienda_online.disponibilidad.id_talla) as cantidad, tienda_online.talla.nombre, SUM(tienda_online.compra.costo_total) as precioTotal " +
            "FROM tienda_online.talla " +
            "INNER JOIN tienda_online.disponibilidad " +
            "on tienda_online.disponibilidad.id_talla = tienda_online.talla.id_talla " +
            "INNER JOIN tienda_online.compra_producto " +
            "on tienda_online.disponibilidad.id_disponibilidad = tienda_online.compra_producto.id_disponibilidad " +
            "INNER JOIN tienda_online.compra " +
            "on tienda_online.compra.id_compra = tienda_online.compra_producto.id_compra " +
            "WHERE YEAR(tienda_online.compra.fecha) = :year " +
            "GROUP BY tienda_online.disponibilidad.id_talla, tienda_online.compra.costo_total " +
            "order by SUM(tienda_online.compra.costo_total) desc " +
            "LIMIT 5",nativeQuery=true)
    List<ResponsedataInterfaceTallas> getVentasTallas(Integer year);

    @Query(value = "SELECT DISTINCT COUNT(tienda_online.producto.id_producto) as cantidad, tienda_online.producto.nombre, SUM(tienda_online.producto.precio) as precioTotal "+ 
                "FROM tienda_online.producto "+ 
                "INNER JOIN tienda_online.disponibilidad "+ 
                "on tienda_online.disponibilidad.id_producto = tienda_online.producto.id_producto "+ 
                "INNER JOIN tienda_online.compra_producto      "+ 
                "on tienda_online.disponibilidad.id_disponibilidad = tienda_online.compra_producto.id_disponibilidad "+ 
                "INNER JOIN tienda_online.compra "+ 
                "on tienda_online.compra.id_compra = tienda_online.compra_producto.id_compra "+ 
                "WHERE YEAR(tienda_online.compra.fecha) = :year "+ 
                "GROUP BY tienda_online.producto.id_producto "+ 
                "order by cantidad desc "+ 
                "Limit 5",nativeQuery=true)
List<ResponsedataInterfaceTallas> getVentasProductoYear(Integer year);

@Query(value = "SELECT Distinct YEAR(tienda_online.compra.fecha) as year "+
                "FROM tienda_online.compra",nativeQuery=true)
List<ResponseDataInterfaceYear> getYears();

    
}