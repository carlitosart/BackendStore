package ucb.edu.bo.storebackend.mapping;

import javax.persistence.*;

import java.security.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "comentarios", schema = "tienda_online", catalog = "")
public class ComentarioEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idComentarios")
    private int idUsuario;
    @Basic
    @Column(name = "contenido")
    private String nombre;
    @Basic
    @Column(name = "fecha")
    private Timestamp fecha;
    @Basic
    @Column(name = "usuario_id_usuario")
    private int usuario_id_usuario;
    @Basic
    @Column(name = "producto_id_producto")
    private int producto_id_producto;
    @Basic
    @Column(name = "estado_comentario")
    private int estado_comentario;
    public int getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Timestamp getFecha() {
        return fecha;
    }
    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }
    public int getUsuario_id_usuario() {
        return usuario_id_usuario;
    }
    public void setUsuario_id_usuario(int usuario_id_usuario) {
        this.usuario_id_usuario = usuario_id_usuario;
    }
    public int getProducto_id_producto() {
        return producto_id_producto;
    }
    public void setProducto_id_producto(int producto_id_producto) {
        this.producto_id_producto = producto_id_producto;
    }
    public int getEstado_comentario() {
        return estado_comentario;
    }
    public void setEstado_comentario(int estado_comentario) {
        this.estado_comentario = estado_comentario;
    }
    @Override
    public String toString() {
        return "ComentarioEntity [estado_comentario=" + estado_comentario + ", fecha=" + fecha + ", idUsuario="
                + idUsuario + ", nombre=" + nombre + ", producto_id_producto=" + producto_id_producto
                + ", usuario_id_usuario=" + usuario_id_usuario + "]";
    }

   
    
}
