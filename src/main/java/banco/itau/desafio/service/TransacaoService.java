package banco.itau.desafio.service;

import banco.itau.desafio.model.Transacao;

import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

import java.util.DoubleSummaryStatistics;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;


@Service
public class TransacaoService {

    private final Queue<Transacao> transacoes = new ConcurrentLinkedDeque<>();

    public void adicionarTransacao(Transacao transacao){
        transacoes.add(transacao);
    }

    public void limparTransacoes(){
        transacoes.clear();
    }

    public DoubleSummaryStatistics pegarEstatisticas(){
        OffsetDateTime now = OffsetDateTime.now();

        return transacoes.stream()
                //.filter(t -> t.getDataHora().isAfter(now.minusSeconds(60)))
                .mapToDouble(Transacao::getValor)
                .summaryStatistics();
    }
}
