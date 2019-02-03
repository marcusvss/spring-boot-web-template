package br.com.mv.mvspring.rs;

import br.com.mv.mvspring.domain.common.Categoria;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriasRS {


    @RequestMapping(method = RequestMethod.GET)
    public List<Categoria> filrar() {

        List<Categoria> list = listarCategorias();

        return list;
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public List<Categoria> filrarPorId(@PathVariable(value = "id") Long id) {

        List<Categoria> list = listarCategorias();

        return list.stream().filter(f -> f.getId() == id).collect(Collectors.toList());
    }

    private List<Categoria> listarCategorias() {
        Categoria cat1 = new Categoria(1l, "Informatica");
        Categoria cat2 = new Categoria(2l, "Escritorio");

        List<Categoria> list = new ArrayList<Categoria>();
        list.add(cat1);
        list.add(cat2);
        return list;
    }


}
