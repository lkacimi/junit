/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.txbiomed.application.spring;

import org.springframework.stereotype.Component;


/**
 *
 * @author lkacimi
 */
@Component
public class Converter  implements ConversionService{

    @Override
    public int convert(int number) {
        return number * 2;    
    }
    
}
