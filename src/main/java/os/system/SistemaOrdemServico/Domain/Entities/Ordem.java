package os.system.SistemaOrdemServico.Domain.Entities;

import jakarta.persistence.*;
import os.system.SistemaOrdemServico.application.DTOs.OrdemDTO;
import os.system.SistemaOrdemServico.Domain.Enums.OrdemStatus;

import java.time.LocalDate;

@Entity
public class Ordem {

    public Ordem(String nomeDoCliente, String telefone, String produto, String marca, String modelo, String caracteristicaProduto) {
        this.status = OrdemStatus.ABERTA;
        this.nomeDoCliente = nomeDoCliente;
        this.telefone = telefone;
        this.produto = produto;
        this.marca = marca;
        this.modelo = modelo;
        this.caracteristicaProduto = caracteristicaProduto;
        this.dataDeAbertura = LocalDate.now();
    }

    private Long id;

    private  OrdemStatus status;

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

    public Long getId() {
        return id;
    }

    public OrdemStatus getStatus() {
        return status;
    }

    public String getNomeDoCliente() {
        return nomeDoCliente;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getProduto() {
        return produto;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getCaracteristicaProduto() {
        return caracteristicaProduto;
    }

    public LocalDate getDataDeAbertura() {
        return dataDeAbertura;
    }

    public LocalDate getDataFechamento() {
        return dataFechamento;
    }

    public double getValorServico() {
        return valorServico;
    }

    public String getDescricaoDoServico() {
        return descricaoDoServico;
    }
}
