/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.bootstrap;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class Bootstraper {

    public void execute() {
        ExpenseTypeBootstrapper expensetype = new ExpenseTypeBootstrapper();
        expensetype.execute();
        PaymentMethodBootstrapper paymentMethodBootstrapper = new PaymentMethodBootstrapper();
        paymentMethodBootstrapper.execute();
    }
}
