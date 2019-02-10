package br.com.mv.mvspring.services;

import br.com.mv.mvspring.domain.Categoria;
import br.com.mv.mvspring.domain.Estado;
import br.com.mv.mvspring.exceptions.ObjectNotFoundException;
import br.com.mv.mvspring.repositories.CategoriaRepository;
import br.com.mv.mvspring.repositories.EstadoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstadoServiceImpl implements EstadoService {

    @Autowired
    private EstadoRespository estadoRespository;

    @Override
    public Estado buscarEstadoPorNome(String nome) {
        Optional<Estado> estado = Optional.of(
                estadoRespository.findAll()
                    .stream()
                    .filter(
                       e -> e.getNome().equals(nome))
                .collect(Collectors.toList()).get(0));
        return estado.orElseThrow(() -> new ObjectNotFoundException("Estado :" + nome + " nao encontado."));
    }

    @Override
    public List<Estado> buscarEstados() {
        return estadoRespository.findAll();
    }
}
