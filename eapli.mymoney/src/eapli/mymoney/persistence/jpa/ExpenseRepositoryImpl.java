package eapli.mymoney.persistence.jpa;

import eapli.framework.model.Money;
import eapli.framework.persistence.jpa.JpaRepository;
import eapli.mymoney.application.ListExpenseLimitsController;
import eapli.mymoney.domain.*;
import eapli.mymoney.persistence.ExpenseRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brunodevesa on 16/04/15.
 */
public class ExpenseRepositoryImpl
	extends JpaRepository<Expense, Integer>
	implements ExpenseRepository , Observable{ // Observable is not working correctly yet

    List<Observer> listOfInterested = new ArrayList<>();

    public ExpenseRepositoryImpl() {
        isViolated();
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

    public boolean isViolated(){
        ListExpenseLimitsController listExpenseLimitsController = new ListExpenseLimitsController();
        List<ExpenseLimit> listOfExpenseLimits = listExpenseLimitsController.getAllExpenseLimits();

        List<Expense> listOfExpenses = this.all();


       // System.out.println("testing isViolated from ExpenseRepositoryImpl");

        // how i validate the entry of the expense ? ( add() methos is immplemented by JPARepostory - abstract classs) .....
        notifyObservers();
        return true;
    }

}
