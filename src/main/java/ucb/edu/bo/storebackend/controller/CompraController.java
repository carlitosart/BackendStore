package ucb.edu.bo.storebackend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ucb.edu.bo.storebackend.mapping.CompraEntity;
import ucb.edu.bo.storebackend.repo.CompraEntityRepository;

@CrossOrigin(origins = "*",maxAge = 3600)
@Controller
@RequestMapping(path = "/compra")
public class CompraController {

    @Autowired
    private CompraEntityRepository compraEntityRepository;

    @PostMapping(path = "/add")
    public @ResponseBody String addNewCompra (@RequestBody CompraEntity compra){
        compraEntityRepository.save(compra);
        return "Compra Guardada";
    }
}
