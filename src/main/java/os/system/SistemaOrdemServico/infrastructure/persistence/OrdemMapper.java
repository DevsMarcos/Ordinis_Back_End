package os.system.SistemaOrdemServico.infrastructure.persistence;

import os.system.SistemaOrdemServico.Domain.Entities.Ordem;
import os.system.SistemaOrdemServico.application.DTOs.OrdemDTO;


/**
 * A função de um mapper numa alicação é realizar o mapeamento/conversão de um Ojbeto de Transferencia para uma Entidade de Domínio
 * ou até mesmo uma Entidade de Banco de dados. Isso é realizado para garantir a segurança da aplicação,
 * evitando expor tabelas sensiveis
 * */
public class OrdemMapper {

    //Converte a o dominio para a entidade JPA
    public static OrdemJpaEntity paraJpaEntity(Ordem ordem) {
        OrdemJpaEntity e = new OrdemJpaEntity();
        e.setId(ordem.getId());
        e.setStatus(ordem.getStatus());
        e.setNomeDoCliente(ordem.getNomeDoCliente());
        e.setTelefone(ordem.getTelefone());
        e.setProduto(ordem.getProduto());
        e.setMarca(ordem.getMarca());
        e.setModelo(ordem.getModelo());
        e.setCaracteristicaProduto(ordem.getCaracteristicaProduto());
        e.setDataDeAbertura(ordem.getDataDeAbertura());
        e.setDataFechamento(ordem.getDataFechamento());
        return e;
    }

    //Converte a JPA para domínio
    public static Ordem paraDomain(OrdemJpaEntity e) {
        return Ordem.reconstituir(e.getId(), e.getStatus(), e.getNomeDoCliente(), e.getTelefone(), e.getProduto(), e.getMarca(), e.getModelo(), e.getCaracteristicaProduto(), e.getDataDeAbertura(), e.getDataFechamento());
    }

    //COnverte o domínio para o DTO
    public static OrdemDTO paraDTO(Ordem ordem) {
        return new OrdemDTO(ordem.getId(), ordem.getStatus(), ordem.getNomeDoCliente(), ordem.getTelefone(), ordem.getProduto(), ordem.getMarca(), ordem.getModelo(), ordem.getCaracteristicaProduto(), ordem.getDataDeAbertura(), ordem.getDataFechamento());
    }
}