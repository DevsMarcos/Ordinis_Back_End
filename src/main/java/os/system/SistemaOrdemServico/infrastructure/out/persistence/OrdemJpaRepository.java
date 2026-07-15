package os.system.SistemaOrdemServico.infrastructure.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Repositório JPA para a entidade OrdemJpaEntity.
 * Fornece operações de CRUD (salvar, buscar, deletar) prontas para uso
 * através do Spring Data JPA, utilizando o ID do tipo Long.
 */
public interface OrdemJpaRepository extends JpaRepository<OrdemJpaEntity, Long> {
}
