package br.com.mv.mvspring.services;

import br.com.mv.mvspring.domain.logistica.Cidade;
import br.com.mv.mvspring.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CidadeServiceImpl implements CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;


    @Override
    public Cidade buscarCidadePorNome(String nome) {
        return cidadeRepository.findAll().stream().filter(c -> c.getNome().equals(nome)).collect(Collectors.toList()).get(0);
    }

    @Override
    public List<Cidade> buscarCidades() {
        return cidadeRepository.findAll();
    }
}
