package br.com.mv.mvspring.domain.logistica;

import br.com.mv.mvspring.domain.common.Entidade;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Estado extends Entidade implements Serializable {
    private static final long serialVersionUID = 8982090596717644683L;

    @Column(nullable = false)
    private String nome;

    @JsonManagedReference
    @OneToMany(mappedBy = "estado")
    private List<Cidade> cidades = new ArrayList<>();

    public Estado() {
    }

    public Estado(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Estado estado = (Estado) o;

        return nome != null ? nome.equals(estado.nome) : estado.nome == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        return result;
    }
}
