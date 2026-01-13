package os.system.SistemaOrdemServico.Domain.DTOs;

import jakarta.validation.constraints.NotNull;

public record OrdemDTO(
        @NotNull(message = "O id do cliente é obrigatório")
        Long id

) {
}
