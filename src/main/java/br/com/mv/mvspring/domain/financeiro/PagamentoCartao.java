package br.com.mv.mvspring.domain.financeiro;

import br.com.mv.mvspring.domain.estoque.Pedido;

import javax.persistence.Entity;

@Entity
public class PagamentoCartao extends Pagamento {

    private static final long serialVersionUID = 1543296883434935688L;

    private Integer numeroParcelas;

    public PagamentoCartao() {
    }

    public PagamentoCartao(int estadoPagamento, Pedido pedido, Integer numeroParcelas) {
        super(estadoPagamento, pedido);
        this.numeroParcelas = numeroParcelas;
    }

    public Integer getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(Integer numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }
}
