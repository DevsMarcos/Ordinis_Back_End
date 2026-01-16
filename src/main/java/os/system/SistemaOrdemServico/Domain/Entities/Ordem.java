package os.system.SistemaOrdemServico.Domain.Entities;

import jakarta.persistence.*;
import os.system.SistemaOrdemServico.Domain.DTOs.OrdemDTO;
import os.system.SistemaOrdemServico.Domain.Enums.OrdemStatus;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Ordem {

    public Ordem(OrdemDTO ordem) {
        this.status = OrdemStatus.ABERTA; // Atribui ao atributo da classe
        this.nomeDoCliente = ordem.nomeDoCliente();
        this.telefone = ordem.telefone();
        this.produto = ordem.produto();
        this.marca = ordem.marca();
        this.modelo = ordem.modelo();
        this.caracteristicaProduto = ordem.caracteristicaProduto();
        this.dataDeAbertura = LocalDate.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column() // O nome no MySQL será este
    private Long id;

    @Enumerated(EnumType.STRING)
    private  OrdemStatus status;

    @Column()
    private String nomeDoCliente;

    @Column()
    private String telefone;

    @Column(nullable = true)
    private String email;

    @Column()
    private String produto;

    @Column()
    private String marca;

    @Column()
    private String modelo;

    @Column(nullable = false)
    private String caracteristicaProduto;

    @Column()
    private LocalDate dataDeAbertura;

    @Column(nullable = true)
    private LocalDate dataFechamento;

    @Column(nullable = true)
    private double valorServico;



    private String descricaoDoServico;

}
