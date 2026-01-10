package os.system.SistemaOrdemServico.Domain.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Produtos")

public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Double valor;
    private String descricao;
}
