package br.com.mv.mvspring.domain.financeiro;

import br.com.mv.mvspring.domain.common.Entidade;
import br.com.mv.mvspring.domain.estoque.Pedido;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pagamento extends Entidade implements Serializable {

    private static final long serialVersionUID = 3069754311194660835L;

    private Integer estadoPagamento;

    @OneToOne
    private Pedido pedido;

    public Pagamento(Integer estadoPagamento) {
        this.estadoPagamento = estadoPagamento;
    }

    public EstadoPagamento getEstadoPagamento() {
        return EstadoPagamento.toEnum(this.estadoPagamento);
    }

    public void setEstadoPagamento(EstadoPagamento estadoPagamento) {
        this.estadoPagamento = estadoPagamento.getValor();
    }
}
