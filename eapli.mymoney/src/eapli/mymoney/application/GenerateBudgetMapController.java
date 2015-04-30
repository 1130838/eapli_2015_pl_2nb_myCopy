/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.application;

import eapli.mymoney.domain.Budget;
import eapli.mymoney.domain.BudgetMap;
import eapli.mymoney.persistence.BudgetRepository;
import eapli.mymoney.persistence.Persistence;
import eapli.mymoney.persistence.RepositoryFactory;
import java.util.List;

/**
 *
 * @author pag
 */
public class GenerateBudgetMapController {

    Budget m_bu;
    RepositoryFactory repo;
    List<Budget> m_listBu;
    BudgetMap m_bumap;

    public GenerateBudgetMapController() {
        this.m_listBu = getRepositoryFactory();

    }

    public List<Budget> getRepositoryFactory() {
        BudgetRepository repo = Persistence.getRepositoryFactory().
                getBudgetRepository();
        return repo.all();
    }

    public BudgetMap selectBudget(int bgSelect) {

        this.m_bumap = new BudgetMap(m_listBu.get(bgSelect));
        this.m_bumap = this.m_bumap.calculateForecast();
        return m_bumap;
    }
}
