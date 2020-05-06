package br.com.mv.mvspring.domain.financeiro;

import br.com.mv.mvspring.domain.estoque.Pedido;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class PagamentoBoleto extends Pagamento {

    private static final long serialVersionUID = -957256653310274828L;

    private Date dataVencimento;

    private Date dataPagamento;

    public PagamentoBoleto() {
    }

    public PagamentoBoleto(int estadoPagamento, Pedido pedido, Date dataVencimento, Date dataPagamento) {
        super(estadoPagamento, pedido);
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
}
