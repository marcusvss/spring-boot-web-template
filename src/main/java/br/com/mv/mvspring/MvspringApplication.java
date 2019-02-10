package br.com.mv.mvspring;

import br.com.mv.mvspring.domain.Categoria;
import br.com.mv.mvspring.domain.Cidade;
import br.com.mv.mvspring.domain.Estado;
import br.com.mv.mvspring.domain.Produto;
import br.com.mv.mvspring.repositories.CategoriaRepository;
import br.com.mv.mvspring.repositories.CidadeRepository;
import br.com.mv.mvspring.repositories.EstadoRespository;
import br.com.mv.mvspring.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class MvspringApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private EstadoRespository estadoRespository;

	@Autowired
	private CidadeRepository cidadeRepository;

	public static void main(String[] args) {
		SpringApplication.run(MvspringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		populandoCategoriaEProduto();
		populaEstadosECidades();
	}

	private void populaEstadosECidades() {
		Estado sp = new Estado("São Paulo");
		Estado rj = new Estado("Rio de Janeiro");
		Estado mg = new Estado("Minas Gerais");

		Cidade saopaulo = new Cidade("São Paulo", sp);
		Cidade campinas = new Cidade("Campinas", sp);
		Cidade indaiatuba = new Cidade("Indaiatuba", sp);
		Cidade niteroi = new Cidade("Niteroi", rj);
		Cidade angradosreis = new Cidade("Angra dos Reis", rj);
		Cidade saothome = new Cidade("São Thomé", mg);
		Cidade belohorizonte = new Cidade("Belo Horizonte", mg);

		sp.getCidades().addAll(Arrays.asList(saopaulo, campinas, indaiatuba));
		rj.getCidades().addAll(Arrays.asList(niteroi, angradosreis));
		mg.getCidades().addAll(Arrays.asList(saothome, belohorizonte));


		estadoRespository.saveAll(Arrays.asList(sp, rj, mg));
		cidadeRepository.saveAll(Arrays.asList(saopaulo, campinas, indaiatuba,
				niteroi, angradosreis, saothome, belohorizonte));


	}

	private void populandoCategoriaEProduto() {
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

