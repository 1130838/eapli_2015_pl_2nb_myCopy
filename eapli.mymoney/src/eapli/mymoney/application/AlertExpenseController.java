package eapli.mymoney.application;

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
    RegisterExpenseUI registerExpenseUI;
    ExpenseRepository repo;
    LimitWatchDog_Expense limitWatchDog_Expense;

    ExpenseRepositoryImpl expenseRepositoryImpl = new ExpenseRepositoryImpl();

    public AlertExpenseController(RegisterExpenseUI registerExpenseUI, ExpenseRegisteredEvent expenseRegisteredEvent, ExpenseRepository repo) {

        this.registerExpenseUI = registerExpenseUI;
        this.expenseRegisteredEvent = expenseRegisteredEvent;
        this.expenseRepositoryImpl = (ExpenseRepositoryImpl) repo;

        limitWatchDog_Expense = new LimitWatchDog_Expense(expenseRegisteredEvent, expenseRepositoryImpl); // to be able to subscribe UI as a observer of Watch^Dog

        //subscribing Observer pattern rules ( always in the controller ):
        limitWatchDog_Expense.subscribe(expenseRepositoryImpl); // limitWatchDog wants to know about ExpenseRepositoryImpl
        expenseRepositoryImpl.addObserver(limitWatchDog_Expense); // ExpenseRepositoryImpl wants to be observed by limitWatchDog

        registerExpenseUI.subscribe(limitWatchDog_Expense); // UI wants to know about limitWatchDog_Expense
        limitWatchDog_Expense.addObserver(registerExpenseUI); // limitWatchDog_Expense wants to be observed by UI

    }

}
