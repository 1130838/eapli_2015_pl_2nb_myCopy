/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.application;

import eapli.mymoney.domain.ExpenseGroup;
import eapli.mymoney.persistence.ExpenseGroupRepository;
import eapli.mymoney.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author
 */
public class ShowListYearExpensesGroupController {

    int m_year;

    public ShowListYearExpensesGroupController(int year) {
        this.m_year = year;
    }

    public List<ExpenseGroup> getExpenseGroups() {
        ExpenseGroupRepository repo = Persistence.getRepositoryFactory().getExpenseGroupRepository();
        return repo.all();
    }

    public List<String> showListExpensesGroup() {
        List<String> mb = new ArrayList<>();
        List<ExpenseGroup> expenseGroups = getExpenseGroups();

        for (ExpenseGroup eg : expenseGroups) {
            String name = eg.getName();
            // float currentValue = eg.ge
            float estimation = eg.getEstimation().floatValue();
        }

        return mb;
    }

}
