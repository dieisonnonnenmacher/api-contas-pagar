package br.com.apicontaspagar.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "contas")
@Data
@DynamicUpdate
public class ContasEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "valor_original", nullable = false)
    private Double valorOriginal;

    @Column(name = "valor_corrigido", nullable = false)
    private Double valorCorrigido;

    @Column(name = "dias_atraso", nullable = false)
    private Integer diasAtraso;

    @Column(name = "data_pagamento", nullable = false)
    private Date dataPagamento;

    @Column(name = "data_vencimento", nullable = false)
    private Date dataVencimento;

}
