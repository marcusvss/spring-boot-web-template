package br.com.mv.mvspring;

import br.com.mv.mvspring.domain.Categoria;
import br.com.mv.mvspring.domain.Produto;
import br.com.mv.mvspring.repositories.CategoriaRepository;
import br.com.mv.mvspring.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class MvspringApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(MvspringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria("Informatica");
		Categoria cat2 = new Categoria("Escritorio");

		Produto computador = new Produto("Computador", 2000.00);
		Produto impressora = new Produto("Impressora", 300.00);
		Produto mouse = new Produto("Mouse", 80.00);

		cat1.getProdutos().addAll(Arrays.asList(computador, impressora, mouse));
		cat2.getProdutos().add(impressora);

		computador.getCategorias().add(cat1);
		impressora.getCategorias().addAll(Arrays.asList(cat1, cat2));
		mouse.getCategorias().add(cat1);
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(computador, impressora, mouse));
	}
}

