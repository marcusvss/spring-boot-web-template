package br.com.mv.mvspring.repository;

import br.com.mv.mvspring.domain.estoque.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
