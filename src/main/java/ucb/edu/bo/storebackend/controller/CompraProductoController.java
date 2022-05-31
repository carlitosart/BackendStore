package ucb.edu.bo.storebackend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ucb.edu.bo.storebackend.mapping.CompraProductoEntity;
import ucb.edu.bo.storebackend.repo.CompraProductoEntityRepository;

@CrossOrigin(origins = "*",maxAge = 3600)
@Controller
@RequestMapping(path = "/comprapr")
public class CompraProductoController {

    @Autowired
    private CompraProductoEntityRepository compraProductoEntityRepository;

    @PostMapping(path = "add")
    public @ResponseBody String addCompaPro(@RequestBody CompraProductoEntity compraProductoEntity){
        compraProductoEntityRepository.save(compraProductoEntity);
        return "Compra Producto DONE";
    }
}
