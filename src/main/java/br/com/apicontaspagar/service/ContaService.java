package br.com.apicontaspagar.service;

import br.com.apicontaspagar.dto.ContasDto;
import br.com.apicontaspagar.entity.ContasEntity;
import br.com.apicontaspagar.repository.ContasRepository;
import br.com.apicontaspagar.transformation.ContaTransformation;
import br.com.apicontaspagar.validator.ContaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaService {

    @Autowired
    private ContaValidator contaValidator;

    @Autowired
    private ContasRepository contasRepository;

    public void registrarConta(ContasDto contaDto){
        if (contaValidator.validate(contaDto)){
            contasRepository.save(ContaTransformation.transform(contaDto));
        }
        return ;
    }

    public List<ContasDto> listarContas(){
        return null;
    }
}
