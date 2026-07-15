package os.system.SistemaOrdemServico.infrastructure.out.persistence;

import jakarta.persistence.*;
import os.system.SistemaOrdemServico.Domain.Enums.OrdemStatus;

import java.time.LocalDate;

/**
 * Esta classe é realiza o espelho da entidade de dompinio,
 * utilizada para realizar as interações co o banco de dados
 * de forma independente ao dompinio. Possui as anotações correspondetes necessárop*/


@Entity()
@Table(name = "ordens_servico")
public class OrdemJpaEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY) /*Metodo de geracao dos ids*/
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


    public void setId(Long id) {
        this.id = id;
    }

    public void setStatus(OrdemStatus status) {
        this.status = status;
    }

    public void setNomeDoCliente(String nomeDoCliente) {
        this.nomeDoCliente = nomeDoCliente;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setCaracteristicaProduto(String caracteristicaProduto) {
        this.caracteristicaProduto = caracteristicaProduto;
    }

    public void setDataDeAbertura(LocalDate dataDeAbertura) {
        this.dataDeAbertura = dataDeAbertura;
    }

    public void setDataFechamento(LocalDate dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public void setValorServico(double valorServico) {
        this.valorServico = valorServico;
    }

    public void setDescricaoDoServico(String descricaoDoServico) {
        this.descricaoDoServico = descricaoDoServico;
    }

    public OrdemStatus getStatus() {
        return status;
    }

    public Long getId() {
        return id;
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
