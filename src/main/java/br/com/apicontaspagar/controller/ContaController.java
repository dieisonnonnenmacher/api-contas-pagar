package br.com.apicontaspagar.controller;

import br.com.apicontaspagar.dto.ContasDto;
import br.com.apicontaspagar.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/contas")
@RestController
public class ContaController {

    @Autowired
    ContaService contasService;


    @GetMapping(value="/listar", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public List<ContasDto> listarContas() {
        return contasService.listarContas();
    }

    @PostMapping (value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void registrarConta(@RequestBody final ContasDto contaDto ) {
        contasService.registrarConta(contaDto);
    }

}
