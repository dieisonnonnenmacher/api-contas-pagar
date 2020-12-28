package br.com.apicontaspagar.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
public class ContasDto {

    private String nome;
    private Double valorOriginal;
    private Double valorCorrigido;
    private Integer diasAtraso;
    private Date dataPagamento;
    private Date dataVencimento;

}
