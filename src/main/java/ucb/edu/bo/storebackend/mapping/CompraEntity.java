package ucb.edu.bo.storebackend.mapping;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "compra", schema = "tienda_online", catalog = "")
public class CompraEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_compra", nullable = false)
    private int idCompra;
    @Basic
    @Column(name = "fecha", nullable = true)
    private Timestamp fecha;
    @Basic
    @Column(name = "id_usuario", nullable = false)
    private int idUsuario;
    @Basic
    @Column(name = "costo_total", nullable = true, precision = 0)
    private Double costoTotal;

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(Double costoTotal) {
        this.costoTotal = costoTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompraEntity that = (CompraEntity) o;
        return idCompra == that.idCompra && idUsuario == that.idUsuario && Objects.equals(fecha, that.fecha) && Objects.equals(costoTotal, that.costoTotal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCompra, fecha, idUsuario, costoTotal);
    }
}
