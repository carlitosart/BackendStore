package ucb.edu.bo.storebackend.mapping;

import org.hibernate.mapping.Collection;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "disponibilidad", schema = "tienda_online", catalog = "")
public class DisponibilidadEntity {
    @Basic
    @Column(name = "id_producto", nullable = false)
    private int idProducto;
    @Basic
    @Column(name = "id_color", nullable = true)
    private Integer idColor;
    @Basic
    @Column(name = "id_talla", nullable = true)
    private Integer idTalla;
    @Basic
    @Column(name = "stock", nullable = true)
    private Integer stock;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_disponibilidad", nullable = false)
    private int idDisponibilidad;
    @Basic
    @Column(name = "id_imagen", nullable = true)
    private Integer idImagen;

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getIdColor() {
        return idColor;
    }

    public void setIdColor(Integer idColor) {
        this.idColor = idColor;
    }

    public Integer getIdTalla() {
        return idTalla;
    }

    public void setIdTalla(Integer idTalla) {
        this.idTalla = idTalla;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public int getIdDisponibilidad() {
        return idDisponibilidad;
    }

    public void setIdDisponibilidad(int idDisponibilidad) {
        this.idDisponibilidad = idDisponibilidad;
    }

    public Integer getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(Integer idImagen) {
        this.idImagen = idImagen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DisponibilidadEntity that = (DisponibilidadEntity) o;
        return idProducto == that.idProducto && idDisponibilidad == that.idDisponibilidad && Objects.equals(idColor, that.idColor) && Objects.equals(idTalla, that.idTalla) && Objects.equals(stock, that.stock) && Objects.equals(idImagen, that.idImagen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProducto, idColor, idTalla, stock, idDisponibilidad, idImagen);
    }
}
