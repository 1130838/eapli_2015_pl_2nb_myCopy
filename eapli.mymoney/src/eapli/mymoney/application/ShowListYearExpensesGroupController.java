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
    /**
     * Constructor of the controller
     * 
     * @param year passed by user
     */
    public ShowListYearExpensesGroupController() {
        
    }
   
   /**
    * 
    * Get List of Expenses group from the repository
    * 
    * @return Expenses group repository
    */
    public List<ExpenseGroup> getExpenseGroups(int year) {
        ExpenseGroupRepository repo = Persistence.getRepositoryFactory().getExpenseGroupRepository();
        return repo.findByYear(year);
    }
    
    
    /**
     * Show the list of expenses filtered by year ending in the year passed as 
     * argument
     * 
     * @return List of results, project, expense group, estimation and value
     */
    public List<String> showListExpensesGroup(int year) {
        List<String> mb = new ArrayList<>();
        List<ExpenseGroup> expenseGroups = getExpenseGroups(year);

        for (ExpenseGroup eg : expenseGroups) {
            String name = eg.getName();
            float currentValue = eg.obtainExpenseYear();
            float estimation = eg.getEstimation().floatValue();
        }

        return mb;
    }

}
