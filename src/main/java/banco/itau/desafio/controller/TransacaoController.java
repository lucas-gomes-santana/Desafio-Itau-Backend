package banco.itau.desafio.controller;

import banco.itau.desafio.dto.TransacaoDTO;
import banco.itau.desafio.model.Transacao;
import banco.itau.desafio.service.TransacaoService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;


@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private final TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @PostMapping
    public ResponseEntity<Void> criarTransacao(@RequestBody TransacaoDTO requisicao){

        if(requisicao.getDataHora().isAfter(OffsetDateTime.now())){
            return ResponseEntity.unprocessableEntity().build();
        }
        transacaoService.adicionarTransacao(new Transacao(requisicao.getValor(), requisicao.getDataHora()));

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> limparTransacoes(){
        transacaoService.limparTransacoes();
        return ResponseEntity.ok().build();
    }
}
