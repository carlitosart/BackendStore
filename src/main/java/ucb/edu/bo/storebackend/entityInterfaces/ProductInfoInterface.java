package ucb.edu.bo.storebackend.entityInterfaces;

public interface ProductInfoInterface {
    Integer getIdProducto();
    String getNombre();
    String getDescripcion();
    Double getPrecio();
    Integer getIdCategoria();
    Double getDescuento();
    Boolean getDisponibilidad();
    String getCategoria();
    Integer getIdDisponibilidad();
    Integer getStock();
    String getColor();
    String getTalla();
}