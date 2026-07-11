package os.system.SistemaOrdemServico.application.Services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import os.system.SistemaOrdemServico.application.DTOs.OrdemDTO;
import os.system.SistemaOrdemServico.Domain.Entities.Ordem;
import os.system.SistemaOrdemServico.Domain.Repositories.OrdemRepository;
import os.system.SistemaOrdemServico.application.DTOs.OrdemRequestDTO;

import java.util.List;
@Service
public class OrdemService {

    private OrdemRepository ordemRepository;

    public OrdemService(OrdemRepository ordemRepository) {
        this.ordemRepository = ordemRepository;
    }

    @Transactional()
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
        return null;

    }

}
