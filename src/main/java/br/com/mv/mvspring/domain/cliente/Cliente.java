package br.com.mv.mvspring.domain.cliente;

import br.com.mv.mvspring.domain.common.Entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

@Entity
public class Cliente extends Entidade implements Serializable {
    private static final long serialVersionUID = 8919458970623669177L;

    @Column
    private String nome;

    @Column
    private String email;

    @Column
    private String cpfCnpj;

    @Enumerated(value = EnumType.ORDINAL)
    private TipoPessoa tipoPessoa;

    public Cliente(String nome, String email, String cpfCnpj, TipoPessoa tipoPessoa) {
        this.nome = nome;
        this.email = email;
        this.cpfCnpj = cpfCnpj;
        this.tipoPessoa = tipoPessoa;
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
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }
}
