package br.com.apicontaspagar.validator;

import br.com.apicontaspagar.dto.ContasDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import static java.util.Objects.isNull;

@Component
@Slf4j
public class ContaValidator {

    public boolean validate(final ContasDto request) {
        return !isRequestInvalid(request);
    }

    private boolean isRequestInvalid(final ContasDto request) {
        return isRequestValuesNull(request);
    }

    private boolean isRequestValuesNull(final ContasDto request) {
        return isNull(request)
                || isNull(request.getDataPagamento())
                || isNull(request.getDataVencimento())
                || isNull(request.getNome())
                || isNull(request.getValorOriginal());
    }
}
