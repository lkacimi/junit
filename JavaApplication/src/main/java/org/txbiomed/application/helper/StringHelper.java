/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.txbiomed.application.helper;

/**
 *
 * @author lkacimi
 */
public class StringHelper {

    /**
     *
     * @param s
     * @return
     */
    public String truncateAInFirst2Positions(String s){
        if(s.length()<=2){
            return s.replaceAll("A", "");
        }
        
        String first2Chars = s.substring(0,2);
        String stringMinusFirst2Chars = s.substring(2);
        
        return first2Chars.replaceAll("A", "") + stringMinusFirst2Chars; 
    }
    
    /**
     *
     * @param str
     * @return true if last and last characters of string are the same, false otherwise
     */
    public boolean areFirstAndLastCharactersTheSame(String str){
        if(str.length()<=1){
            return false;
        }
        
        
        
        return str.charAt(0) == str.charAt(str.length()-1);
    }
}
