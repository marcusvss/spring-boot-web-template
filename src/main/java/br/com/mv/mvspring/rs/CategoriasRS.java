package br.com.mv.mvspring.rs;

import br.com.mv.mvspring.domain.Categoria;
import br.com.mv.mvspring.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriasRS {

    @Autowired
    private CategoriaService categoriaService;


    @RequestMapping(method = RequestMethod.GET)
    public List<Categoria> filrar() {

        List<Categoria> list = categoriaService.buscarCategorias();

        return list;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<?> filrarPorId(@PathVariable(value = "id") Long id) {
        Categoria categoria = categoriaService.buscarCategoriaPorId(id);

        return ResponseEntity.ok().body(categoria);
    }
}
