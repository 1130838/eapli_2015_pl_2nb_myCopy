/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.domain;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Luís
 */
public class Period {

    private Date periodBegin;
    private Date periodEnd;

    public Period(final Calendar begin, final Calendar end) {
        periodBegin = begin.getTime();
        periodEnd = end.getTime();
    }
}
