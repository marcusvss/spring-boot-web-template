package br.com.mv.mvspring.domain.cliente;

import br.com.mv.mvspring.domain.common.Entidade;
import br.com.mv.mvspring.domain.estoque.Pedido;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Cliente extends Entidade implements Serializable {
    private static final long serialVersionUID = 8919458970623669177L;

    @Column
    private String nome;

    @Column
    private String email;

    @Column
    private String cpfCnpj;

    @Column
    private Integer tipoPessoa;

    @JsonManagedReference
    @OneToMany(mappedBy = "cliente")
    private List<Endereco> enderecos = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "TELEFONE")
    private Set<String> telefones = new HashSet<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(String nome, String email, String cpfCnpj, TipoPessoa tipoPessoa) {
        this.nome = nome;
        this.email = email;
        this.cpfCnpj = cpfCnpj;
        this.tipoPessoa = tipoPessoa.getCod();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public TipoPessoa getTipoPessoa() {
        return TipoPessoa.toEnum(tipoPessoa);
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa.getCod();
    }

    public Set<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(Set<String> telefones) {
        this.telefones = telefones;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
}
