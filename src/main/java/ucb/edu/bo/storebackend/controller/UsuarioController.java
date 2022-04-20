package ucb.edu.bo.storebackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping(path = "/add")
    public @ResponseBody
    UsuarioEntity addNewUsuario (@RequestBody UsuarioEntity usuario){
        return UsuariRepository.save(usuario);

    }

}
