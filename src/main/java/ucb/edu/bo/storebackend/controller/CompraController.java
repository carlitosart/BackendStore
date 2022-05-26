package ucb.edu.bo.storebackend.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ucb.edu.bo.storebackend.mapping.CompraEntity;
import ucb.edu.bo.storebackend.mapping.ProductoEntity;
import ucb.edu.bo.storebackend.objAux.ComprasPorUsuario;
import ucb.edu.bo.storebackend.repo.CompraEntityRepository;
import ucb.edu.bo.storebackend.repo.CompraEntityRepositorySinJPA;

@CrossOrigin(origins = "*",maxAge = 3600)
@Controller
@RequestMapping(path = "/compra")
public class CompraController {

    @Autowired
    private CompraEntityRepository compraEntityRepository;
    @Autowired
    private CompraEntityRepositorySinJPA cersinspa;

    @PostMapping(path = "/add")
    public @ResponseBody String addNewCompra (@RequestBody CompraEntity compra){
        compraEntityRepository.save(compra);
        return "Compra Guardada";
    }
    @GetMapping(path = "/todos/usuario/{id}")
    public @ResponseBody ArrayList<ComprasPorUsuario> getComprasUsuario (@PathVariable("id")int id){
        List<Object>lista= cersinspa.getVentasPorUsuario(id);
        ArrayList<ComprasPorUsuario>listaVA=new ArrayList<>();
        for(Object e:lista){
            Object[]l=(Object[])e;
            ComprasPorUsuario va=new ComprasPorUsuario(l[0],l[1],l[2],l[3], l[4]);
            listaVA.add(va);
        }
        return listaVA;
    }
}
