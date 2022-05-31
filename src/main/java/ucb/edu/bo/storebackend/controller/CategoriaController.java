package ucb.edu.bo.storebackend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ucb.edu.bo.storebackend.mapping.CategoriaEntity;
import ucb.edu.bo.storebackend.repo.CategoriaEntityRepository;

@CrossOrigin(origins = "*",maxAge = 3600)
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

    @DeleteMapping(path = "/delete/{id}")
    public @ResponseBody String deleteCate(@PathVariable("id") Long id){
        categoriaEntityRepository.deleteById(id);
        return "Categora Eliminada Correctamente";
    }

    @PutMapping("/editar/{id}")
    CategoriaEntity updateCate(@RequestBody CategoriaEntity newCate, @PathVariable Long id){
        return categoriaEntityRepository.findById(id).map(categoria -> {
            categoria.setNombre(newCate.getNombre());
            return categoriaEntityRepository.save(newCate);
        }).orElseGet(()->{
           return categoriaEntityRepository.save(newCate);
        });
    }


    @GetMapping(path = "todos")
    public @ResponseBody Iterable<CategoriaEntity> getAllCategoria(){
        return categoriaEntityRepository.findAll();
    }
}
