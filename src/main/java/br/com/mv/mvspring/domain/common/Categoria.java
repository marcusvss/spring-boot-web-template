package br.com.mv.mvspring.domain.common;

import java.io.Serializable;
import java.util.Objects;

public class Categoria extends Entidade implements Serializable {

    private static final long serialVersionUID = 8566568370952844815L;

    private String nome;

    public Categoria() {
    }

    public Categoria(Long id, String nome) {
        super(id);
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(nome, categoria.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nome);
    }
}
