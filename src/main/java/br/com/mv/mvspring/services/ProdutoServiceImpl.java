package br.com.mv.mvspring.services;

import br.com.mv.mvspring.domain.estoque.Produto;
import br.com.mv.mvspring.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public Produto   buscarProdutoPorId(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Produto> buscarProdutos() {
        return produtoRepository.findAll();
    }
}
