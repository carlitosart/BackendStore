package ucb.edu.bo.storebackend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ucb.edu.bo.storebackend.mapping.CategoriaEntity;
import ucb.edu.bo.storebackend.repo.CategoriaEntityRepository;

@Controller
@RequestMapping(path = "/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaEntityRepository categoriaEntityRepository;

    @PostMapping(path = "/add")
    public @ResponseBody String addNewCategoria (@RequestBody CategoriaEntity categoria){
        categoriaEntityRepository.save(categoria);
        return "Categoria Guardada";
    }

    @GetMapping(path = "todos")
    public @ResponseBody Iterable<CategoriaEntity> getAllCategoria(){
        return categoriaEntityRepository.findAll();
    }
}
