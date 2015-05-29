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
            listOfInterested.get(i).update();
        }
    }

}



