package br.com.mv.mvspring.services;

import br.com.mv.mvspring.domain.cliente.Cliente;
import br.com.mv.mvspring.exceptions.ObjectNotFoundException;
import br.com.mv.mvspring.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente buscarClientePorId(Long id) {
        return clienteRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Categoria com id: " + id + " nao econtrada."));
    }

    @Override
    public List<Cliente> buscarClientes() {
        return clienteRepository.findAll();
    }
}
