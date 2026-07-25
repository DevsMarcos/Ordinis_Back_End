package os.system.SistemaOrdemServico.application.DTOs;


import os.system.SistemaOrdemServico.Domain.Enums.OrdemStatus;

import java.time.LocalDate;

public record OrdemDTO(
        Long id,
        OrdemStatus status,
        String nomeDoCliente,
        String telefone,
        String produto,
        String marca,
        String modelo,
        String defeito,
        LocalDate dataDeAbertura,
        LocalDate dataFechamento
) {}
