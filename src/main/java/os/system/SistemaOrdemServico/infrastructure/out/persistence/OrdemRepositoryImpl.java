package os.system.SistemaOrdemServico.infrastructure.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import os.system.SistemaOrdemServico.Domain.Entities.Ordem;
import os.system.SistemaOrdemServico.Domain.Repositories.OrdemRepository;

import java.util.Optional;

/**
 * Esta classe realiza a implementação da Interface do OrdemRepository
 * Desta forma a mesma é obrigada a implementar as funções básicas de
 * iteração com o banco de dados, definida na interface
 * */

@Repository
public class OrdemRepositoryImpl implements OrdemRepository {
    private final OrdemJpaRepository jpaRepository;

    /**Aqui é realizo a injeção da dependência do OrdemJpaRepository que extende a JPA do spring e fornece
    as funções nativas de manipulação do banco*/
    public OrdemRepositoryImpl( OrdemJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    /**Função implementada que salva uma ordem
     * Ela recebe uma entidade do domínio, converte a mesma para a entidade JPA
     * e salva a mesma no banco de dados, retornando um DTO para o front
     * */
    @Override
    public Ordem salvar(Ordem ordem) {
        OrdemJpaEntity entity = OrdemMapper.paraJpaEntity(ordem);
        OrdemJpaEntity salva = jpaRepository.save(entity);
        return OrdemMapper.paraDomain(salva);
    }

    /**Não implementado ainda*/
    @Override
    public Optional<Ordem> buscarPorId(Long id) {
        return Optional.empty();
    }
}
