package br.com.mv.mvspring.services;

import br.com.mv.mvspring.domain.estoque.Categoria;
import br.com.mv.mvspring.exceptions.ObjectNotFoundException;
import br.com.mv.mvspring.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public Categoria buscarCategoriaPorId(Long id) {
        return categoriaRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Categoria com id: " + id + " nao econtrada."));
    }

    @Override
    public List<Categoria> buscarCategorias() {
        return categoriaRepository.findAll();
    }
}
