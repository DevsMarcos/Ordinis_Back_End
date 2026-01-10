package os.system.SistemaOrdemServico.Domain.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Ordem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;
    private LocalDate dataAbertura;
    private LocalDate dataFechamento;
    private Double valor;



}
