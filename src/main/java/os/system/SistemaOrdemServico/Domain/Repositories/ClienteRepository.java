package os.system.SistemaOrdemServico.Domain.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import os.system.SistemaOrdemServico.Domain.Entities.Cliente;
import os.system.SistemaOrdemServico.Domain.Entities.Produto;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Aqui você já ganha métodos como save(), findAll(), findById(), delete()
}
