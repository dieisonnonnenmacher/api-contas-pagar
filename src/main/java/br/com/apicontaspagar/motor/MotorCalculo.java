package br.com.apicontaspagar.motor;

import br.com.apicontaspagar.dto.ContasDto;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;


@Component
public class MotorCalculo {

    final static int MULTA_ATE_TRES_DIAS = 2;
    final static double JUROS_ATE_TRES_DIAS = 0.001;
    final static int MULTA_ATE_CINCO_DIAS = 3;
    final static double JUROS_ATE_CINCO_DIAS = 0.002;
    final static int MULTA_SUPERIOR_CINCO_DIAS = 5;
    final static double JUROS_SUPERIOR_CINCO_DIAS = 0.003;

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss zzz");

    public static int calcularDiasAtraso(ContasDto conta) {
        int diasAtraso = 0;
        LocalDate dateTimePagamento = conta.getDataPagamento();
        LocalDate dateTimeVencimento = conta.getDataVencimento();

        if (conta.getDataPagamento().isAfter(conta.getDataVencimento()) ) {
            diasAtraso = Days.daysBetween(dateTimeVencimento, dateTimePagamento).getDays();
        }

        return diasAtraso;
    }
    public static double calcularValorCorrigido(ContasDto conta) {
        int diasAtraso = calcularDiasAtraso(conta);

        if(diasAtraso < 1 ) return conta.getValorOriginal();

        if(diasAtraso < 3){
            return conta.getValorOriginal() +
                    ((MULTA_ATE_TRES_DIAS * conta.getValorOriginal()) / 100)
                    + ((JUROS_ATE_TRES_DIAS * diasAtraso) * conta.getValorOriginal());
        } else if(diasAtraso < 5){
            return conta.getValorOriginal() +
                    ((MULTA_ATE_CINCO_DIAS * conta.getValorOriginal()) / 100)
                    + ((JUROS_ATE_CINCO_DIAS * diasAtraso) * conta.getValorOriginal());
        } else{
            return conta.getValorOriginal() +
                    ((MULTA_SUPERIOR_CINCO_DIAS * conta.getValorOriginal()) / 100)
                    + ((JUROS_SUPERIOR_CINCO_DIAS * diasAtraso) * conta.getValorOriginal());
        }
    }
}
