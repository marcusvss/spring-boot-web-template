package br.com.mv.mvspring.services;

import br.com.mv.mvspring.domain.Cidade;

import java.util.List;

public interface CidadeService {

    Cidade buscarCidadePorNome(String nome);

    List<Cidade> buscarCidades();
}
