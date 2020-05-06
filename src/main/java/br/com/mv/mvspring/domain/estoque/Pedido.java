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
import java.util.Objects;

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

    public Pedido() {
    }

    public Pedido(Date dataPedido, Cliente cliente, Endereco endereco) {
        this.dataPedido = dataPedido;
        this.cliente = cliente;
        this.endereco = endereco;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(dataPedido, pedido.dataPedido) &&
                Objects.equals(pagamento, pedido.pagamento) &&
                Objects.equals(cliente, pedido.cliente) &&
                Objects.equals(endereco, pedido.endereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), dataPedido, pagamento, cliente, endereco);
    }
}
