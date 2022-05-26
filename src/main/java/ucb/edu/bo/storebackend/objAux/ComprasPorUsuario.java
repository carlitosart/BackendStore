package ucb.edu.bo.storebackend.objAux;

public class ComprasPorUsuario {
    Object fechaCompra;
    Object cantidad;
    Object nombreProducto; 	
    Object precio;
    Object costoTotal;
    public ComprasPorUsuario(Object fechaCompra, Object cantidad, Object nombreProducto, Object precio,
            Object costoTotal) {
        this.fechaCompra = fechaCompra;
        this.cantidad = cantidad;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.costoTotal = costoTotal;
    }
    public Object getFechaCompra() {
        return fechaCompra;
    }
    public void setFechaCompra(Object fechaCompra) {
        this.fechaCompra = fechaCompra;
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
    public Object getPrecio() {
        return precio;
    }
    public void setPrecio(Object precio) {
        this.precio = precio;
    }
    public Object getCostoTotal() {
        return costoTotal;
    }
    public void setCostoTotal(Object costoTotal) {
        this.costoTotal = costoTotal;
    }
    @Override
    public String toString() {
        return "ComprasPorUsuario [cantidad=" + cantidad + ", costoTotal=" + costoTotal + ", fechaCompra=" + fechaCompra
                + ", nombreProducto=" + nombreProducto + ", precio=" + precio + "]";
    }
}
