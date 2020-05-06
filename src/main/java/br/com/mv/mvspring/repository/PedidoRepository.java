package br.com.mv.mvspring.repository;

import br.com.mv.mvspring.domain.estoque.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
