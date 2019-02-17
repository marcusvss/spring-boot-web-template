package br.com.mv.mvspring.repositories;

import br.com.mv.mvspring.domain.estoque.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
