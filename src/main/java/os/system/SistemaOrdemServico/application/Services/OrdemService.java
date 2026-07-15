package os.system.SistemaOrdemServico.application.Services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import os.system.SistemaOrdemServico.application.DTOs.OrdemDTO;
import os.system.SistemaOrdemServico.Domain.Entities.Ordem;
import os.system.SistemaOrdemServico.Domain.Repositories.OrdemRepository;
import os.system.SistemaOrdemServico.application.DTOs.OrdemRequestDTO;
import os.system.SistemaOrdemServico.infrastructure.out.persistence.OrdemMapper;

import java.util.List;
@Service
public class OrdemService {

    private OrdemRepository ordemRepository;

    public OrdemService(OrdemRepository ordemRepository) {
        this.ordemRepository = ordemRepository;
    }

    @Transactional()
    /*Função de criação da Ordem, utilizada no Controller, recebe do mesmo um DTO Request
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

}
