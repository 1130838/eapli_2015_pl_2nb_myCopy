/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.application;

import eapli.mymoney.domain.Budget;
import eapli.mymoney.persistence.RepositoryFactory;
import java.util.List;

/**
 *
 * @author pag
 */
public class GenerateBudgetMapConroller {

    Budget m_bu;
    RepositoryFactory repo;
    List<Budget> m_listBu;

    public GenerateBudgetMapConroller() {
        this.m_listBu = getRepositoryFactory();

    }

    public List<Budget> getRepositoryFactory() {
        BudgetRepository repo = Persistence.getRepositoryFactory().
                getBudgetRepository();
        return repo.all();
    }
}
