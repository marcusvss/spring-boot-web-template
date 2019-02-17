package br.com.mv.mvspring.rs;

import br.com.mv.mvspring.domain.cliente.Cliente;
import br.com.mv.mvspring.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/cliente")
public class ClientesRS {

    @Autowired
    private ClienteService clienteService;


    @RequestMapping(method = RequestMethod.GET)
    public List<Cliente> filrar() {

        List<Cliente> list = clienteService.buscarClientes();

        return list;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<?> filrarPorId(@PathVariable(value = "id") Long id) {
        Cliente cliente = clienteService.buscarClientePorId(id);

        return ResponseEntity.ok().body(cliente);
    }
}
