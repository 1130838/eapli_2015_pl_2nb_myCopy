package eapli.mymoney.persistence;

import eapli.framework.model.Money;
import eapli.mymoney.domain.Expense;
import eapli.mymoney.domain.ExpenseType;
import eapli.mymoney.domain.Period;
import java.util.List;

/**
 * Created by brunodevesa on 16/04/15.
 */
public interface ExpenseRepository {

	boolean add(Expense entity);

	long size();

	List<Expense> all();

	public Money getWeekExpediture(Period period);

	public Money getMonthExpediture(Period period);

    public int getTotalExpensesByExpenseType(ExpenseType expenseType);
}
