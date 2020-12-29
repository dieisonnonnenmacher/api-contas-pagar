package br.com.apicontaspagar.service;

import br.com.apicontaspagar.dto.ContasDto;
import br.com.apicontaspagar.repository.ContasRepository;
import br.com.apicontaspagar.transformation.ContaTransformation;
import br.com.apicontaspagar.validator.ContaValidator;
import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class ContaService {

    @Autowired
    private ContaValidator contaValidator;

    @Autowired
    private ContasRepository contasRepository;

    @Autowired
    private ContaTransformation transformation;

    public void registrarConta(ContasDto contaDto){
        if (contaValidator.validate(contaDto)){
            contasRepository.save(ContaTransformation.transform(contaDto));
        }
        log.error("Dados informados são invãlidos.",contaDto);
        return ;
    }

    public List<ContasDto> listarContas(){
        return transformation.transformContaDtoToEntity(contasRepository.findAll());
    }
}
