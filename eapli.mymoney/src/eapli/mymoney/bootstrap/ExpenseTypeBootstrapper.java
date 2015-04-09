/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.bootstrap;

import eapli.mymoney.application.RegisterExpenseTypeController;

/**
 *
 * @author Paulo Gandra Sousa
 */
class ExpenseTypeBootstrapper {

    public void execute() {
        final RegisterExpenseTypeController controller = new RegisterExpenseTypeController();

        // FIXME rever como devemos por este código mais elegante
        try {
            controller.registerExpenseType("Vestuario");
        } catch (IllegalStateException ex) {
            //nothing to do
        }
        // FIXME rever como devemos por este código mais elegante
        try {
            controller.registerExpenseType("Transportes");
        } catch (IllegalStateException ex) {
            //nothing to do
        }
    }
}
