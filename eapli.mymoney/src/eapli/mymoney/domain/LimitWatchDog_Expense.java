package eapli.mymoney.domain;

import eapli.mymoney.application.ListExpenseLimitsController;
import eapli.mymoney.application.RegisterExpenseController;
import eapli.mymoney.persistence.ExpenseRepository;
import eapli.mymoney.persistence.inmemory.ExpenseRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brunodevesa on 14/05/15.
 */
public class LimitWatchDog_Expense implements Observable, Observer {

    List<Observer> listOfObservers = new ArrayList<>();

    ExpenseRegisteredEvent expenseRegisteredEvent; // what he will observe
    ExpenseRepository repo = new ExpenseRepositoryImpl();
    RegisterExpenseController registerExpenseController;

    public LimitWatchDog_Expense(ExpenseRegisteredEvent expenseRegisteredEvent, ExpenseRepository repo) {
        this.repo = repo;
        this.expenseRegisteredEvent = expenseRegisteredEvent;
    }


    public boolean isViolated() {

        // get info to the LimitExpense repository:
        ListExpenseLimitsController listExpenseLimitsController = new ListExpenseLimitsController();
        List<ExpenseLimit> listOfExpenseLimits = listExpenseLimitsController.getAllExpenseLimits();

        // verify violation: ( business rules - must be in WatchDog Class )
        int amountOfExpense = expenseRegisteredEvent.getExpense().getAmount().intValue();
        int totalExpensesValue = repo.getTotalExpensesByExpenseType(expenseRegisteredEvent.getExpense().getExpenseType()) + amountOfExpense;

        String expenseDescription = expenseRegisteredEvent.getExpense().getExpenseType().description();
        for (int i = 0; i < listOfExpenseLimits.size(); i++) {

            ExpenseType expenseType = listOfExpenseLimits.get(i).getExpenseType();

            if (expenseType.description().equalsIgnoreCase(expenseRegisteredEvent.getExpense().getExpenseType().description())) {

                int budgetLimitValue = listOfExpenseLimits.get(i).getLimitsByExpenseType(expenseRegisteredEvent.getExpense().getExpenseType()).getBudgetLimitValue();

                if (amountOfExpense > budgetLimitValue) {

                    System.out.println("this expense ( " + amountOfExpense +
                            " ) is away beyond the " + expenseDescription + " buget limit ( " +
                            listOfExpenseLimits.get(i).getLimitsByExpenseType(expenseType).getBudgetLimitValue() + " )  !!!! ");
                    return true;
                }

                double yellowLimitValue = 0.01 * listOfExpenseLimits.get(i).getLimitYellow() * listOfExpenseLimits.get(i).getBudgetLimitValue();
                if (totalExpensesValue > yellowLimitValue) {

                    System.out.println("test : this expense ( " + amountOfExpense +
                            " ) will cross the " + expenseDescription + " yellow alert limit ( " +
                            listOfExpenseLimits.get(i).getLimitYellow() + " % )  !!!! . Total expenses of this type = " + totalExpensesValue);
                    return true;
                }

                if (totalExpensesValue > 0.01 * listOfExpenseLimits.get(i).getLimitRed() * listOfExpenseLimits.get(i).getBudgetLimitValue()) {

                    System.out.println("test : this expense ( " + amountOfExpense +
                            " ) will cross the " + expenseDescription + " red alert limit ( " +
                            listOfExpenseLimits.get(i).getLimitRed() + " % )  !!!! . Total expenses of this type = " + totalExpensesValue);
                    return true;
                }
            }
        }

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

        if (isViolated()) {
            notifyObservers();
        }

    }


}
