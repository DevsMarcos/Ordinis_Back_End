package os.system.SistemaOrdemServico.Domain.Services;

import org.springframework.stereotype.Service;
import os.system.SistemaOrdemServico.Domain.DTOs.OrdemDTO;
import os.system.SistemaOrdemServico.Domain.Entities.Ordem;
import os.system.SistemaOrdemServico.Domain.Repositories.OrdemRepository;

import java.util.List;
@Service
public class OrdemService {

    private OrdemRepository ordemRepository;

    public OrdemService(OrdemRepository ordemRepository) {
        this.ordemRepository = ordemRepository;
    }

    public Ordem cadastrarOrdem(OrdemDTO dados){


        return ordemRepository.save();
    }

    public Ordem buscarOrdemPorId(Long id){
        return ordemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ordem não encontrada!"));
    }

    public void deletarOrdemPorId(Long id){
        ordemRepository.deleteById(id);
    }
    public List<Ordem> buscarTodasAsOrdens(){
        return ordemRepository.findAll();
    }
}
