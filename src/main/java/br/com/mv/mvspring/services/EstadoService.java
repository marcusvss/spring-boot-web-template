package br.com.mv.mvspring.services;

import br.com.mv.mvspring.domain.logistica.Estado;

import java.util.List;

public interface EstadoService {

    Estado buscarEstadoPorNome(String nome);

    List<Estado> buscarEstados();
}
