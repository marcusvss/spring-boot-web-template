package br.com.mv.mvspring.domain.financeiro;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class PagamentoBoleto extends Pagamento {

    private static final long serialVersionUID = -957256653310274828L;

    private Date dataVencimento;

    private Date dataPagamento;

    public PagamentoBoleto(int estadoPagamento, Date dataVencimento, Date dataPagamento) {
        super(estadoPagamento);
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
