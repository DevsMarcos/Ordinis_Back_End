package os.system.SistemaOrdemServico.application.Services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import os.system.SistemaOrdemServico.application.DTOs.OrdemDTO;
import os.system.SistemaOrdemServico.Domain.Entities.Ordem;
import os.system.SistemaOrdemServico.Domain.Repositories.OrdemRepository;

import java.util.List;
@Service
public class OrdemService {

    private OrdemRepository ordemRepository;

    public OrdemService(OrdemRepository ordemRepository) {
        this.ordemRepository = ordemRepository;
    }

    @Transactional()
    public Ordem cadastrarOrdem(OrdemDTO dto){

        Ordem ordem = new Ordem(dto.nomeDoCliente(), dto.telefone(), dto.produto(), dto.marca(), dto.modelo(), dto.caracteristicaProduto());

        return ordemRepository.save(ordem);
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
