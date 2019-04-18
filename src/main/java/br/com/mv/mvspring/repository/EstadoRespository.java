package br.com.mv.mvspring.repository;

import br.com.mv.mvspring.domain.logistica.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRespository extends JpaRepository<Estado, Long> {
}
