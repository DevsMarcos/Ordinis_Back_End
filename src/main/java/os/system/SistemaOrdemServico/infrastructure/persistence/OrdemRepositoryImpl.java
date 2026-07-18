package os.system.SistemaOrdemServico.infrastructure.persistence;

import org.springframework.stereotype.Repository;
import os.system.SistemaOrdemServico.Domain.Entities.Ordem;
import os.system.SistemaOrdemServico.Domain.Repositories.OrdemRepository;
import os.system.SistemaOrdemServico.application.DTOs.OrdemDTO;

import java.util.List;
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

    /**literalmente a operação "se existir valor dentro do Optional,
     * aplica essa função nele e devolve outro Optional; se não existir,
     * devolve Optional.empty() automaticamente"
     * */
    @Override
    public Optional<Ordem> buscarPorId(Long id) {
        return jpaRepository.findById(id)
                .map(OrdemMapper::paraDomain);
    }

    @Override
    public List<Ordem> buscarPorNome(String nome) {
        return jpaRepository
                .findByNomeDoClienteContainingIgnoreCase(nome) // 1. busca no banco, devolve List<OrdemJpaEntity>
                .stream()                                       // 2. transforma a List num Stream, pra poder processar item a item
                .map(OrdemMapper::paraDomain)                    // 3. converte cada OrdemJpaEntity em Ordem (domínio)
                .toList();                                       // 4. junta tudo de volta numa List<Ordem>
    }

    @Override
    public void deletar(Long id) {
        jpaRepository.deleteById(id);
    }


}
