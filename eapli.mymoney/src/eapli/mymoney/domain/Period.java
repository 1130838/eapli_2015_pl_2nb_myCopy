/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.domain;

import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author Luís
 */
public class Period implements Serializable {

    private Calendar periodBegin;
    private Calendar periodEnd;

    public Period(final Calendar begin, final Calendar end) {
        periodBegin = begin;
        periodEnd = end;
    }

    public Calendar getPeriodBegin() {
        return periodBegin;
    }

    public Calendar getPeriodEnd() {
        return periodEnd;
    }
}
