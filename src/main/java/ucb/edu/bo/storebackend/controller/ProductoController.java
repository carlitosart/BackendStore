package ucb.edu.bo.storebackend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ucb.edu.bo.storebackend.entityInterfaces.ProductInfoInterface;
import ucb.edu.bo.storebackend.mapping.ProductoEntity;
import ucb.edu.bo.storebackend.repo.ProductoEntityRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*",maxAge = 3600)
@Controller
@RequestMapping(path = "/productos")
public class ProductoController {
    @Autowired
    private ProductoEntityRepository productoEntityRepository;

    @PostMapping(path = "/add")
    public @ResponseBody ProductoEntity addNewProducto (@RequestBody ProductoEntity producto){
        return productoEntityRepository.save(producto);
    }

    @GetMapping(path = "/todos")
    public @ResponseBody Iterable<ProductoEntity> getAllProductos() {
        // This returns a JSON or XML with the users
        return productoEntityRepository.findAll();
    }

    @GetMapping(path = "/buscar")
    public @ResponseBody Iterable<ProductoEntity> getName(@RequestParam("nombre") String nombre){

        return productoEntityRepository.findByNombre(nombre);
    }

    @GetMapping(path = "/buscarc")
    public @ResponseBody
    List<ProductInfoInterface> getProc(@RequestParam("nompro")String nompro){
        return productoEntityRepository.getNomPro(nompro);

    }

    @GetMapping("/detail/{id}")
    public  @ResponseBody Optional<ProductoEntity> getById(@PathVariable("id") int id){

        return productoEntityRepository.findById(id);
    }


    @PutMapping("/update/{id}")
    public  @ResponseBody ProductoEntity update(@PathVariable("id")int id, @RequestBody ProductoEntity productoDto){

        ProductoEntity producto=new ProductoEntity();
        producto.setIdProducto(id);
        producto.setNombre(productoDto.getNombre());
        producto.setDescripcion(productoDto.getDescripcion());
        producto.setIdCategoria(productoDto.getIdCategoria());
        producto.setPrecio(productoDto.getPrecio());
        producto.setDescuento(productoDto.getDescuento());
        producto.setDisponibilidad(producto.getDisponibilidad());
        return productoEntityRepository.save(producto);
    }


    @DeleteMapping("/delete/{id}")
    public @ResponseBody ProductoEntity delete(@PathVariable("id")int id){

        Optional<ProductoEntity> productoDto= productoEntityRepository.findById(id);

        ProductoEntity producto=new ProductoEntity();
        producto.setIdProducto(id);
        producto.setNombre(productoDto.get().getNombre());
        producto.setDescripcion(productoDto.get().getDescripcion());
        producto.setIdCategoria(productoDto.get().getIdCategoria());
        producto.setPrecio(productoDto.get().getPrecio());
        producto.setDescuento(productoDto.get().getDescuento());
        producto.setDisponibilidad(false);

        return productoEntityRepository.save(producto);
    }
    
    @GetMapping(path = "/categoria")
    public @ResponseBody Iterable<ProductoEntity> getProductosCategoria(@RequestParam("id_categoria") int categoria){
        return productoEntityRepository.findByIdCategoria(categoria);
    }



}
