package os.system.SistemaOrdemServico.infrastructure;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import os.system.SistemaOrdemServico.application.DTOs.OrdemDTO;
import os.system.SistemaOrdemServico.application.DTOs.OrdemRequestDTO;
import os.system.SistemaOrdemServico.application.Services.OrdemService;


@RestController
@RequestMapping("/ordens")
public class OrdemController {

  private final OrdemService ordemService;

    //Construtor do OrdemController inicializando o OrdemService;
    public OrdemController(OrdemService ordemService) {
        this.ordemService = ordemService;
    }

    /*
    Ponto de entrada da aplicação, aqui há o mapemanto para o endpoint de criação de OS
    * O metodo abaixo retorna especificamente um DTO(Data Transfer Object) da ORDEM
    */
    @PostMapping("/criarOrdem")
    public ResponseEntity<OrdemDTO> criarOrdemServico(@RequestBody OrdemRequestDTO dadosOrdem){
        /*Recebe por Parâmetro dados da OS, pradonizados pelo OrdemRequestDTO
        * Após isso cria uma nova ordem, utilizando como base o serviço de criação do OrdemService
        * e retorna para o front uma confirma de 201, criada
        * */
        OrdemDTO novaOrdem = ordemService.cadastrarOrdem(dadosOrdem);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaOrdem); // Retorna 201 Created
    }




}
