package com.wyden.padaria_server.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "produtos")
public class Produtos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_produto")
    private Long idProduto;

    @Column(name = "nome_produto", length = 255, nullable = false)
    private String nomeProduto;

    @Column(name = "descricao", length = 1000)
    private String descricao;

    @Column(name = "preco_medio", precision = 10, scale = 2, nullable = false)
    private BigDecimal precoMedio;

    @Column(name = "preco_grande", precision = 10, scale = 2, nullable = false)
    private BigDecimal precoGrande;

    @Column(name = "imagem_produto", length = 255)
    private String imagemProduto;

    @Column(name = "segunda_disponivel", nullable = false)
    private boolean segundaDisponivel;

    @Column(name = "terca_disponivel", nullable = false)
    private boolean tercaDisponivel;

    @Column(name = "quarta_disponivel", nullable = false)
    private boolean quartaDisponivel;

    @Column(name = "quinta_disponivel", nullable = false)
    private boolean quintaDisponivel;

    @Column(name = "sexta_disponivel", nullable = false)
    private boolean sextaDisponivel;

    @Column(name = "sabado_disponivel", nullable = false)
    private boolean sabadoDisponivel;

    @Column(name = "domingo_disponivel", nullable = false)
    private boolean domingoDisponivel;

    public Produtos(){}

    //Getters e setters

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPrecoMedio() {
        return precoMedio;
    }

    public void setPrecoMedio(BigDecimal precoMedio) {
        this.precoMedio = precoMedio;
    }

    public BigDecimal getPrecoGrande() {
        return precoGrande;
    }

    public void setPrecoGrande(BigDecimal precoGrande) {
        this.precoGrande = precoGrande;
    }

    public String getImagemProduto() {
        return imagemProduto;
    }

    public void setImagemProduto(String imagemProduto) {
        this.imagemProduto = imagemProduto;
    }

    public boolean isSegundaDisponivel() {
        return segundaDisponivel;
    }

    public void setSegundaDisponivel(boolean segundaDisponivel) {
        this.segundaDisponivel = segundaDisponivel;
    }

    public boolean isTercaDisponivel() {
        return tercaDisponivel;
    }

    public void setTercaDisponivel(boolean tercaDisponivel) {
        this.tercaDisponivel = tercaDisponivel;
    }

    public boolean isQuartaDisponivel() {
        return quartaDisponivel;
    }

    public void setQuartaDisponivel(boolean quartaDisponivel) {
        this.quartaDisponivel = quartaDisponivel;
    }

    public boolean isQuintaDisponivel() {
        return quintaDisponivel;
    }

    public void setQuintaDisponivel(boolean quintaDisponivel) {
        this.quintaDisponivel = quintaDisponivel;
    }

    public boolean isSextaDisponivel() {
        return sextaDisponivel;
    }

    public void setSextaDisponivel(boolean sextaDisponivel) {
        this.sextaDisponivel = sextaDisponivel;
    }

    public boolean isSabadoDisponivel() {
        return sabadoDisponivel;
    }

    public void setSabadoDisponivel(boolean sabadoDisponivel) {
        this.sabadoDisponivel = sabadoDisponivel;
    }

    public boolean isDomingoDisponivel() {
        return domingoDisponivel;
    }

    public void setDomingoDisponivel(boolean domingoDisponivel) {
        this.domingoDisponivel = domingoDisponivel;
    }
}
