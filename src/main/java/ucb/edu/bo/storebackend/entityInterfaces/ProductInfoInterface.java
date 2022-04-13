package ucb.edu.bo.storebackend.entityInterfaces;

public interface ProductInfoInterface {
    Integer getIdProducto();
    String getNombre();
    String getDescripcion();
    Double getPrecio();
    Integer getIdCategoria();
    Integer getStock();
    String getColor();
    String getTalla();
}