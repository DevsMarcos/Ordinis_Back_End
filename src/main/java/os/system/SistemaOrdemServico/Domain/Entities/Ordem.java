package os.system.SistemaOrdemServico.Domain.Entities;

import jakarta.persistence.*;
import os.system.SistemaOrdemServico.Domain.DTOs.OrdemDTO;
import os.system.SistemaOrdemServico.Domain.Enums.OrdemStatus;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Ordem {

    public Ordem(OrdemDTO ordem) {
        this.status = OrdemStatus.ABERTA;
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
    private Long id;

    @Column()
    private OrdemStatus status;

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

    @Column()
    private String caracteristicaProduto;

    @Column()
    private LocalDate dataDeAbertura;

    @Column(nullable = true)
    private LocalDate dataFechamento;

    @Column(nullable = true)
    private double valorServico;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrdemStatus getStatus() {
        return status;
    }

    public void setStatus(OrdemStatus status) {
        this.status = status;
    }

    public String getNomeDoCliente() {
        return nomeDoCliente;
    }

    public void setNomeDoCliente(String nomeDoCliente) {
        this.nomeDoCliente = nomeDoCliente;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCaracteristicaProduto() {
        return caracteristicaProduto;
    }

    public void setCaracteristicaProduto(String caracteristicaProduto) {
        this.caracteristicaProduto = caracteristicaProduto;
    }

    public LocalDate getDataDeAbertura() {
        return dataDeAbertura;
    }

    public void setDataDeAbertura(LocalDate dataDeAbertura) {
        this.dataDeAbertura = dataDeAbertura;
    }

    public LocalDate getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(LocalDate dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public double getValorServico() {
        return valorServico;
    }

    public void setValorServico(double valorServico) {
        this.valorServico = valorServico;
    }

    public String getDescricaoDoServico() {
        return descricaoDoServico;
    }

    public void setDescricaoDoServico(String descricaoDoServico) {
        this.descricaoDoServico = descricaoDoServico;
    }

    private String descricaoDoServico;

}
