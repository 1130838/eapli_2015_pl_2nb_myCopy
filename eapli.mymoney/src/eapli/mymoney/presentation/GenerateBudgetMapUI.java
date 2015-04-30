/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.presentation;

import eapli.mymoney.application.GenerateBudgetMapController;
import eapli.mymoney.domain.Budget;
import eapli.mymoney.domain.BudgetMap;
import eapli.mymoney.domain.Entry;
import eapli.util.Console;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author pag
 */
public class GenerateBudgetMapUI extends BaseUI {

    private final GenerateBudgetMapController mapController = new GenerateBudgetMapController();

    int bgSelect;
    BudgetMap buMap;
    HashMap<Entry, Float> hmTemp;

    @Override
    public final boolean doShow() {

        final List<Budget> budgetList = mapController.getRepositoryFactory();
        for (Budget bg : budgetList) {
            System.out.println(bg.description());
        }
        bgSelect = Console.readInteger("Select a Budget: ");
        submitAndShow();
        return true;
    }

    private void submitAndShow() {
        buMap = mapController.selectBudget(bgSelect);
        hmTemp = buMap.getHashMap();

        for (HashMap.Entry<Entry, Float> entry : hmTemp.entrySet()) {
            System.out.println("Key = " + entry.getKey().getValue() + " - Falta getBudgetLine(rubrica) -  Forecast: " + entry.getValue());
        }

    }

    @Override
    public final String headline() {
        return "override";
    }

}
