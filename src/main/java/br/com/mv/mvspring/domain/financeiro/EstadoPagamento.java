package br.com.mv.mvspring.domain.financeiro;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

public enum EstadoPagamento {

    QUITADO("Quitado", 3),
    CANCELADO("Cancelado", 2),
    AGUARDANDO_PAGAMENTO("Aguardando Pagamento", 1);

    private String estadoPagamento;
    private int valor;


    EstadoPagamento(String estadoPagamento, int valor) {
        this.estadoPagamento = estadoPagamento;
        this.valor = valor;
    }

    public String getEstadoPagamento() {
        return estadoPagamento;
    }

    public int getValor() {
        return valor;
    }

    public static EstadoPagamento toEnum(int cod) {
        return Optional.of(
                Arrays.stream(EstadoPagamento.values()).filter(estado -> estado.getValor() == cod)
                        .collect(Collectors.toList()).get(0)
        ).orElseThrow(() -> new IllegalArgumentException("EstadoPagamento nao encontrado com cod: " + cod));
    }
}
