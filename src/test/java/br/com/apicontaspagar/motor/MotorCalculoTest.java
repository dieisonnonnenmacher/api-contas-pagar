package br.com.apicontaspagar.motor;

import br.com.apicontaspagar.dto.ContasDto;
import org.joda.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class MotorCalculoTest{

    @InjectMocks
    private MotorCalculo motorCalculo;

    @Mock
    private ContasDto contasDto;

    @Test
    public void deveCalcularDiasAtraso() {
        int retornoEsperado= 15;
        when(contasDto.getDataPagamento()).thenReturn(new LocalDate("2020-11-18"));
        when(contasDto.getDataVencimento()).thenReturn(new LocalDate("2020-11-03"));

        assertEquals(retornoEsperado,motorCalculo.calcularDiasAtraso(contasDto));
    }

    @Test
    public void deveCalcularJuros() {
        double retornoEsperado = 1068.00;
        when(contasDto.getValorOriginal()).thenReturn(1000.00);
        when(contasDto.getDataPagamento()).thenReturn(new LocalDate("2020-11-09"));
        when(contasDto.getDataVencimento()).thenReturn(new LocalDate("2020-11-03"));
        assertEquals(retornoEsperado,motorCalculo.calcularValorCorrigido(contasDto),00.00);
    }
}

