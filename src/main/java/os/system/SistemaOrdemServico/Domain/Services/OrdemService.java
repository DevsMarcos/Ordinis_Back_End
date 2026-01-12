package os.system.SistemaOrdemServico.Domain.Services;

import os.system.SistemaOrdemServico.Domain.Entities.Ordem;
import os.system.SistemaOrdemServico.Domain.Repositories.OrdemRepository;

public class OrdemService {

    private OrdemRepository ordemRepository;

    public OrdemService(OrdemRepository ordemRepository) {
        this.ordemRepository = ordemRepository;
    }

    public Ordem cadastrarOrdem(Ordem ordem){
        return ordemRepository.save(ordem);
    }

    public Ordem buscarOrdemPorId(Long id){
        return ordemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ordem não encontrada!"));
    }

    public void deletarOrdemPorId(Long id){
        ordemRepository.deleteById(id);
    }
}
