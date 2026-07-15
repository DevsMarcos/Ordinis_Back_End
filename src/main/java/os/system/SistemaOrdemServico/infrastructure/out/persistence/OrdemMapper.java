package os.system.SistemaOrdemServico.infrastructure.out.persistence;

import os.system.SistemaOrdemServico.Domain.Entities.Ordem;
import os.system.SistemaOrdemServico.application.DTOs.OrdemDTO;

public class OrdemMapper {

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

    public static Ordem paraDomain(OrdemJpaEntity e) {
        return Ordem.reconstituir(e.getId(), e.getStatus(), e.getNomeDoCliente(), e.getTelefone(), e.getProduto(), e.getMarca(), e.getModelo(), e.getCaracteristicaProduto(), e.getDataDeAbertura(), e.getDataFechamento());
    }

    public static OrdemDTO paraDTO(Ordem ordem) {
        return new OrdemDTO(ordem.getNomeDoCliente(), ordem.getTelefone(), ordem.getProduto(), ordem.getMarca(), ordem.getModelo(), ordem.getCaracteristicaProduto());
    }
}