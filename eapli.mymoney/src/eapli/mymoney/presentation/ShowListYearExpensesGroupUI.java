/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.presentation;

import eapli.mymoney.application.ShowListYearExpensesGroupController;
import eapli.util.Console;
import java.util.List;

/**
 *
 * @author joaopaulo
 */
public class ShowListYearExpensesGroupUI extends BaseUI {
    int year;
    
    List<String> listToShow;
    
    /**
     * Instance of controller
     */
    private final ShowListYearExpensesGroupController controller = new ShowListYearExpensesGroupController();

    /**
     * Method to select the year and to submit the choosen year
     * 
     * @return boolean always true does not matter what happens
     */
    @Override
    public final boolean doShow() {
         //TO DO: query database for possible year to choose
        this.year = Console.readInteger("Select a year:");
        submitAndShow();
        return true;
    }
    
    /**
     * Method to show the result from the queried year
     */
    private void submitAndShow() {
  
        listToShow = controller.showListExpensesGroup(this.year);
        
        for (String line : listToShow) {
            System.out.println(line);
        }
        
    }

    /**
     * Method to implement....
     * @return 
     */
    @Override
    public final String headline() {
        return "override";
    }
    
}
