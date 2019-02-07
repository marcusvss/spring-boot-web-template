package br.com.mv.mvspring.services;

import br.com.mv.mvspring.domain.Categoria;

import java.util.List;

public interface CategoriaService {

    Categoria buscarCategoriaPorId(Long id);

    List<Categoria> buscarCategorias();
}
