package br.com.mv.mvspring.services;

import br.com.mv.mvspring.domain.cliente.Cliente;

import java.util.List;

public interface ClienteService {

    Cliente buscarClientePorId(Long id);

    List<Cliente> buscarClientes();
}
