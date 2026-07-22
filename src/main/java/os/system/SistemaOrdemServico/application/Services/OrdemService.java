package os.system.SistemaOrdemServico.application.Services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import os.system.SistemaOrdemServico.Domain.Exceptions.OrdemNaoEncontradaException;
import os.system.SistemaOrdemServico.application.DTOs.OrdemDTO;
import os.system.SistemaOrdemServico.Domain.Entities.Ordem;
import os.system.SistemaOrdemServico.Domain.Repositories.OrdemRepository;
import os.system.SistemaOrdemServico.application.DTOs.OrdemRequestDTO;
import os.system.SistemaOrdemServico.infrastructure.persistence.OrdemMapper;

import java.util.List;
import java.util.Optional;

@Service
public class OrdemService {

    //Declara o OrdemRepository
    private OrdemRepository ordemRepository;

    /**
     * Injeção de dependência por construtor.
     * Recebe o repositório pronto para uso, garantindo baixo acoplamento
     * e facilitando a criação de testes unitários (mocking).
     */
    public OrdemService(OrdemRepository ordemRepository) {
        this.ordemRepository = ordemRepository;
    }

    @Transactional()
    /**
    Função de criação da Ordem, utilizada no Controller, recebe do mesmo um DTO Request
    * dados específicos para a criação da OS
    * Ele istancia uma nova OS, e passa por parâmetros os dados do dto recebido
    * após isso, utiliza da função de salvar do repositório e retorna novamente a ordem de serviço em si criada
    * Utilizando de um Mapper, que converte da Entidade para o DTO, retornando ao Controller e após ao Front
    * */
    public OrdemDTO cadastrarOrdem(OrdemRequestDTO dto){
        Ordem ordem = Ordem.abrir(
                dto.nomeDoCliente(),
                dto.telefone(),
                dto.produto(),
                dto.marca(),
                dto.modelo(),
                dto.caracteristicaProduto()
        );
        Ordem salva = ordemRepository.salvar(ordem);
        return OrdemMapper.paraDTO(salva);
    }

    public Optional<OrdemDTO> buscarPorId(Long id) {
        return ordemRepository.buscarPorId(id)
                .map(OrdemMapper::paraDTO);
    }

    public List<OrdemDTO> buscarPorNome(String nome) {
        return ordemRepository
                .buscarPorNome(nome)          // 1. pede ao repository as Ordem que batem com o nome
                .stream()                      // 2. vira Stream pra poder mapear
                .map(OrdemMapper::paraDTO)     // 3. cada Ordem (domínio) vira OrdemDTO (contrato de saída)
                .toList();                     // 4. junta tudo numa List<OrdemDTO>
    }

    public void deletar(Long id) {
        if (ordemRepository.buscarPorId(id).isEmpty()) {
            throw new IllegalArgumentException("Ordem não encontrada: " + id);
        }
        ordemRepository.deletar(id);
    }

    public OrdemDTO atualizar(Long id, OrdemRequestDTO dto) {
        Ordem ordem = ordemRepository.buscarPorId(id)
                .orElseThrow(() -> new OrdemNaoEncontradaException(id));

        ordem.atualizarDados(dto.telefone(), dto.produto(), dto.marca(),
                dto.modelo(), dto.caracteristicaProduto());

        Ordem atualizada = ordemRepository.salvar(ordem);
        return OrdemMapper.paraDTO(atualizada);
    }

    public List<OrdemDTO> buscarTodas(){
        return ordemRepository.buscarTodas().stream().map(OrdemMapper::paraDTO).toList();
    }
}
