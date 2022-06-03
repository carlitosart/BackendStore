package ucb.edu.bo.storebackend.repo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import ucb.edu.bo.storebackend.mapping.CompraEntity;
import ucb.edu.bo.storebackend.mapping.UsuarioEntity;
import ucb.edu.bo.storebackend.objAux.VentasAux;

import java.util.List;


public interface UsuarioEntityRepositorySinJPA extends PagingAndSortingRepository<UsuarioEntity, Integer> {

    @Query(value = "SELECT comentarios.idcomentarios as idcomentario,comentarios.contenido as contenido, comentarios.fecha as fecha,producto.nombre as producto,comentarios.estado_comentario FROM comentarios JOIN producto ON producto.id_producto=comentarios.producto_id_producto WHERE comentarios.usuario_id_usuario=?1",nativeQuery=true)
    List<Object> getComentarioPorUsuario(Long id);
}
