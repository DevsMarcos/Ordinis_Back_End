package os.system.SistemaOrdemServico.Domain.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import os.system.SistemaOrdemServico.Domain.Entities.Ordem;

public interface OrdemRepository extends JpaRepository<Ordem, Long> {
    // Aqui você já ganha métodos como save(), findAll(), findById(), delete()
}