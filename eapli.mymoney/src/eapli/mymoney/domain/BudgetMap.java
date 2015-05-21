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
 * Class to calculate the forecasta
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

    /**
     * Constructor
     *
     * @param m_bu
     */
    public BudgetMap(Budget m_bu) {
        this.m_bu = m_bu;
        this.forecastMap = new HashMap<>();
    }

    public float lineForecast(float totalExpenseValue, int daysInMonth, int nowDay) {

        return (totalExpenseValue * daysInMonth) / nowDay;
    }

    /**
     * Method to estimate for each Entry the forecast to the end of month fill a
     * HashMap <Entry, Float>
     *
     * @return BudgetMap with HashMap filled with the forecasts
     */
    public HashMap<Entry, Float> calculateForecast() {

        ExpenseRepository exrepo = Persistence.getRepositoryFactory().
                getExpenseRepository();

        this.daysInMonth = Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH);
        this.nowDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

        this.m_list_entry = this.m_bu.retrieveEntryList();
        for (Entry e : m_list_entry) {
            m_budgetLine = e.getBudgetLine();
            //totalExpenseValue = exrepo.totalExpenseType(m_budgetLine);
            this.forecastValue = lineForecast(this.totalExpenseValue,
                    this.daysInMonth, this.nowDay);
            this.forecastMap.put(e, forecastValue);
        }
        return this.forecastMap;
    }

    /**
     * Method to get the HashMap with the forecasts
     *
     * @return HashMap
     */
    public HashMap<Entry, Float> getHashMap() {
        return this.forecastMap;
    }
}
