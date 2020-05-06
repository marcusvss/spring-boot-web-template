package br.com.mv.mvspring.repository;

import br.com.mv.mvspring.domain.financeiro.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

}
