package ucb.edu.bo.storebackend.mapping;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "disponibilidad", schema = "tienda_online", catalog = "")
public class DisponibilidadEntity {
    @Id
    @Column(name = "id_disponiblidad", nullable = false)
    private Long id_disponiblidad;

    @Basic
    @Column(name = "id_producto")
    private int idProducto;
    @Basic
    @Column(name = "id_color")
    private Integer idColor;
    @Basic
    @Column(name = "id_talla")
    private Integer idTalla;
    @Basic
    @Column(name = "stock")
    private Integer stock;

    public Long getId_disponiblidad() {
        return id_disponiblidad;
    }

    public void setId_disponiblidad(Long id_disponiblidad) {
        this.id_disponiblidad = id_disponiblidad;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DisponibilidadEntity that = (DisponibilidadEntity) o;
        return idProducto == that.idProducto && Objects.equals(idColor, that.idColor) && Objects.equals(idTalla, that.idTalla) && Objects.equals(stock, that.stock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProducto, idColor, idTalla, stock);
    }
}
