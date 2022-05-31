package ucb.edu.bo.storebackend.objAux;

import java.math.BigInteger;

public class disponibilidadAux {
    Object idProducto;
    Object nombreProducto;
    Object idColor;
    Object nombreColor;
    Object idTalla;
    Object nombreTalla;
    Object stock;
    Object idDisponibilidad;
    public disponibilidadAux(Object idProducto, Object nombreProducto, Object idColor, Object nombreColor,
            Object idTalla, Object nombreTalla, Object stock, Object idDisponibilidad) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.idColor = idColor;
        this.nombreColor = nombreColor;
        this.idTalla = idTalla;
        this.nombreTalla = nombreTalla;
        this.stock = stock;
        this.idDisponibilidad = idDisponibilidad;
    }
    public Object getIdProducto() {
        return idProducto;
    }
    public void setIdProducto(Object idProducto) {
        this.idProducto = idProducto;
    }
    public Object getNombreProducto() {
        return nombreProducto;
    }
    public void setNombreProducto(Object nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    public Object getIdColor() {
        return idColor;
    }
    public void setIdColor(Object idColor) {
        this.idColor = idColor;
    }
    public Object getNombreColor() {
        return nombreColor;
    }
    public void setNombreColor(Object nombreColor) {
        this.nombreColor = nombreColor;
    }
    public Object getIdTalla() {
        return idTalla;
    }
    public void setIdTalla(Object idTalla) {
        this.idTalla = idTalla;
    }
    public Object getNombreTalla() {
        return nombreTalla;
    }
    public void setNombreTalla(Object nombreTalla) {
        this.nombreTalla = nombreTalla;
    }
    public Object getStock() {
        return stock;
    }
    public void setStock(Object stock) {
        this.stock = stock;
    }
    public Object getIdDisponibilidad() {
        return idDisponibilidad;
    }
    public void setIdDisponibilidad(Object idDisponibilidad) {
        this.idDisponibilidad = idDisponibilidad;
    }
    @Override
    public String toString() {
        return "disponibilidadAux [idColor=" + idColor + ", idDisponibilidad=" + idDisponibilidad + ", idProducto="
                + idProducto + ", idTalla=" + idTalla + ", nombreColor=" + nombreColor + ", nombreProducto="
                + nombreProducto + ", nombreTalla=" + nombreTalla + ", stock=" + stock + "]";
    }
 
}
