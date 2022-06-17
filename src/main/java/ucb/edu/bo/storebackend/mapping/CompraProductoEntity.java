package ucb.edu.bo.storebackend.mapping;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "compra_producto", schema = "tienda_online", catalog = "")
public class CompraProductoEntity {
    @Basic
    @Column(name = "id_disponibilidad", nullable = false)
    private int idDisponibilidad;
    @Basic
    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    @Basic
    @Column(name = "id_compra", nullable = false)
    private int idCompra;
    @Id
    @Column(name = "new_column", nullable = true)
    private int newColumn;

    public int getIdDisponibilidad() {
        return idDisponibilidad;
    }

    public void setIdDisponibilidad(int idDisponibilidad) {
        this.idDisponibilidad = idDisponibilidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public int getNewColumn() {
        return newColumn;
    }

    public void setNewColumn(int newColumn) {
        this.newColumn = newColumn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompraProductoEntity that = (CompraProductoEntity) o;
        return idDisponibilidad == that.idDisponibilidad && cantidad == that.cantidad && idCompra == that.idCompra && newColumn == that.newColumn;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDisponibilidad, cantidad, idCompra, newColumn);
    }
}
