package br.com.mv.mvspring.services;

import br.com.mv.mvspring.domain.estoque.Produto;

import java.util.List;

public interface ProdutoService {

    Produto buscarProdutoPorId(Long id);

    List<Produto> buscarProdutos();
}
