package os.system.SistemaOrdemServico.Domain.Repositories;

import os.system.SistemaOrdemServico.Domain.Entities.Ordem;

import java.util.Optional;

public interface OrdemRepository{
    Ordem salvar(Ordem ordem);

    Optional<Ordem> buscarPorId(Long id);
}