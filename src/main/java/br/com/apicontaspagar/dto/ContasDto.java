package br.com.apicontaspagar.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.joda.time.LocalDate;



@Getter
@Setter
@NoArgsConstructor
public class ContasDto {

    private String nome;
    private Double valorOriginal;
    private Double valorCorrigido;
    private Integer diasAtraso;
    private LocalDate dataPagamento;
    private LocalDate dataVencimento;
    private String regra_calculo;

}
