package ucb.edu.bo.storebackend.mapping;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "imagen", schema = "tienda_online", catalog = "")
public class ImagenEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_imagen")
    private int idImagen;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "id_producto")
    private int idProducto;

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImagenEntity that = (ImagenEntity) o;
        return idImagen == that.idImagen && idProducto == that.idProducto && Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idImagen, nombre, idProducto);
    }
}
