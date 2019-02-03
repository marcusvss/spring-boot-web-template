package br.com.mv.mvspring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriasRS {


    @RequestMapping(method = RequestMethod.GET)
    public String filrar() {
        return "REST está funcionando!";
    }


}
