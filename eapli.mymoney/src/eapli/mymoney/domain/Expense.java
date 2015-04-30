package eapli.mymoney.domain;

import java.math.BigDecimal;
import java.util.Calendar;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Created by brunodevesa on 16/04/15.
 */
@Entity
public class Expense {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idExpense;

	BigDecimal amount;

	@ManyToOne(cascade = CascadeType.ALL)
	private ExpenseType expenseType;

	@ManyToOne(cascade = CascadeType.ALL)
	private PaymentMethod paymentMethod;

	@Temporal(TemporalType.DATE)
	private Calendar date;

	public Expense(BigDecimal amount, ExpenseType expenseType,
				   PaymentMethod paymentMethod, Calendar date) {
		this.amount = amount;
		this.expenseType = expenseType;
		this.paymentMethod = paymentMethod;
		this.date = date;
	}

	public Expense() {
		// for ORM purposes
	}

	/**
	 * getDate method
	 *
	 * @return Calendar w/date
	 */
	public Calendar getDate() {
		return date;
	}

	/**
	 * getAmount method
	 *
	 * @return returns the amount of this expense
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return "Expense{"
			+ "idExpense = " + idExpense
			+ ", amount = " + amount
			+ ", expenseType = " + expenseType.description()
			+ ", paymentMethod = " + paymentMethod.description()
			+ ", date = " + date.get(Calendar.DAY_OF_MONTH) + "/" + date.
			get(Calendar.MONTH) + "/" + date.get(Calendar.YEAR)
			+ '}';
	}
}
