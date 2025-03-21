package banco.itau.desafio.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;

public class TransacaoDTO {

    @NotNull
    @DecimalMin(value = "0.0")
    private double valor;

    @NotNull
    private OffsetDateTime dataHora;

    public TransacaoDTO(double valor, OffsetDateTime dataHora) {
        this.valor = valor;
        this.dataHora = dataHora;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(OffsetDateTime dataHora) {
        this.dataHora = dataHora;
    }
}