package os.system.SistemaOrdemServico.infrastructure;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import os.system.SistemaOrdemServico.application.DTOs.OrdemDTO;
import os.system.SistemaOrdemServico.Domain.Entities.Ordem;
import os.system.SistemaOrdemServico.application.Services.OrdemService;

import java.util.List;

@RestController
@RequestMapping("/ordens")
public class OrdemController {

  private OrdemService ordemService;

    public OrdemController(OrdemService ordemService) {
        this.ordemService = ordemService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ordem> buscaOrdemDeServico(@PathVariable Long id){
        Ordem ordem = ordemService.buscarOrdemPorId(id);

        return ResponseEntity.ok(ordem);
    };

    @GetMapping
    public ResponseEntity<List<Ordem>> buscarTodasAsOrdens(){
        List<Ordem> ordens = ordemService.buscarTodasAsOrdens();
        return ResponseEntity.ok(ordens);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Retorna 204 No Content se o delete funcionar
    public void deletarOrdem(@PathVariable Long id){
        ordemService.deletarOrdemPorId(id);
    }

    @PostMapping("/criarOrdem")
    public ResponseEntity<Ordem> criarOrdemServico(@RequestBody @Valid OrdemDTO dadosOrdem){// Adicionado @RequestBody
        Ordem novaOrdem = ordemService.cadastrarOrdem(dadosOrdem);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaOrdem); // Retorna 201 Created
    }

}
