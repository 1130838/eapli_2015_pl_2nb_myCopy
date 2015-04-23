/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.presentation;

import eapli.util.Console;

/**
 * The application's main menu
 *
 * @author Paulo Gandra Sousa
 */
public class MainMenu {

    public void mainLoop() {
        showMainMenu();
    }

    private boolean showMainMenu() {
        int option = -1;
        while (option != 0) {
            System.out.println("=============================");
            System.out.println("  myMoney - EXPENSE MANAGER  ");
            System.out.println("=============================\n");
            System.out.println("--- master tables ---");
            System.out.println("100. Register an expense type");
            System.out.println("101. List expense types\n");
            System.out.println("102. Register Expense Group");
            System.out.println("103. Disable Expense Group");
            System.out.println("\n104. Register Monthly Budget");
            System.out.println("---------------------");
            System.out.println("0. Exit\n\n");
            option = Console.readInteger("Please choose an option");
            switch (option) {
                case 0:
                    System.out.println("bye bye ...");
                    return true;
                case 100:
                    final RegisterExpenseTypeUI uc01 = new RegisterExpenseTypeUI();
                    uc01.show();
                    break;
                case 101:
                    final ListExpenseTypesUI uc01_L = new ListExpenseTypesUI();
                    uc01_L.show();
                    break;
                case 102:
                    final RegisterExpenseGroupUI uc01_G = new RegisterExpenseGroupUI();
                    uc01_G.show();
                    break;
                case 103:
                    final RegisterExpenseGroupUI uc03_G = new RegisterExpenseGroupUI();
                    uc03_G.doShow();
                    break;
                case 104:
                    final RegisterMonthlyBudgetUI uc01_O = new RegisterMonthlyBudgetUI();
                    uc01_O.show();
                    break;
                default:
                    System.out.println("option not recognized.");
                    break;
            }
        }
        return false;
    }

}
