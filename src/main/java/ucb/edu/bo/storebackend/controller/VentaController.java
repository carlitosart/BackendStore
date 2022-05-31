package ucb.edu.bo.storebackend.controller;

import org.springdoc.core.converters.models.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ucb.edu.bo.storebackend.mapping.CompraEntity;
import ucb.edu.bo.storebackend.objAux.VentasAux;
import ucb.edu.bo.storebackend.repo.CompraEntityRepository;
import ucb.edu.bo.storebackend.repo.CompraEntityRepositorySinJPA;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*",maxAge = 3600)
@Controller
@RequestMapping(path = "/ventas")
public class VentaController {

    @Autowired
    private CompraEntityRepository compraEntityRepository;
    @Autowired
    private CompraEntityRepositorySinJPA cersinjpa;

    @GetMapping(path = "/todos")
    public @ResponseBody
    List<CompraEntity> getAllProductos() {
        // This returns a JSON or XML with the users
        return compraEntityRepository.findAll();
    }
    @GetMapping(path = "/productos/todos")
    public @ResponseBody
    List<VentasAux> getVentasDetalle() {
        // This returns a JSON or XML with the users
        // ArrayList listaVentasProductosDetalle= cersinjpa.getVentasDetalle();
        // for (O producto: listaVentasProductosDetalle){
        //     VentasAux pva=(VentasAux)producto;
        // }
        List<Object>lista= cersinjpa.getVentasDetalle();
        ArrayList<VentasAux>listaVA=new ArrayList<>();
        for(Object e:lista){
            Object[]l=(Object[])e;
            VentasAux va=new VentasAux(l[0],""+l[1],l[2], ""+l[3], l[4],"" + l[5]);
            listaVA.add(va);
        }
        return listaVA;
    }

}
