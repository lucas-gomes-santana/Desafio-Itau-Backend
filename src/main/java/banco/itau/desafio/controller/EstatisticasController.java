package banco.itau.desafio.controller;

import banco.itau.desafio.dto.EstatisticasDTO;
import banco.itau.desafio.service.TransacaoService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.DoubleSummaryStatistics;

@RestController
@RequestMapping("/estatistica")
public class EstatisticasController {

    private final TransacaoService transacaoService;

    public EstatisticasController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @GetMapping
    public ResponseEntity<EstatisticasDTO> pegarEstatisticas(){
        DoubleSummaryStatistics statistics = transacaoService.pegarEstatisticas();

        return ResponseEntity.ok(new EstatisticasDTO(statistics));
    }
}
