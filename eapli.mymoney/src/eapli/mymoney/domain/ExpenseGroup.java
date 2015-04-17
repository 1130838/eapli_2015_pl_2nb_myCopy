/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.domain;

import java.math.BigDecimal;
import java.util.Calendar;

/**
 *
 * @author Joel
 */
public class ExpenseGroup {

    private String nome;
    private Period period;
    private BigDecimal estimativa;

    public ExpenseGroup(final String expenseGroupText, final Calendar dataInicio, final Calendar dataFim, final BigDecimal estimativa) {
        this.nome = expenseGroupText;
        this.period = new Period(dataInicio, dataFim);
        this.estimativa = estimativa;
    }
}
