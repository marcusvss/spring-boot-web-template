package br.com.mv.mvspring.domain.estoque;

import br.com.mv.mvspring.domain.cliente.Cliente;
import br.com.mv.mvspring.domain.cliente.Endereco;
import br.com.mv.mvspring.domain.common.Entidade;
import br.com.mv.mvspring.domain.financeiro.Pagamento;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Pedido extends Entidade implements Serializable {

    private static final long serialVersionUID = -3945923657828431104L;

    private Date dataPedido;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
    private Pagamento pagamento;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

}
