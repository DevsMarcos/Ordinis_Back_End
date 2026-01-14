package os.system.SistemaOrdemServico.Domain.DTOs;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record OrdemDTO(
        @NotBlank(message = "O nome do cliente é obrigatório")
        String nomeDoCliente,

        @NotBlank(message = "O telefone é obrigatório")
        String telefone,

        @NotBlank(message = "O Produto é obrigatório")
        String produto,

        @NotBlank(message = "A marca é obrigatória")
        String marca,

        @NotBlank(message = "O modelo é obrigatório")
        String modelo,

        @NotBlank(message = "As características são obrigatórias")
        String caracteristicaProduto




) {
}
