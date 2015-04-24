/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.domain;

import eapli.mymoney.persistence.ExpenseRepository;
import eapli.mymoney.persistence.Persistence;
import eapli.util.DateTime;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author pag
 */
public class BudgetMap {

    Budget m_bu;
    List<String> m_lista;
    List<Entry> m_list_entry;
    Entry m_entry;
    BudgetLine m_budgetLine;
    float totalExpenseValue;
    DateTime data;
    Calendar cal;
    int daysInMonth;
    int nowDay;
    HashMap<Entry, Float> forecastMap;
    float forecastValue;

    public BudgetMap(Budget m_bu) {
        this.m_bu = m_bu;
    }

    public BudgetMap calculateForecast() {

        ExpenseRepository exrepo = Persistence.getRepositoryFactory().
                getExpenseRepository();

        this.cal = this.data.endOfCurrentMonth();
        this.daysInMonth = this.cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        this.nowDay = this.cal.DAY_OF_MONTH;

        this.forecastMap = new HashMap<>();

        // this.m_list_entry = this.m_bu.retrieveEntries();
        for (Entry e : m_list_entry) {
            m_budgetLine = e.getBudgetLine();

            //totalExpenseValue = exrepo.totalExpenseType(m_budgetLine);
            this.forecastValue = totalExpenseValue * this.daysInMonth / this.nowDay;
            this.forecastMap.put(e, forecastValue);

        }

        return this;
    }

    public HashMap<Entry, Float> getHashMap() {
        return this.forecastMap;

    }
}
