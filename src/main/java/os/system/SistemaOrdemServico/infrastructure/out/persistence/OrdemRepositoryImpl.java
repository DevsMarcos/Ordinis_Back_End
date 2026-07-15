package os.system.SistemaOrdemServico.infrastructure.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import os.system.SistemaOrdemServico.Domain.Entities.Ordem;
import os.system.SistemaOrdemServico.Domain.Repositories.OrdemRepository;

import java.util.Optional;

@Repository
public class OrdemRepositoryImpl implements OrdemRepository {
    private final OrdemJpaRepository jpaRepository;

    public OrdemRepositoryImpl( OrdemJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Ordem salvar(Ordem ordem) {
        OrdemJpaEntity entity = OrdemMapper.paraJpaEntity(ordem);
        OrdemJpaEntity salva = jpaRepository.save(entity);
        return OrdemMapper.paraDomain(salva);
    }

    @Override
    public Optional<Ordem> buscarPorId(Long id) {
        return Optional.empty();
    }
}
