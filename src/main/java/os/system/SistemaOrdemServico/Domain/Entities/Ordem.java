package os.system.SistemaOrdemServico.Domain.Entities;

import jakarta.persistence.*;
import os.system.SistemaOrdemServico.application.DTOs.OrdemDTO;
import os.system.SistemaOrdemServico.Domain.Enums.OrdemStatus;

import java.time.LocalDate;

public class Ordem {
    private Long id;
    private  OrdemStatus status;
    private String nomeDoCliente;
    private String telefone;
    private String email;
    private String produto;
    private String marca;
    private String modelo;
    private String defeito;
    private LocalDate dataDeAbertura;
    private LocalDate dataFechamento;
    private double valorServico;
    private String descricaoDoServico;


    public static Ordem abrir(String nomeDoCliente, String telefone, String produto,
                              String marca, String modelo, String defeito) {
        Ordem ordem = new Ordem();
        ordem.status = OrdemStatus.ABERTA;
        ordem.nomeDoCliente = nomeDoCliente;
        ordem.telefone = telefone;
        ordem.produto = produto;
        ordem.marca = marca;
        ordem.modelo = modelo;
        ordem.defeito = defeito;
        ordem.dataDeAbertura = LocalDate.now();
        return ordem;
    }

    public static Ordem reconstituir(Long id, OrdemStatus status, String nomeDoCliente,
                                     String telefone, String produto, String marca, String modelo,
                                     String defeito, LocalDate dataDeAbertura,
                                     LocalDate dataFechamento) {
        Ordem ordem = new Ordem();
        ordem.id = id;
        ordem.status = status;
        ordem.nomeDoCliente = nomeDoCliente;
        ordem.telefone = telefone;
        ordem.produto = produto;
        ordem.marca = marca;
        ordem.modelo = modelo;
        ordem.defeito = defeito;
        ordem.dataDeAbertura = dataDeAbertura;
        ordem.dataFechamento = dataFechamento;
        return ordem;
    }

    public void atualizarDados(String telefone, String produto, String marca,
                               String modelo, String caracteristicaProduto) {
        if (telefone != null && !telefone.isBlank()) {
            this.telefone = telefone;
        }
        if (produto != null && !produto.isBlank()) {
            this.produto = produto;
        }
        if (marca != null && !marca.isBlank()) {
            this.marca = marca;
        }
        if (modelo != null && !modelo.isBlank()) {
            this.modelo = modelo;
        }
        if (caracteristicaProduto != null && !caracteristicaProduto.isBlank()) {
            this.defeito = defeito;
        }
    }



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

    public String getDefeito() {
        return defeito;
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
