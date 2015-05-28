package eapli.mymoney.bootstrap;

import eapli.mymoney.application.ListExpenseTypesController;
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
        ListExpenseTypesController listExpenseTypesController = new ListExpenseTypesController();

        List<ExpenseType> listOfExpenseTypes = listExpenseTypesController.getAllExpenseTypes();

        int limitYellow = 50;
        int limitRed = 75;
        int budgetLimitValue = 100;

        // here you can define the different limits for any type of ExpenseType. for now its just increase 100,5,5 for testing purposes
        for (int i = 0; i < listOfExpenseTypes.size(); i++) {
            try {
                registerExpenseLimitController.registerExpenseLimit(budgetLimitValue + 100, limitYellow + 5, limitRed + 5, listOfExpenseTypes.get(i));
            } catch (IllegalStateException ex) {

            }
        }


      }
}
