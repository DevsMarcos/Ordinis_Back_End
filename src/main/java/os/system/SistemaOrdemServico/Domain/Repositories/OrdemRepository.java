package os.system.SistemaOrdemServico.Domain.Repositories;

import os.system.SistemaOrdemServico.Domain.Entities.Ordem;

import java.util.List;
import java.util.Optional;

/**
 * Interface que que define os métodos a serem realizados no banco*/
public interface OrdemRepository{
    Ordem salvar(Ordem ordem);
    Optional<Ordem> buscarPorId(Long id);
    /** Nome livre, escolhido por nós — não segue convenção nenhuma do Spring Data,
     porque quem implementa esse metodo somos NÓS (no OrdemRepositoryImpl), não o framework.
     Retorna List, não Optional, porque pode ter 0, 1 ou vários resultados. **/
    List<Ordem> buscarPorNome(String nome);
    Ordem deletar(Ordem ordem);
}