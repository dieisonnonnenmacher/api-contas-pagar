package br.com.apicontaspagar.controller;

import br.com.apicontaspagar.dto.ContasDto;
import br.com.apicontaspagar.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/contas")
@RestController
public class ContaController {

    @Autowired
    ContaService contasService;


    @GetMapping("/listar")
    @ResponseStatus(HttpStatus.CREATED)
    public List<ContasDto> listarContas() {
        return contasService.listarContas();
    }

    @PostMapping ("/registrar")
    @ResponseStatus(HttpStatus.CREATED)
    public void registrarConta(@RequestBody final ContasDto contaDto ) {
        contasService.registrarConta(contaDto);
    }

}
