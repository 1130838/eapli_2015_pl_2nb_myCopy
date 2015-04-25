/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.presentation;

import eapli.mymoney.application.ListPaymentMethodController;
import eapli.mymoney.domain.PaymentMethod;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class ListPaymenteMethodsUI extends BaseUI {

    private final ListPaymentMethodController theController = new ListPaymentMethodController();

    @Override
    protected boolean doShow() {
        final List<PaymentMethod> paymentMethod = theController.getAllPaymentMethod();

        for (int i = 0; i < paymentMethod.size(); i++) {
            System.out.println(i + " - " + paymentMethod.get(i).description());
        }
        return true;
    }

    @Override
    public String headline() {
        return "List Paymente Methods";
    }

}
