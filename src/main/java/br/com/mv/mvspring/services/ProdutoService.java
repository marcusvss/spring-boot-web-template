package br.com.mv.mvspring.services;

import br.com.mv.mvspring.domain.Produto;

import java.util.List;

public interface ProdutoService {

    Produto buscarProdutoPorId(Long id);

    List<Produto> buscarProdutos();
}
