package os.system.SistemaOrdemServico.infrastructure;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import os.system.SistemaOrdemServico.application.DTOs.OrdemDTO;
import os.system.SistemaOrdemServico.Domain.Entities.Ordem;
import os.system.SistemaOrdemServico.application.DTOs.OrdemRequestDTO;
import os.system.SistemaOrdemServico.application.Services.OrdemService;

import java.util.List;

@RestController
@RequestMapping("/ordens")
public class OrdemController {

  private final OrdemService ordemService;

    public OrdemController(OrdemService ordemService) {
        this.ordemService = ordemService;
    }

    @PostMapping("/criarOrdem")
    public ResponseEntity<OrdemDTO> criarOrdemServico(@RequestBody OrdemRequestDTO dadosOrdem){// Adicionado @RequestBody
        OrdemDTO novaOrdem = ordemService.cadastrarOrdem(dadosOrdem);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaOrdem); // Retorna 201 Created
    }




}
