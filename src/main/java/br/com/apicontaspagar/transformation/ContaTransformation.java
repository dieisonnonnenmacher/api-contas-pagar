package br.com.apicontaspagar.transformation;

import br.com.apicontaspagar.dto.ContasDto;
import br.com.apicontaspagar.entity.ContasEntity;
import br.com.apicontaspagar.motor.MotorCalculo;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.*;
import java.util.stream.Collectors;

@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ContaTransformation {

    @Autowired
    private static MotorCalculo motorCalculo;

    public static ContasEntity transform(final ContasDto from) {
        ContasEntity to = new ContasEntity();

        to.setDataPagamento(Date.valueOf(from.getDataPagamento().toString()));
        to.setDataVencimento(Date.valueOf(from.getDataVencimento().toString()));
        to.setNome(from.getNome());
        to.setValorOriginal(from.getValorOriginal());
        to.setDiasAtraso(motorCalculo.calcularDiasAtraso(from));
        to.setValorCorrigido(motorCalculo.calcularValorCorrigido(from));
        to.setRegra_calculo(motorCalculo.getRegraCalculo(from));
        return to;
    }

    public static ContasDto  transform(final ContasEntity from) {
        ContasDto to = new ContasDto();

        to.setDataPagamento(new LocalDate(from.getDataPagamento()));
        to.setDataVencimento(new LocalDate(from.getDataVencimento()));
        to.setNome(from.getNome());
        to.setValorOriginal(from.getValorOriginal());
        to.setDiasAtraso(from.getDiasAtraso());
        to.setValorCorrigido(from.getValorCorrigido());
        to.setRegra_calculo(from.getRegra_calculo());
        return to;
    }

    public static List<ContasDto> transformContaDtoToEntity(final List<ContasEntity> listFrom) {
        return Optional
                .ofNullable(listFrom)
                .orElse(new ArrayList<ContasEntity>())
                .stream()
                .filter(Objects::nonNull)
                .map(ContaTransformation::transform)
                .collect(Collectors.toList());
    }
}
