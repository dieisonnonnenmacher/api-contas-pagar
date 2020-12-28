package br.com.apicontaspagar.transformation;

import br.com.apicontaspagar.dto.ContasDto;
import br.com.apicontaspagar.entity.ContasEntity;
import br.com.apicontaspagar.motor.MotorCalculo;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ContaTransformation {

    @Autowired
    private static MotorCalculo motorCalculo;

    public static ContasEntity transform(final ContasDto from) {
        ContasEntity to = new ContasEntity();

        to.setDataPagamento(from.getDataPagamento());
        to.setDataVencimento(from.getDataVencimento());
        to.setNome(from.getNome());
        to.setValorOriginal(from.getValorOriginal());
        to.setDiasAtraso(motorCalculo.calcularDiasAtraso(from));
        to.setValorCorrigido(motorCalculo.calcularValorCorrigido(from));
        return to;
    }

    public static List<ContasEntity> transform(final List<ContasDto> listFrom) {

        return Optional
                .ofNullable(listFrom)
                .orElse(new ArrayList<ContasDto>())
                .stream()
                .filter(Objects::nonNull)
                .map(ContaTransformation::transform)
                .collect(Collectors.toList());
    }
}
