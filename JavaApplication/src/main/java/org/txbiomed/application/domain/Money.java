/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.txbiomed.application.domain;

import java.util.Objects;

/**
 *
 * @author lkacimi
 */
public class Money {
    private final int amount;
    private final String currency;

    public Money(Integer amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public int getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }
    @Override
    public boolean equals(Object anObject){
        if(anObject instanceof Money){
            Money money = (Money) anObject;
            return money.getAmount() == this.getAmount() 
                    &&
                   money.getCurrency().equals(this.getCurrency());
        }
        
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.amount;
        hash = 89 * hash + Objects.hashCode(this.currency);
        return hash;
    }
}
