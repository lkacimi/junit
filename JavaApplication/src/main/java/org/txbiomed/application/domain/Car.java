/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.txbiomed.application.domain;

/**
 *
 * @author lkacimi
 */
public interface Car {
    boolean needsFuel();
    double getEngineTemperature();
    void driveTo(String destination);
}
