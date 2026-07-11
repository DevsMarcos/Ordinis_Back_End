package os.system.SistemaOrdemServico.application.DTOs;

public record OrdemRequestDTO(
        String nomeDoCliente,
        String telefone,
        String produto,
        String marca,
        String modelo,
        String caracteristicaProduto
) {}
