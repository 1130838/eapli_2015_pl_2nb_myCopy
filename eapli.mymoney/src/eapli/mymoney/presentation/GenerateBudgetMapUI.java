/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.mymoney.presentation;

import eapli.mymoney.application.GenerateBudgetMapController;

/**
 *
 * @author pag
 */
public class GenerateBudgetMapUI extends BaseUI{

    GenerateBudgetMapController m_map;

    public GenerateBudgetMapUI() {
        this.m_map = new GenerateBudgetMapController();
    }
    
    @Override
    public final boolean doShow() {
       
        

        return true;
    }
    
    @Override
    public final String headline() {
        return "override";
    }

}
