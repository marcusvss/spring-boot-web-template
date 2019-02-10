package br.com.mv.mvspring.rs;

import br.com.mv.mvspring.domain.Estado;
import br.com.mv.mvspring.services.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/estados")
public class EstadoRS {

    @Autowired
    private EstadoService estadoService;


    @RequestMapping(method = RequestMethod.GET)
    public List<Estado> filrar() {

        List<Estado> list = estadoService.buscarEstados();

        return list;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{nome}")
    public ResponseEntity<?> filrarPorId(@PathVariable(value = "nome") String nome) {
        Estado estado = estadoService.buscarEstadoPorNome(nome);

        return ResponseEntity.ok().body(estado);
    }
}
