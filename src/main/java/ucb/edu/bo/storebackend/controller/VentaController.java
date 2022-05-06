package ucb.edu.bo.storebackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ucb.edu.bo.storebackend.mapping.CompraEntity;
import ucb.edu.bo.storebackend.repo.CompraEntityRepository;

import java.util.List;

@CrossOrigin(origins = "*",maxAge = 3600)
@Controller
@RequestMapping(path = "/ventas")
public class VentaController {

    @Autowired
    private CompraEntityRepository compraEntityRepository;

    @GetMapping(path = "/todos")
    public @ResponseBody
    List<CompraEntity> getAllProductos() {
        // This returns a JSON or XML with the users
        return compraEntityRepository.findAll();
    }

}
