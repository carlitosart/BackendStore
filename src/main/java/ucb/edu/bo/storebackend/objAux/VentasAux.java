package ucb.edu.bo.storebackend.objAux;

public class VentasAux {
    Object fechaVenta;
    Object nombreComprador;
    Object cantidad;
    Object nombreProducto;
    Object precioProducto;
    Object precioTotal;
    public VentasAux(Object fechaVenta, Object nombreComprador, Object cantidad, Object nombreProducto,
            Object precioProducto, Object precioTotal) {
        this.fechaVenta = fechaVenta;
        this.nombreComprador = nombreComprador;
        this.cantidad = cantidad;
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.precioTotal = precioTotal;
    }
    public Object getFechaVenta() {
        return fechaVenta;
    }
    public void setFechaVenta(Object fechaVenta) {
        this.fechaVenta = fechaVenta;
    }
    public Object getNombreComprador() {
        return nombreComprador;
    }
    public void setNombreComprador(Object nombreComprador) {
        this.nombreComprador = nombreComprador;
    }
    public Object getCantidad() {
        return cantidad;
    }
    public void setCantidad(Object cantidad) {
        this.cantidad = cantidad;
    }
    public Object getNombreProducto() {
        return nombreProducto;
    }
    public void setNombreProducto(Object nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    public Object getPrecioProducto() {
        return precioProducto;
    }
    public void setPrecioProducto(Object precioProducto) {
        this.precioProducto = precioProducto;
    }
    public Object getPrecioTotal() {
        return precioTotal;
    }
    public void setPrecioTotal(Object precioTotal) {
        this.precioTotal = precioTotal;
    }
    @Override
    public String toString() {
        return "ventasAux [cantidad=" + cantidad + ", fechaVenta=" + fechaVenta + ", nombreComprador=" + nombreComprador
                + ", nombreProducto=" + nombreProducto + ", precioProducto=" + precioProducto + ", precioTotal="
                + precioTotal + "]";
    }
}
