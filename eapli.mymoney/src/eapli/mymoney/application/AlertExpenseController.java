package eapli.mymoney.application;

import eapli.mymoney.domain.ExpenseLimitViolatedEvent;
import eapli.mymoney.domain.ExpenseRegisteredEvent;
import eapli.mymoney.domain.LimitWatchDog_Expense;
import eapli.mymoney.persistence.ExpenseRepository;
import eapli.mymoney.persistence.jpa.ExpenseRepositoryImpl;
import eapli.mymoney.presentation.RegisterExpenseUI;

/**
 * Created by bruno.devesa on 20-05-2015.
 */


public class AlertExpenseController {

    ExpenseRegisteredEvent expenseRegisteredEvent;
    ExpenseLimitViolatedEvent expenseLimitViolatedEvent;
    RegisterExpenseUI registerExpenseUI;
    //ExpenseRepository repo;
    LimitWatchDog_Expense limitWatchDog_Expense;

    ExpenseRepositoryImpl expenseRepositoryImpl = new ExpenseRepositoryImpl();

    public AlertExpenseController(RegisterExpenseUI registerExpenseUI, ExpenseRegisteredEvent expenseRegisteredEvent, ExpenseRepository repo) {

        this.registerExpenseUI = registerExpenseUI;
        this.expenseRegisteredEvent = expenseRegisteredEvent;
        //this.expenseRepositoryImpl = repo;

        limitWatchDog_Expense = new LimitWatchDog_Expense(registerExpenseUI); // to be able to subscribe UI as a observer of Watch^Dog

        limitWatchDog_Expense.subscribe(expenseLimitViolatedEvent); // limitWatchDog wants to know about ExpenseRepositoryImpl
        expenseRepositoryImpl.addObserver(limitWatchDog_Expense); // ExpenseRepositoryImpl wants to be observed by limitWatchDog

        registerExpenseUI.subscribe(limitWatchDog_Expense); // UI wants to know about limitWatchDog_Expense
        limitWatchDog_Expense.addObserver(registerExpenseUI); // limitWatchDog_Expense wants to be observed by UI






    }

    public void checkExpense() {

        if (limitWatchDog_Expense.isViolated(expenseRegisteredEvent)){
            limitWatchDog_Expense.notifyObservers();
        }

    }


}
