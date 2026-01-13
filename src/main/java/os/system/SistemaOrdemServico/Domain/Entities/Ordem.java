package os.system.SistemaOrdemServico.Domain.Entities;

import jakarta.persistence.*;
import os.system.SistemaOrdemServico.Domain.Enums.OrdemStatus;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Ordem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private OrdemStatus status;

    private String nomeDoCliente;

    private String telefone;

    private String email;

    private String produto;

    private String marca;

    private String modelo;

    private String caracteristicaProduto;

    private LocalDate dataDeAbertura;

    private LocalDate dataFechamento;

    private double valorServico;

    private String descricaoDoServico;


}
