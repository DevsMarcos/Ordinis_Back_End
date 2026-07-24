package os.system.SistemaOrdemServico.infrastructure;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import os.system.SistemaOrdemServico.application.DTOs.OrdemDTO;
import os.system.SistemaOrdemServico.application.DTOs.OrdemRequestDTO;
import os.system.SistemaOrdemServico.application.Services.OrdemService;

import java.util.List;


@RestController
@RequestMapping("/ordens")
public class OrdemController {

  private final OrdemService ordemService;

    /**
    Construtor do OrdemController inicializando o OrdemService
     */;
    public OrdemController(OrdemService ordemService) {
        this.ordemService = ordemService;
    }

    /**
    *Ponto de entrada da aplicação, aqui há o mapemanto para o endpoint de criação de OS
    * O metodo abaixo retorna especificamente um DTO(Data Transfer Object) da ORDEM
    */
    @PostMapping("/criarOrdem")
    public ResponseEntity<OrdemDTO> criarOrdemServico(@RequestBody OrdemRequestDTO dadosOrdem){

        /**
        *Recebe por Parâmetro dados da OS, pradonizados pelo OrdemRequestDTO
        * Após isso cria uma nova ordem, utilizando como base o serviço de criação do OrdemService
        * e retorna para o front uma confirma de 201, criada
        * */
        OrdemDTO novaOrdem = ordemService.cadastrarOrdem(dadosOrdem);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaOrdem); // Retorna 201 Created
    }

    // OrdemController
    @GetMapping("/buscarPorId/{id}")
    public ResponseEntity<OrdemDTO> buscar(@PathVariable Long id) {
        return ordemService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Responde: GET /ordens?nome=algumacoisa
    @GetMapping
    public ResponseEntity<List<OrdemDTO>> buscarPorNome(@RequestParam String nome) {
        // @RequestParam pega o valor "nome" da query string da URL (depois do "?")
        List<OrdemDTO> resultado = ordemService.buscarPorNome(nome);

        // 200 OK sempre aqui, mesmo se a lista vier vazia —
        // lista vazia é uma resposta válida ("nenhuma ordem encontrada"), não é erro.
        return ResponseEntity.ok(resultado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        ordemService.deletar(id);

        // 204 No Content: convenção HTTP pra "deu certo, mas não tem corpo pra devolver"
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<OrdemDTO>atualizar(@PathVariable Long id, @RequestBody OrdemRequestDTO dto){
        OrdemDTO atualizada = ordemService.atualizar(id, dto);
        return ResponseEntity.ok(atualizada);
    }

    @GetMapping("/buscarOrdens")
    public ResponseEntity<List<OrdemDTO>> buscarTodas(){
        List<OrdemDTO> data = ordemService.buscarTodas();

        return ResponseEntity.ok(data);
    }

}
