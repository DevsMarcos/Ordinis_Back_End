package os.system.SistemaOrdemServico.Domain.Services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import os.system.SistemaOrdemServico.Domain.DTOs.OrdemDTO;
import os.system.SistemaOrdemServico.Domain.Entities.Ordem;
import os.system.SistemaOrdemServico.Domain.Enums.OrdemStatus;
import os.system.SistemaOrdemServico.Domain.Repositories.OrdemRepository;

import java.time.LocalDate;
import java.util.List;
@Service
public class OrdemService {

    private OrdemRepository ordemRepository;

    public OrdemService(OrdemRepository ordemRepository) {
        this.ordemRepository = ordemRepository;
    }

    @Transactional()
    public Ordem cadastrarOrdem(OrdemDTO dados){

        Ordem novaOrdem = new Ordem(dados);

        return ordemRepository.save(novaOrdem);
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
