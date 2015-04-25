/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.application;

import eapli.mymoney.domain.PaymentMethod;
import eapli.mymoney.persistence.Persistence;
import eapli.mymoney.persistence.PaymentMethodsRepository;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class ListPaymentMethodController {

    PaymentMethodsRepository repo = Persistence.getRepositoryFactory().getPaymentMethodRepository();

    public List<PaymentMethod> getAllPaymentMethod() {

        return repo.all();
    }

    public Iterator<PaymentMethod> iterator() {
        return repo.iterator(1);
    }
}
