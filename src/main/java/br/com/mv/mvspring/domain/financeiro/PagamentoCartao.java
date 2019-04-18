package br.com.mv.mvspring.domain.financeiro;

import javax.persistence.Entity;

@Entity
public class PagamentoCartao extends Pagamento {

    private static final long serialVersionUID = 1543296883434935688L;

    private Integer numeroParcelas;

    public PagamentoCartao(int estadoPagamento, Integer numeroParcelas) {
        super(estadoPagamento);
        this.numeroParcelas = numeroParcelas;
    }

    public Integer getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(Integer numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }
}
