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
        int ExpenseValue = expenseRegisteredEvent.getExpense().getAmount().intValue();
        int totalExpensesValue = repo.getTotalExpensesByExpenseType(expenseRegisteredEvent.getExpense().getExpenseType()) ;

        String expenseDescription = expenseRegisteredEvent.getExpense().getExpenseType().description();
        for (int i = 0; i < listOfExpenseLimits.size(); i++) {

            ExpenseType expenseType = listOfExpenseLimits.get(i).getExpenseType();

            if (expenseType.description().equalsIgnoreCase(expenseRegisteredEvent.getExpense().getExpenseType().description())) {

                int budgetLimitValue = listOfExpenseLimits.get(i).getLimitsByExpenseType(expenseRegisteredEvent.getExpense().getExpenseType()).getBudgetLimitValue();

                if (ExpenseValue > budgetLimitValue || totalExpensesValue > budgetLimitValue) {

                    System.out.println("this expense ( " + ExpenseValue +
                            " ) makes a total spending in " + expenseDescription + " expenses of "+ totalExpensesValue + ". This value is away beyond the buget limit ( " +
                             listOfExpenseLimits.get(i).getLimitsByExpenseType(expenseType).getBudgetLimitValue() + " )  !!!! ");
                    return true;
                }

                int yellowLimitValue =listOfExpenseLimits.get(i).getLimitYellow() * listOfExpenseLimits.get(i).getBudgetLimitValue() /100;
                int redLimitValue = listOfExpenseLimits.get(i).getLimitRed() * listOfExpenseLimits.get(i).getBudgetLimitValue()/ 100;

                if (totalExpensesValue > yellowLimitValue && totalExpensesValue < redLimitValue  ) {

                    System.out.println("Yellow Alert! this expense ( " + ExpenseValue +
                            " ) makes a total spending in " + expenseDescription + " expenses of "+ totalExpensesValue + ". This value cross the yellow limit : " +
                           listOfExpenseLimits.get(i).getLimitYellow() + " % x "+ budgetLimitValue+ " =  "+
                             listOfExpenseLimits.get(i).getLimitYellow() * budgetLimitValue / 100);
                    return true;
                }

                if (totalExpensesValue > redLimitValue && totalExpensesValue < budgetLimitValue  ) {

                    System.out.println("Red Alert! this expense ( " + ExpenseValue +
                            " ) makes a total spending in " + expenseDescription + " expenses of "+ totalExpensesValue + ". This value cross the red limit : " +
                            listOfExpenseLimits.get(i).getLimitRed() + " % x "+ budgetLimitValue+ " =  "+
                            listOfExpenseLimits.get(i).getLimitRed() * budgetLimitValue / 100);
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
