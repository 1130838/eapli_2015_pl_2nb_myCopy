package eapli.mymoney.bootstrap;

import eapli.mymoney.application.RegisterExpenseLimitController;
import eapli.mymoney.domain.ExpenseType;
import eapli.mymoney.persistence.ExpenseTypeRepository;
import eapli.mymoney.persistence.jpa.ExpenseTypeRepositoryImpl;

import java.util.List;

/**
 * Created by brunodevesa on 22/05/15.
 */
public class ExpenseLimitBootstrapper {

    public void execute() {
        final RegisterExpenseLimitController registerExpenseLimitController = new RegisterExpenseLimitController();

        ExpenseTypeRepository expenseTypeRepository = new ExpenseTypeRepositoryImpl();
        List<ExpenseType> listOfExpenseTypes = expenseTypeRepository.all();
        int limitYellow = 50;
        int limitRed = 75;

        for (int i = 0; i < listOfExpenseTypes.size(); i++) {
            try {
                registerExpenseLimitController.registerExpenseLimit(limitYellow, limitRed, listOfExpenseTypes.get(i));
            } catch (IllegalStateException ex) {
                //nothing to do
            }
        }




    }
}
