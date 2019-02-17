package br.com.mv.mvspring.domain.cliente;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

public enum TipoCliente {

    PessoaFisica(1, "Pessoa Fisica"),
    PessoaJuridica(2, "Pessoa Juridica");

    private int cod;
    private String descricao;

    TipoCliente(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoCliente toEnum(Integer cod) {
        return Optional.of(Arrays.stream(TipoCliente.values()).filter(tc -> tc.getCod() == cod)
                .collect(Collectors.toList()).get(0))
                .orElseThrow(() -> (new IllegalArgumentException("Id invalido :" + cod)));
    }
}
