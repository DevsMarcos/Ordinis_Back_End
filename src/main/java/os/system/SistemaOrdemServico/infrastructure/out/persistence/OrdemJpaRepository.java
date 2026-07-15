package os.system.SistemaOrdemServico.infrastructure.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdemJpaRepository extends JpaRepository<OrdemJpaEntity, Long> {
}
