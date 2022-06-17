package ucb.edu.bo.storebackend.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ucb.edu.bo.storebackend.dto.dashBoardDto.ResponseDataInterce;
import ucb.edu.bo.storebackend.dto.dashBoardDto.ResponseDataInterfaceCategori;
import ucb.edu.bo.storebackend.dto.dashBoardDto.ResponseDataInterfaceYear;
import ucb.edu.bo.storebackend.dto.dashBoardDto.ResponsedataInterfaceTallas;
import ucb.edu.bo.storebackend.mapping.CompraEntity;
import ucb.edu.bo.storebackend.objAux.ComprasPorUsuario;
import ucb.edu.bo.storebackend.repo.CompraEntityRepository;
import ucb.edu.bo.storebackend.repo.CompraEntityRepositorySinJPA;

@CrossOrigin(origins = "*",maxAge = 3600)
@Controller
@RequestMapping(path = "/compra")
public class CompraController {

    @Autowired
    private CompraEntityRepository compraEntityRepository;

    public CompraController(CompraEntityRepository compraEntityRepository) {
        this.compraEntityRepository = compraEntityRepository;
    }

    @Autowired
    private CompraEntityRepositorySinJPA cersinspa;

    @PostMapping(path = "/add")
    public @ResponseBody CompraEntity addNewCompra (@RequestBody CompraEntity compra){
        return compraEntityRepository.save(compra);
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

    @RequestMapping(value= "/ventas", method = RequestMethod.GET)
    public ResponseEntity<ResponseDataInterce> getVentasYear(@RequestParam Integer year){
        ResponseDataInterce ventasYear = (ResponseDataInterce) compraEntityRepository.getVentasYear(year);
        return new ResponseEntity<>(ventasYear, HttpStatus.OK);
    }

    @RequestMapping(value= "/ventas/categoria", method = RequestMethod.GET)
    public ResponseEntity<List<ResponseDataInterfaceCategori>> getVentasYearCategoria(@RequestParam Integer year, @RequestParam String categoria){
        List<ResponseDataInterfaceCategori> ventasYearList = (List<ResponseDataInterfaceCategori>) compraEntityRepository.getVentasCategoria(year,categoria);
        return new ResponseEntity<>(ventasYearList, HttpStatus.OK);
    }
    @RequestMapping(value= "/ventas/categoria/top", method = RequestMethod.GET)
    public ResponseEntity<List<ResponseDataInterfaceCategori>> getVentasYearCategoriaTop(@RequestParam Integer year, @RequestParam String categoria){
        List<ResponseDataInterfaceCategori> ventasYearList = (List<ResponseDataInterfaceCategori>) compraEntityRepository.getVentasCategoriaTop(year,categoria);
        return new ResponseEntity<>(ventasYearList, HttpStatus.OK);
    }

    @RequestMapping(value= "/ventas/categorias", method = RequestMethod.GET)
    public ResponseEntity<List<ResponsedataInterfaceTallas>> getVentasYearCategorias(@RequestParam Integer year){
        List<ResponsedataInterfaceTallas> ventasYearList = (List<ResponsedataInterfaceTallas>) compraEntityRepository.getVentasCategorias(year);
        return new ResponseEntity<>(ventasYearList, HttpStatus.OK);
    }
    @RequestMapping(value= "/ventas/tallas", method = RequestMethod.GET)
    public ResponseEntity<List<ResponsedataInterfaceTallas>> getVentasYearTallas(@RequestParam Integer year){
        List<ResponsedataInterfaceTallas> ventasYearList = (List<ResponsedataInterfaceTallas>) compraEntityRepository.getVentasTallas(year);
        return new ResponseEntity<>(ventasYearList, HttpStatus.OK);
    }

    @RequestMapping(value= "/ventas/productos", method = RequestMethod.GET)
    public ResponseEntity<List<ResponsedataInterfaceTallas>> getVentasYearProductos(@RequestParam Integer year){
        List<ResponsedataInterfaceTallas> ventasYearList = (List<ResponsedataInterfaceTallas>) compraEntityRepository.getVentasProductoYear(year);
        return new ResponseEntity<>(ventasYearList, HttpStatus.OK);
    }

    @RequestMapping(value= "/ventas/years", method = RequestMethod.GET)
    public ResponseEntity<List<ResponseDataInterfaceYear>> getVentasYears(){
        List<ResponseDataInterfaceYear> ventasYearList = (List<ResponseDataInterfaceYear>) compraEntityRepository.getYears();
        return new ResponseEntity<>(ventasYearList, HttpStatus.OK);
    }

}
