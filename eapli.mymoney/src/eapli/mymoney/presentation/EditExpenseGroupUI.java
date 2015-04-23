/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.presentation;

import eapli.mymoney.application.EditExpenseGroupController;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author joaomonteiro
 */
public class EditExpenseGroupUI extends BaseUI {

    /**
     * Controller of the UC.
     */
    private final EditExpenseGroupController controller
            = new EditExpenseGroupController();

    /**
     * Name of the expense group to change data.
     */
    private String expenseGroup;

    /**
     * Begin of period.
     */
    private Calendar beginPeriod;
    /**
     * End of period.
     */
    private Calendar endPeriod;
    /**
     * The value of the budget estimation.
     */
    private BigDecimal estimation;

    public List<String> getListExpenseGroup() {

        return controller.getListExpenseGroup();
    }

    /**
     * Show list of Expense groups and its data to change.
     *
     * @return true
     */
    @Override
    protected boolean doShow() {
        List<String> listExpenseGroups = getListExpenseGroup();

        return true;

    }

    @Override
    public String headline() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void submit() {

    }

}
