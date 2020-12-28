package br.com.apicontaspagar.motor;

import br.com.apicontaspagar.dto.ContasDto;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class MotorCalculo {
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss zzz");

    public static int calcularDiasAtraso(ContasDto conta) {
        int diasAtraso = 0;
        DateTime dateTimePagamento = new DateTime(conta.getDataPagamento());
        DateTime dateTimeVencimento = new DateTime(conta.getDataVencimento());

        if (conta.getDataPagamento().after(conta.getDataVencimento()) ) {
            diasAtraso = Days.daysBetween(dateTimeVencimento, dateTimePagamento).getDays();
        }

        return diasAtraso;
    }
    public static Double calcularValorCorrigido(ContasDto conta) {
        int diasAtraso = calcularDiasAtraso(conta);
        Double valor = 0.00;
        Double multa = 0.00;

        return valor;
    }
}
