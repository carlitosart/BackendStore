package ucb.edu.bo.storebackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
<<<<<<< HEAD
import ucb.edu.bo.storebackend.mapping.ProductoEntity;
import ucb.edu.bo.storebackend.mapping.UsuarioEntity;
import ucb.edu.bo.storebackend.repo.UsuariRepository;

import javax.validation.Valid;

@CrossOrigin(origins = "*",maxAge = 3600)
@Controller
@RequestMapping(path = "/usuario")
public class UsuarioController {
    @Autowired
    private UsuariRepository usuarioRepository;

    /*@PostMapping(path = "/add")
    public @ResponseBody
    UsuarioEntity addNewUsuario (@RequestBody UsuarioEntity usuario){
        return UsuariRepository.save(usuario);

    }*/
=======
import ucb.edu.bo.storebackend.mapping.UsuarioEntity;
import ucb.edu.bo.storebackend.repo.UsuarioEntityRepository;

@CrossOrigin(origins = "*",maxAge = 3600)
@Controller
@RequestMapping(path = "/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioEntityRepository usuarioEntityRepository;

    @PostMapping(path = "/add")
    public @ResponseBody UsuarioEntity addUsuario (@RequestBody UsuarioEntity usuario){
        return usuarioEntityRepository.save(usuario);
    }

    @DeleteMapping("delete/{id}")
    public @ResponseBody String deleteUser(@PathVariable("id")Long id){
        usuarioEntityRepository.deleteById(id);
        return "Usuario Eliminado Correctamente";
    }
>>>>>>> 39bc52ecacf7860627ae3aab9872f9e945196e54

}
