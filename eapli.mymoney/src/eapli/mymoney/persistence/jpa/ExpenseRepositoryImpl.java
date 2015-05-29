package eapli.mymoney.persistence.jpa;

import eapli.framework.model.Money;
import eapli.framework.persistence.jpa.JpaRepository;
import eapli.mymoney.domain.*;
import eapli.mymoney.persistence.ExpenseRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by brunodevesa on 16/04/15.
 */
public class ExpenseRepositoryImpl
        extends JpaRepository<Expense, Integer>
        implements ExpenseRepository, Observable {

    List<Observer> listOfInterested = new ArrayList<>();

    public ExpenseRepositoryImpl() {

    }

    @Override
    public Money getWeekExpediture(Period period) {
        Money total = Money.euros(0.00);

        for (Expense expense : all()) {
            if (period.isBetween(expense.getDate())) {
                total = total.
                        add(Money.euros(expense.getAmount().doubleValue()));
            }
        }

        return total;
    }

    @Override
    protected String persistenceUnitName() {
        return PersistenceSettings.PERSISTENCE_UNIT_NAME;
    }

    @Override
    public Money getMonthExpediture(Period period) {
        Money total = Money.euros(0.00);

        for (Expense expense : all()) {
            if (period.isBetween(expense.getDate())) {
                total = total.
                        add(Money.euros(expense.getAmount().doubleValue()));
            }
        }

        return total;
    }


    public boolean add(Expense entity) {
        if (entity == null) {
            throw new IllegalArgumentException();
        }

        EntityManager em = entityManager();
        try {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.persist(entity);
            tx.commit();
        } finally {

            notifyObservers(); //here he will only notify limitWatchDog that an expense was registered

            em.close();

            return true;
        }
    }


    // added here :
    public int getTotalExpensesByExpenseType(ExpenseType expenseType) {
        int totalExpenseValue = 0;
        List<Expense> listOfExpensesRegistered = this.all();

        for (int i = 0; i < listOfExpensesRegistered.size(); i++) {
            if (listOfExpensesRegistered.get(i).getExpenseType().description().equalsIgnoreCase(expenseType.description()))
                totalExpenseValue += listOfExpensesRegistered.get(i).getAmount().intValue();
        }
        return totalExpenseValue;
    }


    @Override
    public void addObserver(Observer observer) {
        listOfInterested.add(observer);

    }

    @Override
    public void removeObserver(Observer observer) {

    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < listOfInterested.size(); i++) {
            System.out.println("teste. zé !! notifiy observers pelo  ExpenseRepositoryImpl");
            listOfInterested.get(i).update();
        }
    }

}


    /*//<editor-fold desc="isViolated not necessary here ">
    public boolean isViolated(Expense expense) {

        // get info to the LimitExpense repository:
        ListExpenseLimitsController listExpenseLimitsController = new ListExpenseLimitsController();
        List<ExpenseLimit> listOfExpenseLimits = listExpenseLimitsController.getAllExpenseLimits();

        // verify violation:
        for (int i = 0; i < listOfExpenseLimits.size(); i++) {

            ExpenseType expenseType = listOfExpenseLimits.get(i).getExpenseType();

            if (expenseType.description().equalsIgnoreCase(expense.getExpenseType().description())) {

                if (expense.getAmount().intValue() > listOfExpenseLimits.get(i).getLimitsByExpenseType(expense.getExpenseType()).getBudgetLimitValue()) {

                    System.out.println("this expense ( " + expense.getAmount().intValueExact() +
                            " ) is away beyond the " + expense.getExpenseType().description() + " buget limit ( " +
                            listOfExpenseLimits.get(i).getLimitsByExpenseType(expenseType).getBudgetLimitValue() + " )  !!!! ");
                    return true;
                }

                int totalExpensesValue = getTotalExpensesByExpenseType(expense.getExpenseType());

                if (totalExpensesValue > 0.01 * listOfExpenseLimits.get(i).getLimitYellow() * listOfExpenseLimits.get(i).getBudgetLimitValue()) {

                    System.out.println("test : this expense ( " + expense.getAmount().intValueExact() +
                            " ) will cross the " + expense.getExpenseType().description() + " yellow alert limit ( " +
                            listOfExpenseLimits.get(i).getLimitYellow() + " % )  !!!! . Total expenses of this type = " + totalExpensesValue);
                    return true;
                }

                if (totalExpensesValue > 0.01 * listOfExpenseLimits.get(i).getLimitRed() * listOfExpenseLimits.get(i).getBudgetLimitValue()) {

                    System.out.println("test : this expense ( " + expense.getAmount().intValueExact() +
                            " ) will cross the " + expense.getExpenseType().description() + " red alert limit ( " +
                            listOfExpenseLimits.get(i).getLimitRed() + " % )  !!!! . Total expenses of this type = " + totalExpensesValue);
                    return true;
                }

            }

        }


        return false;
    }
    //</editor-fold>*/



