package os.system.SistemaOrdemServico.infrastructure.out.persistence;

import jakarta.persistence.*;
import os.system.SistemaOrdemServico.Domain.Enums.OrdemStatus;

import java.time.LocalDate;

@Entity()
@Table(name = "ordem")
public class OrdemJpaEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private OrdemStatus status;
    @Column()
    private String nomeDoCliente;

    @Column()
    private String telefone;

    @Column()
    private String email;

    @Column()
    private String produto;

    @Column()
    private String marca;

    @Column()
    private String modelo;

    @Column()
    private String caracteristicaProduto;

    @Column()
    private LocalDate dataDeAbertura;

    @Column()
    private LocalDate dataFechamento;

    @Column()
    private double valorServico;

    @Column()
    private String descricaoDoServico;
}
