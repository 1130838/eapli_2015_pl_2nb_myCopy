package eapli.mymoney.domain;

import eapli.mymoney.application.ListExpenseLimitsController;
import eapli.mymoney.application.RegisterExpenseController;
import eapli.mymoney.presentation.RegisterExpenseUI;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brunodevesa on 14/05/15.
 */
public class LimitWatchDog_Expense implements Observable, Observer {

    List<Observer> listOfObservers = new ArrayList<>();

    // ExpenseRegisteredEvent expenseRegisteredEvent; // what he will observe
     RegisterExpenseUI registerExpenseUI;
    // Observable observable = null;
    RegisterExpenseController registerExpenseController;

    public LimitWatchDog_Expense(RegisterExpenseUI registerExpenseUI) {
        //this.expenseRegisteredEvent = expenseRegisteredEvent;
        this.registerExpenseUI = registerExpenseUI;
    }

    // @Override
    public boolean isViolated(ExpenseRegisteredEvent expenseRegisteredEvent) {

        // get info to the LimitExpense repository:
        ListExpenseLimitsController listExpenseLimitsController = new ListExpenseLimitsController();
        List<ExpenseLimit> listOfExpenseLimits = listExpenseLimitsController.getAllExpenseLimits();

        int teste = registerExpenseUI.getRegisterExpenseController().getTotalExpensesByExpenseType(expenseRegisteredEvent.expense.getExpenseType());
        System.out.println("teste total despesas = " + teste);


        for (int i = 0; i < listOfExpenseLimits.size(); i++) {

            if (listOfExpenseLimits.get(i).expenseType.description().equalsIgnoreCase(expenseRegisteredEvent.expense.getExpenseType().description())) {
                if (expenseRegisteredEvent.expense.getAmount().intValueExact() > listOfExpenseLimits.get(i).budgetLimitValue) {

                    ExpenseLimitViolatedEvent expenseLimitViolatedEvent = new ExpenseLimitViolatedEvent(expenseRegisteredEvent); // necessary ?

                   /* System.out.println("testing : budgetLimitValue " + listOfExpenseLimits.get(i).budgetLimitValue +
                            " value was crossed by expense " + expenseRegisteredEvent.expense.getAmount().intValueExact() +" !!! ");*/

                    System.out.println("test : this expense ( " + expenseRegisteredEvent.expense.getAmount().intValueExact() +
                            " ) is away beyond the " + expenseRegisteredEvent.expense.getExpenseType().description() +" buget limit ( " +
                            listOfExpenseLimits.get(i).budgetLimitValue + " )  !!!! ");
                    return true;
                }

                if (expenseRegisteredEvent.expense.getAmount().intValueExact()  +
                        registerExpenseUI.getRegisterExpenseController().getTotalExpensesByExpenseType(expenseRegisteredEvent.expense.getExpenseType())  > 0.01 * listOfExpenseLimits.get(i).limitYellow * listOfExpenseLimits.get(i).budgetLimitValue ) {

                    int totalDespesas = registerExpenseUI.getRegisterExpenseController().getTotalExpensesByExpenseType(expenseRegisteredEvent.expense.getExpenseType());
                    System.out.println("teste total despesas = " + totalDespesas);

                    ExpenseLimitViolatedEvent expenseLimitViolatedEvent = new ExpenseLimitViolatedEvent(expenseRegisteredEvent); // necessary ?

                   /* System.out.println("testing : budgetLimitValue " + listOfExpenseLimits.get(i).budgetLimitValue +
                            " value was crossed by expense " + expenseRegisteredEvent.expense.getAmount().intValueExact() +" !!! ");*/

                    System.out.println("test : this expense ( " + expenseRegisteredEvent.expense.getAmount().intValueExact() +
                            " ) will cross the " + expenseRegisteredEvent.expense.getExpenseType().description() +" yellow alert limit ( " +
                            listOfExpenseLimits.get(i).limitYellow + " % )  !!!! . Total expenses of this type = " + totalDespesas);
                    return true;
                }


                if (expenseRegisteredEvent.expense.getAmount().intValueExact() > 0.01 * listOfExpenseLimits.get(i).limitRed  * registerExpenseUI.getRegisterExpenseController().getTotalExpensesByExpenseType(expenseRegisteredEvent.expense.getExpenseType())) {

                    ExpenseLimitViolatedEvent expenseLimitViolatedEvent = new ExpenseLimitViolatedEvent(expenseRegisteredEvent); // necessary ?

                   /* System.out.println("testing : budgetLimitValue " + listOfExpenseLimits.get(i).budgetLimitValue +
                            " value was crossed by expense " + expenseRegisteredEvent.expense.getAmount().intValueExact() +" !!! ");*/

                    System.out.println("test : this expense ( " + expenseRegisteredEvent.expense.getAmount().intValueExact() +
                            " ) is away beyond the " + expenseRegisteredEvent.expense.getExpenseType().description() +" red alert limit ( " +
                            listOfExpenseLimits.get(i).limitRed + " % )  !!!! ");
                    return true;
                }


            }






        }


/*
        if (expenseRegisteredEvent.expense.amount.intValue() > 69) { // 69 for testing purposes. must be created LimitRepository and get the limits there

            return true;
        } else {
            return false;
        }
        return false;*/
        return false;
    }

    @Override
    public void addObserver(Observer observer) {
        listOfObservers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        listOfObservers.remove(observer);
    }

    @Override
    public void notifyObservers() {

        for (int i = 0; i < listOfObservers.size(); i++) {
            listOfObservers.get(i).update();
        }

    }

    @Override
    public void subscribe(Observable observable) {

    }

    @Override
    public void unsubscribe(Observable observable) {

    }

    @Override
    public void update() {
        notifyObservers();

    }


}
