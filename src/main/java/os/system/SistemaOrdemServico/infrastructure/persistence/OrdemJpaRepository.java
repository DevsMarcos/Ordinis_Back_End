package os.system.SistemaOrdemServico.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * Repositório JPA para a entidade OrdemJpaEntity.
 * Fornece operações de CRUD (salvar, buscar, deletar) prontas para uso
 * através do Spring Data JPA, utilizando o ID do tipo Long.
 */
public interface OrdemJpaRepository extends JpaRepository<OrdemJpaEntity, Long> {
    // O Spring lê o NOME do metodo e gera a query sozinho, sem você escrever SQL.
    //
    // findBy              -> indica que é uma busca
    // NomeDoCliente        -> precisa bater com o nome do campo em OrdemJpaEntity
    // Containing           -> gera um LIKE '%valor%' (busca parcial, não exata)
    // IgnoreCase           -> ignora maiúsculas/minúsculas na comparação
    //
    // Equivale a: SELECT * FROM ordem WHERE UPPER(nome_do_cliente) LIKE UPPER('%nome%')
    List<OrdemJpaEntity> findByNomeDoClienteContainingIgnoreCase(String nome);
}
