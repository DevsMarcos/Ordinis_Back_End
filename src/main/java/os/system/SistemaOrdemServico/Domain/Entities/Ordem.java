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

    private String produto;

    private String marca;

    private String modelo;

    private String caracteristicaProduto;

    private LocalDate dataDeAbertura;

    private LocalDate dataFechamento;

    private double valorServico;

    private String descricaoDoServico;

    public Ordem( String nomeDoCliente, String telefone, String email, String produto, String marca, String modelo, String caracteristicaProduto, LocalDate dataDeAbertura) {
        this.status = OrdemStatus.ABERTA;
        this.nomeDoCliente = nomeDoCliente;
        this.telefone = telefone;
        this.produto = produto;
        this.marca = marca;
        this.caracteristicaProduto = caracteristicaProduto;
        this.dataDeAbertura = dataDeAbertura;
    }
}
