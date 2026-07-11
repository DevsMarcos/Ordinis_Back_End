package os.system.SistemaOrdemServico.infrastructure.out.persistence;

import os.system.SistemaOrdemServico.Domain.Entities.Ordem;
import os.system.SistemaOrdemServico.Domain.Repositories.OrdemRepository;

import java.util.Optional;

public class OrdemRepositoryImpl implements OrdemRepository {
    private final OrdemJpaEntity jpaEntity;

    public OrdemRepositoryImpl(OrdemJpaEntity jpaEntity) {
        this.jpaEntity = jpaEntity;
    }

    @Override
    public Ordem salvar(Ordem ordem) {
        return null;
    }

    @Override
    public Optional<Ordem> buscarPorId(Long id) {
        return Optional.empty();
    }
}
