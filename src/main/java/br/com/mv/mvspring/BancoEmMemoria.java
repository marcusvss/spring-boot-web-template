package br.com.mv.mvspring;

import br.com.mv.mvspring.domain.cliente.Cliente;
import br.com.mv.mvspring.domain.cliente.Endereco;
import br.com.mv.mvspring.domain.cliente.TipoPessoa;
import br.com.mv.mvspring.domain.estoque.Categoria;
import br.com.mv.mvspring.domain.estoque.Pedido;
import br.com.mv.mvspring.domain.estoque.Produto;
import br.com.mv.mvspring.domain.financeiro.EstadoPagamento;
import br.com.mv.mvspring.domain.financeiro.Pagamento;
import br.com.mv.mvspring.domain.financeiro.PagamentoBoleto;
import br.com.mv.mvspring.domain.financeiro.PagamentoCartao;
import br.com.mv.mvspring.domain.logistica.Cidade;
import br.com.mv.mvspring.domain.logistica.Estado;
import br.com.mv.mvspring.repository.CategoriaRepository;
import br.com.mv.mvspring.repository.CidadeRepository;
import br.com.mv.mvspring.repository.ClienteRepository;
import br.com.mv.mvspring.repository.EnderecoRepository;
import br.com.mv.mvspring.repository.EstadoRespository;
import br.com.mv.mvspring.repository.PagamentoRepository;
import br.com.mv.mvspring.repository.PedidoRepository;
import br.com.mv.mvspring.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

@Component
public class BancoEmMemoria implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EstadoRespository estadoRespository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    Estado sp;
    Estado rj;
    Estado mg;

    Cidade saopaulo;
    Cidade campinas;
    Cidade indaiatuba;
    Cidade niteroi;
    Cidade angradosreis;
    Cidade saothome;
    Cidade belohorizonte;

    Categoria cat1;
    Categoria cat2;

    Produto computador;
    Produto impressora;
    Produto mouse;

    Cliente pf1;
    Cliente pf2;
    Cliente pf3;
    Cliente pj1;
    Cliente pj2;

    Endereco end1;
    Endereco end2;

    Endereco end3;


    Endereco end4;


    Endereco end5;
    Endereco end6;

    Endereco end7;
    Endereco end8;
    Pedido ped1;
    Pedido ped2;
    Pagamento pag1;
    Pagamento pag2;


    @Override
    public void run(String... args) throws Exception {
        populandoCategoriaEProduto();
        populaEstadosECidades();
        populandoCliente();
        populandoPedido();
    }

    private void populandoPedido() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");

        ped1 = new Pedido(sdf.parse("30/09/2017 10:32"), pf1, end1);
        ped2 = new Pedido(sdf.parse("10/12/2017 19:35"), pf1, end2);

        pag1 = new PagamentoCartao(EstadoPagamento.QUITADO.getValor(), ped1, 6);
        ped1.setPagamento(pag1);

        pag2 = new PagamentoBoleto(EstadoPagamento.AGUARDANDO_PAGAMENTO.getValor(), ped2, sdf.parse("20/10/2017 00:00"), null);
        ped2.setPagamento(pag2);

        pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
        pagamentoRepository.saveAll(Arrays.asList(pag1, pag2));

        pf1.getPedidos().addAll(Arrays.asList(ped1, ped2));
        clienteRepository.save(pf1);
    }

    private void populaEstadosECidades() {
        sp = new Estado("São Paulo");
        rj = new Estado("Rio de Janeiro");
        mg = new Estado("Minas Gerais");

        saopaulo = new Cidade("São Paulo", sp);
        campinas = new Cidade("Campinas", sp);
        indaiatuba = new Cidade("Indaiatuba", sp);
        niteroi = new Cidade("Niteroi", rj);
        angradosreis = new Cidade("Angra dos Reis", rj);
        saothome = new Cidade("São Thomé", mg);
        belohorizonte = new Cidade("Belo Horizonte", mg);

        sp.getCidades().addAll(Arrays.asList(saopaulo, campinas, indaiatuba));
        rj.getCidades().addAll(Arrays.asList(niteroi, angradosreis));
        mg.getCidades().addAll(Arrays.asList(saothome, belohorizonte));


        estadoRespository.saveAll(Arrays.asList(sp, rj, mg));
        cidadeRepository.saveAll(Arrays.asList(saopaulo, campinas, indaiatuba,
                niteroi, angradosreis, saothome, belohorizonte));
    }

    private void populandoCategoriaEProduto() {
        cat1 = new Categoria("Informatica");
        cat2 = new Categoria("Escritorio");

        computador = new Produto("Computador", 2000.00);
        impressora = new Produto("Impressora", 300.00);
        mouse = new Produto("Mouse", 80.00);

        cat1.getProdutos().addAll(Arrays.asList(computador, impressora, mouse));
        cat2.getProdutos().add(impressora);

        computador.getCategorias().add(cat1);
        impressora.getCategorias().addAll(Arrays.asList(cat1, cat2));
        mouse.getCategorias().add(cat1);
        categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
        produtoRepository.saveAll(Arrays.asList(computador, impressora, mouse));
    }

    private void populandoCliente() {
        pf1 = new Cliente("José Machado", "j.machado@email.com", "111.111.111.11", TipoPessoa.PessoaFisica);
        pf1.getTelefones().addAll(Arrays.asList("11 980371854", "11 980371855"));


        pf2 = new Cliente("Joao Alencar", "jalencar@email.com", "222.222.222.22", TipoPessoa.PessoaFisica);
        pf2.getTelefones().addAll(Arrays.asList("11 55546667"));


        pf3 = new Cliente("Julia Aranha", "jaranha@email.com", "333.333.333.33", TipoPessoa.PessoaFisica);
        pf3.getTelefones().addAll(Arrays.asList("11 98766789"));

        pj1 = new Cliente("ALE Comercios e Transportes", "alecm@email.com", "99.946.110/0001-08", TipoPessoa.PessoaJuridica);
        pj1.getTelefones().addAll(Arrays.asList("11 12334433", "11 12344321"));

        pj2 = new Cliente("Carol Groomers School", "carol@email.com", "17.980.309/0001-98", TipoPessoa.PessoaJuridica);
        pj2.getTelefones().addAll(Arrays.asList("11 967191713", "19 22222222"));


        end1 = new Endereco("Rua Jose machado", 32, "Jardim Machado", "12123-123", pf1, campinas);
        end2 = new Endereco("Av. Ruy Barbosa", 82, "Parque Empresarial", "12355-123", pf1, campinas);
        end3 = new Endereco("Rua Jose machado", 57, "Jardim Marcondes", "12123-123", pf2, campinas);
        end4 = new Endereco("Rua da Lua", 87, "Jardim Machado", "12123-123", pf3, saothome);
        end5 = new Endereco("Faixa Amarela", 666, "Jardim Bonito", "12123-123", pj1, niteroi);
        end6 = new Endereco("Av. das Estrelas do mar", 23, "Parque Biscoito", "123555-123", pj1, angradosreis);
        end7 = new Endereco("Av. Edgar Facó", 123, "Freguesia", "12223-123", pj2, saopaulo);
        end8 = new Endereco("Rua Monte Aprazivel", 934, "Chacara da Barra", "13090-764", pj2,campinas);

        pf1.setEnderecos(Arrays.asList(end1, end2));
        pf2.setEnderecos(Arrays.asList(end3));
        pf3.setEnderecos(Arrays.asList(end4));
        pj1.setEnderecos(Arrays.asList(end5, end6));
        pj2.setEnderecos(Arrays.asList(end7, end8));

        clienteRepository.saveAll(Arrays.asList(pf1, pf2, pf3, pj1, pj2));
        enderecoRepository.saveAll(Arrays.asList(end1, end2, end3, end4, end5, end6, end7, end8));
    }
}
