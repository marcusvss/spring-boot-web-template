package br.com.mv.mvspring.repository;

import br.com.mv.mvspring.domain.cliente.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
